package kz.singularity.jetpackcomposemost.posts

import retrofit2.http.GET

interface PostsService {

    @GET("posts")
    suspend fun getPosts(): List<Post>
}