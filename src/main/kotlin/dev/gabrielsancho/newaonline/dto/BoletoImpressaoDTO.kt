package dev.gabrielsancho.newaonline.dto

data class BoletoImpressaoDTO(
    val unidade: String,
    val codBoleto: Long,
    val carteira: String,
    val nossoNumero: String,
    val debitoAutomatico: String,
    val idInstituicao: String,
    val dataProc: Long,
    val turmaPreferencial: String,
    val codAluno: String,
    val codCurso: String,
    val nomeCurso: String,
    val cobranDisc: String,
    val codSerie: Int,
    val codTurno: String,
    val codTurnoAluno: String,
    val nomeCompleto: String,
    val enderecoAluno: String,
    val numeroEnderecoAluno: String,
    val complementoEnderecoAluno: String,
    val bairroAluno: String,
    val cepAluno: String,
    val dataVencimento: Long,
    val dataVencUtil: Long,
    val numCobranca: Int,
    val codCobranca: Long,
    val anoParcela: Int,
    val mesParcela: Int,
    val codBanco: String,
    val nomeBanco: String,
    val agencia: String,
    val contaBanco: String,
    val titularConta: String,
    val municipioSacado: String,
    val ufSacado: String,
    val nomeSacado: String,
    val codResponsavelFinanceiro: String,
    val enderecoSacado: String,
    val numeroEnderecoSacado: String,
    val complementoEnderecoSacado: String,
    val bairroSacado: String,
    val cepSacado: String,
    val cpfResponsavel: String,
    val cnpjCedente: String,
    val inscricaoMunicipalCedente: String,
    val localPagamento: String,
    val arquivoCobranca: String,
    val tipo21: String,
    val ipteSemVencimentoSemValor: String,
    val imprimeObsBolsa: String,
    val adicionaObsMulta: String,
    val adicionaObsJuros: String,
    val aceite: String,
    val especieDoc: String,
    val modelo: Int,
    val tituloSacado: String,
    val valorBolsaBoleto: Int,
    val valorDoc: Double,
    val valorSacado: Double,
    val banco: Int,
    val nomeBancoVinculado: String,
    val cedente: String,
    val ipte: String,
    val numeroGeradorCodBarra: String,
    val tituloNossoNumero: String,
    val tituloUsoBanco: String,
    val tituloSacadorAvalista: String,
    val tituloCodigoBaixa: String,
    val quantidade: String,
    val agenciaCedente: String,
    val numeroDocumento: String,
    val numeroDocumentoRecibo: String,
    val tituloDocumentoRecibo: String,
    val textoDuplicataFiduciaria: String,
    val instrucaoD0: String,
    val valor: Double,
    val parcela: String,
    val numeroParcela: Int,
    val tipoParcela: String,
    val foneCedente: String,
    val tituloAutenticacao: String,
    val enderecoCedente: String,
)

