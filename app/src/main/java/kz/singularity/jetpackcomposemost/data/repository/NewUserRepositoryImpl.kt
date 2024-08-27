package kz.singularity.jetpackcomposemost.data.repository

import kz.singularity.jetpackcomposemost.domain.model.User
import kz.singularity.jetpackcomposemost.domain.repository.UserRepository
import javax.inject.Inject

class NewUserRepositoryImpl @Inject constructor() : UserRepository {
    override suspend fun getUsers(): List<User> {
        return emptyList()
    }
}