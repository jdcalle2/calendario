package com.example.academico.security
import com.example.academico.service.GymUserDetailsService
import com.example.academico.security.filter.JwtFilterRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@EnableWebSecurity

class SecutiryConfiguration: WebSecurityConfigurerAdapter() {
    @Autowired
    lateinit var gymUserDetailsService:GymUserDetailsService

    @Autowired
    lateinit var jwtFilterRequest:JwtFilterRequest

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.userDetailsService(gymUserDetailsService)
    }

    override fun configure(http: HttpSecurity) {
        http.csrf()?.disable()
            ?.authorizeRequests()?.antMatchers("/**/auth")
            ?.permitAll()?.anyRequest()?.authenticated()
            ?.and()?.sessionManagement()
            ?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter::class.java)
    }
    @Bean
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

}