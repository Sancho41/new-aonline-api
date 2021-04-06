package dev.gabrielsancho.newaonline.dto

data class BoletoDTO (
    val id: String,
    val codigoBoleto: String,
    val valor: String,
    val tipoCobranca: String
)
