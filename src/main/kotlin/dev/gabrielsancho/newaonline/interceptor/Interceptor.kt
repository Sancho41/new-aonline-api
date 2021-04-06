package dev.gabrielsancho.newaonline.interceptor

import dev.gabrielsancho.newaonline.domain.User
import dev.gabrielsancho.newaonline.dto.CurrentUserDTO
import dev.gabrielsancho.newaonline.service.AuthService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.servlet.HandlerInterceptor
import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class Interceptor : HandlerInterceptor {

    @Autowired
    lateinit var currentUserDTO: CurrentUserDTO

    @Autowired
    lateinit var authService: AuthService

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val authorization = request.getHeader("Authorization")
        val userAuthDTO = getUserAuthFromBasicAuth(authorization)

        val lastAcess = LocalDateTime.ofInstant(
            Instant.ofEpochMilli(request.session.lastAccessedTime),
            TimeZone.getDefault().toZoneId()
        )

        val diff = Duration.between(lastAcess, LocalDateTime.now()).toMinutes()

        if (diff > 3L || !userAuthDTO.equal(currentUserDTO.user))
            currentUserDTO.user = null

        currentUserDTO.user = authService.login(userAuthDTO.username, userAuthDTO.password)

        return true
    }

    private fun getUserAuthFromBasicAuth(header: String): UserAuthDTO {
        val encodedCrendentials = header.substring("Basic ".length).trim()
        val decodedByte = Base64.getDecoder().decode(encodedCrendentials)
        val decoded = String(decodedByte)

        val user = decoded.substring(0, decoded.indexOf(":"))
        val password = decoded.substring(decoded.indexOf(":") + 1)
        return UserAuthDTO(user, password)
    }

    data class UserAuthDTO(
        val username: String,
        val password: String
    ) {
        fun equal(user: User?): Boolean {
            return username != user?.username || password != user.password
        }
    }
}
