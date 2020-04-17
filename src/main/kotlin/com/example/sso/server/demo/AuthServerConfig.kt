package com.example.sso.server.demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer


/**
 * This class is for trying out client application token authorozation and SSO
 */

//@Configuration
//@EnableAuthorizationServer
//@Order(2)
class AuthServerConfig : AuthorizationServerConfigurerAdapter() {

//    @Throws(Exception::class)
//    override fun configure(
//            oauthServer: AuthorizationServerSecurityConfigurer) {
//        oauthServer.tokenKeyAccess("permitAll()")
//                .checkTokenAccess("isAuthenticated()")
//    }
//
//    @Throws(Exception::class)
//    override fun configure(clients: ClientDetailsServiceConfigurer) {
//        clients.inMemory()
//                .withClient("SampleClientId")
//                .secret(passwordEncoder().encode("secret"))
//                .authorizedGrantTypes("authorization_code")
//                .scopes("user_info")
//                .autoApprove(true)
//                .redirectUris(
//                        "http://localhost:8082/ui/login", "http://localhost:8083/ui2/login")
//    }
//
//    @Bean
//    fun passwordEncoder(): BCryptPasswordEncoder {
//        return BCryptPasswordEncoder()
//    }

}
