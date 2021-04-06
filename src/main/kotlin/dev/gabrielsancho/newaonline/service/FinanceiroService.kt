package dev.gabrielsancho.newaonline.service

import dev.gabrielsancho.newaonline.dto.BoletoImpressaoDTO
import dev.gabrielsancho.newaonline.repository.FinanceiroRepository
import org.springframework.stereotype.Service

@Service
class FinanceiroService(
    val repository: FinanceiroRepository
) {
    fun boletos(): List<BoletoImpressaoDTO> {
        return repository.boletoImpressaoFacade()
    }
}