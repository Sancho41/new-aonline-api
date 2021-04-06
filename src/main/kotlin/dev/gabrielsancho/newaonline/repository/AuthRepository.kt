package dev.gabrielsancho.newaonline.repository

import dev.gabrielsancho.newaonline.domain.User
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.toEntity
import reactor.core.publisher.Mono

@Repository
class AuthRepository {
    private val AUTH_URL = "https://aluno.iesb.br/aluno/auth"

    fun login(username: String, password: String): User {
        val response = WebClient.create("https://aluno.iesb.br/aluno/auth")
            .method(HttpMethod.POST)
            .body(BodyInserters.fromValue("username=${username}&password=${password}"))
            .header("Content-Type", "application/x-www-form-urlencoded")
            .retrieve()
            .toEntity<UserDataDTO>()
            .block()

        return User(response?.body?.id!!, username, password, response.headers["Set-Cookie"]?.get(0)!!)
    }

    data class UserDataDTO(
        val id: String
    )
}
