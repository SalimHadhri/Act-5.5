package com.thp.spring.simplecontext.security;

import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.thp.spring.simplecontext.repository.UserRepository;

/**
 * Config role-based auth.
 */
@Configuration
@EnableWebSecurity
public class SecurityGeneralConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserPrincipalDetailsService userPrincipalDetailsService;
	
    @Autowired
    private UserRepository userRepository;
    
    

	public void SecurityConfiguration(UserPrincipalDetailsService userPrincipalDetailsService) {
		this.userPrincipalDetailsService = userPrincipalDetailsService; // injected directly into the security
																		// configuration
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
		httpSecurity.
				csrf().disable()
				.logout().disable()
				.formLogin().disable()
				// .logout().disable()
				// .formLogin().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				// make sure we use stateless session; session won't be used to store user's
				// state.
				.anonymous().and()
				// handle an authorized attempts
				.exceptionHandling()
				.authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED)).and()
				.addFilter(new JwtGeneralAuthenticationFilter(authenticationManager()))
				.addFilter(new JwtAuthorizationFilter(authenticationManager(),this.userRepository))
				.authorizeRequests()
				// authentication
				.antMatchers(HttpMethod.POST, "/userManagement/auth").permitAll()
				// announcement
				.antMatchers(HttpMethod.GET, "/userManagement/ListAllUser").hasAnyRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/userManagement/addUser").permitAll()
				.antMatchers(HttpMethod.PUT, "/userManagement/updateUser/{id}").hasRole("USER")
				.antMatchers(HttpMethod.GET, "/userManagement/findUser/{id}").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/userManagement/deleteUser/{id}").hasRole("ADMIN").anyRequest()
				.authenticated();

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