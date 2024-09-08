package kz.singularity.jetpackcomposemost.domain.repository

import kz.singularity.jetpackcomposemost.domain.model.User

interface UserRepository {
    suspend fun getUsers(): List<User>
}