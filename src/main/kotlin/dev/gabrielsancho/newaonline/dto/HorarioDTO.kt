package dev.gabrielsancho.newaonline.dto

data class HorarioDTO(
    val id: String,
    val diaSemana: Int,
    val horaFim: String,
    val horaIni: String,
    val turmaDisciplina: TurmaDisciplinaDTO
)
