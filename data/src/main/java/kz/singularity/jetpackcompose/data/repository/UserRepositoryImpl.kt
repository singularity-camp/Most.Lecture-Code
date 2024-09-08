package kz.singularity.jetpackcompose.data.repository

import kz.singularity.jetpackcompose.data.UserService
import kz.singularity.jetpackcomposemost.domain.model.User
import kz.singularity.jetpackcomposemost.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val service: UserService
) : UserRepository {
    override suspend fun getUsers(): List<User> {
        return service.getUsers()
    }
}