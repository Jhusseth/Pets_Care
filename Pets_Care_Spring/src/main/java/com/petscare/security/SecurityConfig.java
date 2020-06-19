package com.petscare.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private LoggingAccessDeniedHandler accessDeniedHandler;

	@Autowired
	private MyCustomUserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(encoder());
		return authProvider;
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(11);  
	}
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("login/login.html").setViewName("login.html");
	    registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}
	

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {	
		httpSecurity.csrf().disable()
        .authorizeRequests()
        .antMatchers("/h2-console/**").access("hasRole('superAdmin')")
		.antMatchers("/admins").access("hasRole('superAdmin')")
		.antMatchers("/admins/add","/admins/add/**","/admins/edit/","/admins/del/**").access("hasRole('superAdmin')")
		.antMatchers("/games").access("hasRole('admin') or hasRole('superAdmin')")
		.antMatchers("/games/add/**","/games/edit/**","/games/del/**","/games/stories/**").access("hasRole('admin') or hasRole('superAdmin')")
		.antMatchers("/games/topic/**","/games/topic/edit/**","/games/topic/del/**").access("hasRole('superAdmin')")
		.antMatchers("/stories").access("hasRole('superAdmin') or hasRole('admin')")
		.antMatchers("/stories/**","/stories/add","/stories/add/**","/stories/edit/","/stories/del/**").access("hasRole('superAdmin') or hasRole('admin')")
		.antMatchers("/topics").access("hasRole('superAdmin') or hasRole('admin')")
		.antMatchers("/topics/add","/topics/add/**","/topics/edit/","/topics/del/**").access("hasRole('superAdmin')")
		.antMatchers("/h2-console/**").hasRole("superAdmin")
		.antMatchers("/api/**").permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .permitAll()
        .and()
        .logout()
        .invalidateHttpSession(true)
        .clearAuthentication(true)
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/login?logout")
        .permitAll()
        .and()
        .exceptionHandling()
        .accessDeniedHandler(accessDeniedHandler);	
	}
}