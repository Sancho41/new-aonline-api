package dev.gabrielsancho.newaonline.repository

import dev.gabrielsancho.newaonline.dto.AOnlinePagDTO
import dev.gabrielsancho.newaonline.dto.CurrentUserDTO
import dev.gabrielsancho.newaonline.dto.HorarioDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Repository
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.toEntity

@Repository
class AcademicoRepository {
    @Autowired
    lateinit var currentUserDTO: CurrentUserDTO

    fun horarios(): List<HorarioDTO> {
        val user = currentUserDTO.user!!

        val response = WebClient
            .create("https://aluno.iesb.br/aluno/apix/api/rest/alunos/codPessoa/${user.id}/codAluno/${user.username}/dia/0/HorariosAula?page=0&size=1000")
            .method(HttpMethod.GET)
            .header("cookie", user.cookie)
            .retrieve()
            .toEntity<AOnlinePagDTO<HorarioDTO>>()
            .block()

        return response?.body?.content!!
    }
}