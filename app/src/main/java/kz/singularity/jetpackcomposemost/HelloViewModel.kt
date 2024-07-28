package kz.singularity.jetpackcomposemost

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

data class HelloState(
    val name: String = "",
    val counter: Int = 0,
)

class HelloViewModel : ViewModel() {
    private val _state = mutableStateOf(HelloState())
    val state: State<HelloState> = _state

    fun onNameChanged(newName: String) {
        _state.value = _state.value.copy(name = newName)
    }

    fun onCounterButtonClicked() {
        val counter = _state.value.counter
        _state.value = _state.value.copy(counter = counter + 1)
    }
}