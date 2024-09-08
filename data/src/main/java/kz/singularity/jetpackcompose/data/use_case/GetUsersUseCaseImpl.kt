package kz.singularity.jetpackcompose.data.use_case

import kz.singularity.jetpackcomposemost.domain.model.User
import kz.singularity.jetpackcomposemost.domain.repository.UserRepository
import kz.singularity.jetpackcomposemost.domain.use_case.GetUsersUseCase
import javax.inject.Inject

class GetUsersUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
) : GetUsersUseCase {
    override suspend fun invoke(): List<User> {
        return userRepository.getUsers()
    }
}