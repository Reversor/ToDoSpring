package io.github.reversor.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //TODO разобраться
        http.addFilter(authenticationFilter())
                .exceptionHandling().authenticationEntryPoint(authEntryPoint())
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and().csrf().disable();

        http.httpBasic().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        super.configure(auth);
    }

    @Bean
    public AuthenticationEntryPoint authEntryPoint() {
        DigestAuthenticationEntryPoint entryPoint = new DigestAuthenticationEntryPoint();
        //TODO
        entryPoint.setRealmName("");

        return entryPoint;
    }

    @Bean
    public DigestAuthenticationFilter authenticationFilter() {
        DigestAuthenticationFilter authenticationFilter = new DigestAuthenticationFilter();
        //TODO
        authenticationFilter.setUserDetailsService(null);

        return authenticationFilter;
    }
}
