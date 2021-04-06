package dev.gabrielsancho.newaonline.service

import dev.gabrielsancho.newaonline.domain.User
import dev.gabrielsancho.newaonline.repository.AuthRepository
import org.springframework.stereotype.Service

@Service
class AuthService(
    val repository: AuthRepository
) {

    fun login(username: String, password: String): User {
        return repository.login(username, password)
    }
}
