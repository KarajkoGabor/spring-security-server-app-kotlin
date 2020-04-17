package com.example.sso.server.demo

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.core.Authentication
import org.springframework.security.core.annotation.CurrentSecurityContext
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.security.Principal


@Controller
class UserController {

    private val logger: Logger = LoggerFactory.getLogger(UserController::class.java)

    @GetMapping("/")
    fun index(): String {
        return "index"
    }

    @GetMapping("/user/index")
    fun userIndex(): String {
        return "/user/index"
    }

//    @RequestMapping("/log-in")
//    fun login(): String {
//        return "login"
//    }

    @GetMapping("/authentication")
    fun getAuthentication(@CurrentSecurityContext(expression = "authentication") authentication: Authentication): Any? {
        logger.info("authentication -> {}", authentication)
        return authentication.getDetails()
    }

    @GetMapping("/principal")
    fun getPrincipal(@CurrentSecurityContext(expression = "authentication.principal") principal: Principal): String? {
        logger.info("principal -> {}", principal)
        return principal.name
    }

//     Login form
    @GetMapping("/login")
    fun login(): String? {
        return "login"
    }

    /** Login form with error.  */
    @RequestMapping("/login-error.html")
    fun loginError(model: Model): String? {
        model.addAttribute("loginError", true)
        return "login"
    }

    @GetMapping("/403")
    fun getAccessDeniedPage(): String? {
        return "403.html"
    }

    @RequestMapping("/index")
    fun getIndexPage(): String? {
        return "index.html"
    }

}
