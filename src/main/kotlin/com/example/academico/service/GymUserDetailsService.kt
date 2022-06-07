package com.example.academico.service
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.ArrayList

@Service
class GymUserDetailsService : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        return User("user","{noop}admin", ArrayList())
    }

}