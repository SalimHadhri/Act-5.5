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
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.thp.spring.simplecontext.repository.UserRepository;

/**
 * Config role-based auth.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	




	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.csrf().disable().logout().disable().formLogin().disable()
				// .logout().disable()
				// .formLogin().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				// make sure we use stateless session; session won't be used to store user's
				// state.
				.anonymous().and()
				// handle an authorized attempts
				.exceptionHandling()
				.authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED)).and()
				.addFilter(new JwtAuthenticationFilter(authenticationManager()))
				.addFilter(new JwtAuthorizationFilter(authenticationManager(), this.userRepository))
				.authorizeRequests()
				.antMatchers("/userManagement/auth").permitAll()
				// announcement
				.antMatchers(HttpMethod.POST, "/announcementManagement/**").permitAll()
				.antMatchers(HttpMethod.GET, "/announcementManagement/**").permitAll()
				.antMatchers(HttpMethod.DELETE, "/announcementManagement/**").permitAll()
				.antMatchers(HttpMethod.PUT, "/announcementManagement/**").permitAll()
				.antMatchers("/announcementManagement/ListAnnouncement").hasAnyRole("MANAGER")
				.antMatchers("/announcementManagement/addAnnouncement").hasRole("ADMIN")
				.antMatchers("/announcementManagement/deleteAnnouncement/{id}").hasAnyRole("ADMIN")
				.antMatchers("/announcementManagement/updateAnnouncement/{id}").hasAnyRole("MANAGER")
				.antMatchers("/announcementManagement/findAnnouncement/{id}").hasAnyRole("USER")
				// users
				.antMatchers(HttpMethod.GET, "/userManagement/**").permitAll()
				.antMatchers(HttpMethod.POST, "/userManagement/**").permitAll()
				.antMatchers(HttpMethod.DELETE, "/userManagement/**").permitAll()
				.antMatchers(HttpMethod.PUT, "/userManagement/**").permitAll()
				.antMatchers("/userManagement/ListAllUser").hasRole("ADMIN")
				.antMatchers("/userManagement/addUser").hasAnyRole("ADMIN","USER")
				.antMatchers("/userManagement/updateUser/{id}").hasAnyRole("ADMIN","USER")
				.antMatchers("/userManagement/findUser/{id}").hasAnyRole("MANAGER","ADMIN")
				.antMatchers("/userManagement/deleteUser/{id}").hasAnyRole("ADMIN")

				
				.anyRequest().authenticated();

	}
	
	

    @Autowired
    private UserPrincipalDetailsService userPrincipalDetailsService ;
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
        auth.authenticationProvider(authenticationProvider()) ;
    }
	
	
	
	 @Bean
	    DaoAuthenticationProvider authenticationProvider(){
	        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider()  ;
	        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
	        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);

	        return daoAuthenticationProvider ;
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
