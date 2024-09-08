package kz.singularity.jetpackcomposemost.domain.model

data class Post(
    val category: String,
    val content: String,
    val id: Int,
    val image: String,
    val publishedAt: String,
    val slug: String,
    val status: String,
    val thumbnail: String,
    val title: String,
    val updatedAt: String,
    val url: String,
    val userId: Int
)