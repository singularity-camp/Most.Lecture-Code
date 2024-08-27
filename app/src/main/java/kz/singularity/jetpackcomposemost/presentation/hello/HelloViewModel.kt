package kz.singularity.jetpackcomposemost.presentation.hello

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kz.singularity.jetpackcomposemost.data.UserService
import javax.inject.Inject

data class HelloState(
    val name: String = "",
    val counter: Int = 0,
)

@HiltViewModel
class HelloViewModel @Inject constructor(
    private val apiService: UserService
) : ViewModel() {
    private val _state = mutableStateOf(HelloState())
    val state: State<HelloState> = _state

    init {
        viewModelScope.launch {
            val users = apiService.getUsers()
            Log.e("ViewModel", users.toString())
        }
    }

    fun onNameChanged(newName: String) {
        _state.value = _state.value.copy(name = newName)
    }

    fun onCounterButtonClicked() {
        val counter = _state.value.counter
        _state.value = _state.value.copy(counter = counter + 1)
    }
}