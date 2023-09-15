package com.poly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	BCryptPasswordEncoder pe;
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/*
	 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) {
	 * 
	 * }
	 * 
	 * @Bean public WebSecurityCustomizer webSecurityCustomizer() {
	 * 
	 * }
	 */
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user1").password(pe.encode("123")).roles("GUEST")
			.and()
			.withUser("user2").password(pe.encode("123")).roles("USER", "GUEST")
			.and()
			.withUser("user3").password(pe.encode("123")).roles("ADMIN","USER","GUEST");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().disable();
		
		// PHÂN QUYỀN
		/*
		 * http.authorizeRequests()
		 * .antMatchers("/home/index","/auth/login/**").permitAll()
		 * .anyRequest().authenticated();
		 */
		http.authorizeRequests()
//			.antMatchers("/home/admins").hasRole("ADMIN")
//			.antMatchers("/home/users").hasAnyRole("ADMIN", "USER")
//			.antMatchers("/home/authenticated").authenticated()
			.anyRequest().permitAll();	// anonymos
		
		
		// Control when authorize not allow
		http.exceptionHandling()
			.accessDeniedPage("/auth/acccess/denied");
		
		
		
		
		//dialog mặc định
		//http.httpBasic();
		http.formLogin()
			.loginPage("/auth/login/form")
			.loginProcessingUrl("/auth/login")
			.defaultSuccessUrl("/auth/login/success", false)
			.failureUrl("/auth/login/error")
			.usernameParameter("username")
			.passwordParameter("password");
		
		http.rememberMe()
			.rememberMeParameter("remember");
		
		
		http.logout()
			.logoutUrl("/auth/logout")
			.logoutSuccessUrl("/auth/logout/success");
		
	}
	
	/*
	 * @Bean public WebSecurityCustomizer webSecurityCustomizer() { return (web) ->
	 * web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**"); }
	 */
	
	
	
	
}
