package com.thp.spring.simplecontext.security;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.thp.spring.simplecontext.repository.UserRepository;

/**
 * Config role-based auth.
 */
@Configuration
public class SecurityGeneralConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserPrincipalDetailsService userPrincipalDetailsService;
	@Autowired
	private UserRepository userRepository;

    public void SecurityConfiguration(  UserPrincipalDetailsService userPrincipalDetailsService, UserRepository userRepository) {
        this.userPrincipalDetailsService = userPrincipalDetailsService; //injected directly into the security configuration
        this.userRepository = userRepository;
    }

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors().and().csrf().disable()
				.exceptionHandling()
				.authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED)).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

				.authorizeRequests()
				// authentication
				.antMatchers(HttpMethod.DELETE,"/userManagement/**").permitAll()
				.antMatchers(HttpMethod.GET,"/userManagement/**").permitAll()
				.antMatchers(HttpMethod.POST,"/userManagement/**").permitAll()
				.antMatchers(HttpMethod.PUT,"/userManagement/**").permitAll()

				.antMatchers("/userManagement/auth").permitAll()
				// announcement
				.antMatchers("/userManagement/ListAllUser").hasRole("ADMIN")
				.antMatchers("/userManagement/addUser").permitAll()
				.antMatchers("/userManagement/updateUser/{id}").hasRole("USER")
				.antMatchers("/userManagement/findUser/{id}").hasRole("ADMIN")
				.antMatchers("/userManagement/deleteUser/{id}").hasRole("ADMIN")
				.anyRequest().authenticated();
		

		httpSecurity.addFilterBefore(new JwtGeneralAuthenticationFilter(authenticationManager()),UsernamePasswordAuthenticationFilter.class)
					.addFilterBefore(new JwtAuthorizationFilter(authenticationManager(),this.userRepository),UsernamePasswordAuthenticationFilter.class) ;
		

		
		
		


	}

	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);

		return daoAuthenticationProvider;
	}

	public UserPrincipalDetailsService getUserPrincipalDetailsService() {
		return userPrincipalDetailsService;
	}

	@Autowired
	public void setUserPrincipalDetailsService(UserPrincipalDetailsService userPrincipalDetailsService) {
		this.userPrincipalDetailsService = userPrincipalDetailsService;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder(); // or any other compatible encoder
		return encoder;
	}
}
