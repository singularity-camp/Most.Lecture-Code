package kz.singularity.jetpackcompose.data.repository

import kz.singularity.jetpackcomposemost.domain.model.User
import kz.singularity.jetpackcomposemost.domain.repository.UserRepository
import javax.inject.Inject

internal class NewUserRepositoryImpl @Inject constructor() : UserRepository {
    override suspend fun getUsers(): List<User> {
        return emptyList()
    }
}