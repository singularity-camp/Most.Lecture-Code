package kz.singularity.jetpackcomposemost.presentation.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kz.singularity.jetpackcomposemost.domain.model.User
import kz.singularity.jetpackcomposemost.domain.use_case.GetUsersUseCase
import javax.inject.Inject

data class UsersState(
    val users: List<User> = emptyList(),
    val isLoading: Boolean = true,
)

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(UsersState())
    val state: StateFlow<UsersState> = _state

    init {
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            val receivedUsers = getUsersUseCase.invoke()
            _state.value = UsersState(users = receivedUsers, isLoading = false)
        }
    }
}