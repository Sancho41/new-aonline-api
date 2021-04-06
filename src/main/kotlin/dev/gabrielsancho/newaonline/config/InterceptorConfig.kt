package dev.gabrielsancho.newaonline.config

import dev.gabrielsancho.newaonline.dto.CurrentUserDTO
import dev.gabrielsancho.newaonline.interceptor.Interceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.context.annotation.ScopedProxyMode




@Configuration
class InterceptorConfig: WebMvcConfigurer {

    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    fun currentUser(): CurrentUserDTO {
        return CurrentUserDTO()
    }

    @Bean
    fun interceptor(): Interceptor = Interceptor()

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(interceptor())
    }
}
