package kz.singularity.jetpackcomposemost.users

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kz.singularity.jetpackcomposemost.RetrofitBuilder
import kz.singularity.jetpackcomposemost.User

data class UsersState(
    val users: List<User> = emptyList(),
    val isLoading: Boolean = true,
)

class UsersViewModel : ViewModel() {
    private val _state = mutableStateOf(UsersState())
    val state: State<UsersState> = _state

    init {
        loadUsers()
    }

    private fun loadUsers() {
        val apiService = RetrofitBuilder.apiService
        viewModelScope.launch(Dispatchers.IO) {
            val remoteUsers = apiService.getUsers()
            _state.value = _state.value.copy(users = remoteUsers, isLoading = false)
        }
    }
}