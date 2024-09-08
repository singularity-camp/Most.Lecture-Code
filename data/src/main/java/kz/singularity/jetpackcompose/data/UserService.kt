package kz.singularity.jetpackcompose.data

import kz.singularity.jetpackcomposemost.domain.model.User
import retrofit2.http.GET

// %Name%Service
// Example: UserService, NewsService, PostService
interface UserService {

    @GET("users")
    suspend fun getUsers(): List<User>

}