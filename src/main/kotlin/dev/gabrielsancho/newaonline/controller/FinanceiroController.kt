package dev.gabrielsancho.newaonline.controller

import dev.gabrielsancho.newaonline.dto.BoletoImpressaoDTO
import dev.gabrielsancho.newaonline.service.FinanceiroService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/financeiro")
class FinanceiroController(
    val service: FinanceiroService
) {

    @GetMapping("/boletos")
    fun boletos(): ResponseEntity<List<BoletoImpressaoDTO>> {
        return ResponseEntity<List<BoletoImpressaoDTO>>(service.boletos(), HttpStatus.OK)
    }
}
