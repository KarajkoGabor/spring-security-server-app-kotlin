package com.example.sso.server.demo

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.web.util.matcher.AntPathRequestMatcher


@EnableWebSecurity
@Configuration
class SecurityConfigForUsers : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {

        /**
         * The java way, floating authorize pop-up for all requests
         */
//        http.authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()

        /**
         * The Java way, has login, has logout
         */
        http
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login-error.html")
                .loginProcessingUrl("/login")
//                .loginProcessingUrl("/authentication")
                .permitAll()

                .and()
                .authorizeRequests()
                .antMatchers("/user/**")
                .hasRole("USER")

                .and()
                .authorizeRequests()
                .antMatchers("/admin/**")
                .hasRole("ADMIN")

                .and()
                .httpBasic()

                .and()
                .logout()
                .logoutRequestMatcher(AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")

                .and()
                .exceptionHandling { it.accessDeniedPage("/403") }

    }

//    @Bean
//    override fun userDetailsService(): UserDetailsService {
//
//        val encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
//        val userDetails = User.withUsername("joska")
//                .password(encoder.encode("123"))
//                .roles("USER")
//                .build()
//        val adminDetails = User.withUsername("pista")
//                .password(encoder.encode("123"))
//                .roles("ADMIN")
//                .build()
//        val unknownUserDetails = User.withUsername("bela")
//                .password(encoder.encode("123"))
//                .roles("UNKNOWN")
//                .build()
//        return InMemoryUserDetailsManager(userDetails, adminDetails, unknownUserDetails)
//    }


    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {

        val encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
        auth.inMemoryAuthentication()
                .withUser("joska")
                .password(encoder.encode("123"))
                .roles("USER")
                .and()
                .withUser("pista")
                .password(encoder.encode("123"))
                .roles("ADMIN")
                .and()
                .withUser("bela")
                .password(encoder.encode("123"))
                .roles("unknown")

    }

}
