package kz.singularity.jetpackcomposemost.data

import kz.singularity.jetpackcomposemost.domain.model.Post
import retrofit2.http.GET

interface PostsService {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}