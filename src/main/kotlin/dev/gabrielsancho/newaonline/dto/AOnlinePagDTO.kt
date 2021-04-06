package dev.gabrielsancho.newaonline.dto

data class Page(
    val size: Int,
    val totalElements: Int,
    val totalPages: Int,
    val number: Int
)

data class Link(
    val rel: String,
    val href: String
)

data class AOnlinePagDTO<T> (
    val content: List<T>,
    val links: List<Link>,
    val page: Page
)
