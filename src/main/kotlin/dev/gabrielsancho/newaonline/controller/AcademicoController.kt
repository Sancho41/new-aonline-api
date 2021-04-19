package dev.gabrielsancho.newaonline.controller

import dev.gabrielsancho.newaonline.dto.HorarioDTO
import dev.gabrielsancho.newaonline.service.AcademicoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/academico")
class AcademicoController(
    val service: AcademicoService
) {

    @GetMapping("/horarios")
    fun horarios(): ResponseEntity<List<HorarioDTO>> {
        return ResponseEntity<List<HorarioDTO>>(service.horarios(), HttpStatus.OK)
    }
}
