package org.elsys.P.trip;

import org.elsys.P.trip.service.MyUserDetailsService;
import org.elsys.P.trip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login*","/login*", "/logout*", "/signin/**", "/signup/**", "/customLogin",
                        "/user/registration*", "/registrationConfirm*", "/expiredAccount*", "/registration*",
                        "/badUser*", "/user/resendRegistrationToken*" ,"/forgetPassword*", "/user/resetPassword*",
                        "/user/changePassword*", "/emailError*", "/resources/**","/old/user/registration*","/successRegister*","/qrcode*","/perform_login")
                .permitAll()
                .anyRequest().hasAuthority("READ_PRIVILEGE")
                .and()
                .formLogin()
                .loginPage("/registration")
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/homepage.html")
                .failureUrl("/login")
                .permitAll();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }
}