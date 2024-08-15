package kz.singularity.jetpackcomposemost

import retrofit2.http.GET

// %Name%Service
// Example: UserService, NewsService, PostService
interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>

}