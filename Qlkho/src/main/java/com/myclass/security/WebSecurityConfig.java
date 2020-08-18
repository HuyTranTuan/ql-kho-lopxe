//package com.myclass.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//@ComponentScan("com.myclass")
//@Order(2)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService)
//		.passwordEncoder(passwordEncoder());
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable()
//		.antMatcher("/user/**")
//		.authorizeRequests()
//		.antMatchers("/user/**")
//		.hasAnyRole("USER", "USER2")
//		.anyRequest()
//		.permitAll()
//		.and()
//		.formLogin()
//		.loginProcessingUrl("/account/login")
//		.usernameParameter("email")
//		.passwordParameter("password")
//		.successHandler(new CustomAuthenticationSuccessHandler())
//		.failureHandler(new CustomAuthenticationFailureHandler())
//		.and()
//		.logout()
//		.logoutUrl("/account/logout")
//		.logoutSuccessUrl("/")
//		.deleteCookies("JSESSIONID")
//		.and()
//		.exceptionHandling()
//		.accessDeniedPage("/403");
//	}
//	
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/assets/**");
//	}
//}
