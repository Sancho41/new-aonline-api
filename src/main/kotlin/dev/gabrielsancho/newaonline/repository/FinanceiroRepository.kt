package dev.gabrielsancho.newaonline.repository

import dev.gabrielsancho.newaonline.dto.AOnlinePagDTO
import dev.gabrielsancho.newaonline.dto.BoletoDTO
import dev.gabrielsancho.newaonline.dto.BoletoImpressaoDTO
import dev.gabrielsancho.newaonline.dto.CurrentUserDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Repository
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.toEntity

@Repository
class FinanceiroRepository {
    @Autowired
    lateinit var currentUserDTO: CurrentUserDTO

    fun boletos() : List<BoletoDTO> {
        val user = currentUserDTO.user!!

        val response = WebClient
            .create("https://aluno.iesb.br/aluno/apix/api/rest/financeiro/codAluno/${user.username}/Boletos?codPessoa=${user.id}&page=0&size=1000")
            .method(HttpMethod.GET)
            .header("cookie", user.cookie)
            .retrieve()
            .toEntity<AOnlinePagDTO<BoletoDTO>>()
            .block()

        return response?.body?.content!!
    }

    fun boletoImpressao(codigoBoleto: String) : BoletoImpressaoDTO {
        val user = currentUserDTO.user!!
        val response = WebClient
            .create("https://aluno.iesb.br/aluno/apix/financeiro/cod_boleto/${codigoBoleto}/obtem_dados_impressao_boleto")
            .method(HttpMethod.GET)
            .header("cookie", user.cookie)
            .retrieve()
            .toEntity<BoletoImpressaoDTO>()
            .block()

        return response?.body!!
    }

    fun boletoImpressaoFacade() : List<BoletoImpressaoDTO> {
        return boletos().map {
            boletoImpressao(it.codigoBoleto)
        }
    }
}
