package pl.com.chrzanowski.scma.security.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import pl.com.chrzanowski.scma.service.impl.UserServiceImpl;

import javax.transaction.Transactional;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig {

    private final UserServiceImpl userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userService);
        return provider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/**")
                .permitAll()
                .antMatchers("/login")
                .permitAll()
                .anyRequest()
                .authenticated().and()
                .formLogin();

        http.authenticationProvider(daoAuthenticationProvider());

        return http.build();
    }
}
