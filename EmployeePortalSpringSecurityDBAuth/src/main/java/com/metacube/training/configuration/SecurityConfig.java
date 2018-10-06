package com.metacube.training.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select email,password, enabled from employee where email=?")
		.authoritiesByUsernameQuery("select username, role from user_roles where username=?");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/admin/*")
				.access("hasRole('ROLE_ADMIN')")
				.antMatchers("/employee/*")
				.access("hasRole('ROLE_EMPLOYEE')")
				.and()
				.formLogin()
				. // login configuration
				loginPage("/login").loginProcessingUrl("/login")
				.defaultSuccessUrl("/default")
				.usernameParameter("email").passwordParameter("password").and()
				.logout().logoutUrl("/Logout")
				// logout configuration
				.logoutSuccessUrl("/login").and().exceptionHandling()
				.accessDeniedPage("/error").and().csrf();

	}
}