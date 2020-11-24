package com.hms.app;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.hms.app.domain.security.services.RoleBasedStartPageService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Resource
	private UserDetailsService appUserDetailsService;
	
	@Resource 
	AuthenticationSuccessHandler roleBasedStartPageService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(appUserDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	    protected void configure(HttpSecurity http) throws Exception {
		
			
			http.csrf().disable().authorizeRequests()
	        .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
	        .antMatchers("/app/**").hasAnyAuthority("CUSTOMER")
	        .antMatchers("/doc/**").hasAnyAuthority("DOCTOR")
	        .antMatchers("/**").permitAll()
	        .and().formLogin()
	        .loginPage("/login").loginProcessingUrl("/perform_login").permitAll()
	          .successHandler(roleBasedStartPageService).and().logout().logoutSuccessUrl("/login?logout")
	          .and().exceptionHandling().accessDeniedPage("/404");
	          
	       
	        
	       
	           
	    }


}
