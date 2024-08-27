package kz.singularity.jetpackcomposemost.domain.use_case

import kz.singularity.jetpackcomposemost.domain.model.User

interface GetUsersUseCase {
    suspend fun invoke(): List<User>
}