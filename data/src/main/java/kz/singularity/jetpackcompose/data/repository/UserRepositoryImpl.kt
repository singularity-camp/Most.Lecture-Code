package kz.singularity.jetpackcompose.data.repository

import android.util.Log
import kz.singularity.jetpackcompose.data.UserService
import kz.singularity.jetpackcompose.data.db.dao.PersonDAO
import kz.singularity.jetpackcompose.data.db.entity.Person
import kz.singularity.jetpackcomposemost.domain.model.User
import kz.singularity.jetpackcomposemost.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val service: UserService,
    private val personDAO: PersonDAO,
) : UserRepository {
    override suspend fun getUsers(): List<User> {
        val dbUsers = personDAO.getAll()
        Log.e("UserRepo", "All users stored in DB = $dbUsers")
        if (dbUsers.isEmpty()) {
            val remoteUsers = service.getUsers()
            val usersToStoreInDb =
                remoteUsers.map { Person(id = null, name = it.name, email = it.email) }
            personDAO.insertAll(usersToStoreInDb)
            return remoteUsers
        }

        val usersToShow =
            dbUsers.map { User(avatar = "", email = it.email, id = it.id ?: 0, name = it.name) }

        return usersToShow
    }
}