package br.com.comsom.budbalance.secutiry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
        .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
        .and()
        .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
        .and()
        .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	       http
	          .csrf().disable()
	          .authorizeRequests()
	          .antMatchers("/brands*").anonymous()
	          .antMatchers("/brands*").permitAll();
	}
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
