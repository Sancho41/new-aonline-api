package dev.gabrielsancho.newaonline.service

import dev.gabrielsancho.newaonline.repository.AcademicoRepository
import org.springframework.stereotype.Service

@Service
class AcademicoService(
    val repository: AcademicoRepository
) {

    fun horarios() = repository.horarios()
}