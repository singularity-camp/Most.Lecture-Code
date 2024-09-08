package kz.singularity.jetpackcomposemost.presentation.hello

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kz.singularity.jetpackcomposemost.presentation.navigation.HelloWorldDestination


@Composable
fun HelloScreen(navController: NavController) {
//    val viewModel = viewModel(modelClass = HelloViewModel::class.java)
    val viewModel = hiltViewModel<HelloViewModel>()
    val state by viewModel.state

    HelloContent(
        state = state,
        onNameChanged = { viewModel.onNameChanged(it) },
        onCounterButtonClicked = { navController.navigate(HelloWorldDestination) },
    )
}

@Composable
private fun HelloContent(
    state: HelloState,
    onNameChanged: (String) -> Unit,
    onCounterButtonClicked: () -> Unit,
) {
    Column(modifier = Modifier.padding(16.dp)) {

        if (state.name.isNotEmpty()) {
            HelloText(name = state.name)
        }

        OutlinedTextField(
            value = state.name,
            onValueChange = onNameChanged,
            label = { Text("Name") }
        )

        CounterElement(
            currentCountNumber = state.counter,
            onCounterButtonClicked = onCounterButtonClicked
        )
    }
}

@Composable
fun HelloText(name: String) {

    Text(
        text = "Hello, $name!",
        modifier = Modifier.padding(bottom = 8.dp),
        style = MaterialTheme.typography.bodyMedium
    )

}

@Composable
fun CounterElement(
    currentCountNumber: Int,
    onCounterButtonClicked: () -> Unit,
) {
    Text(text = "Counter = $currentCountNumber")
    Button(onClick = onCounterButtonClicked) {
        Text("Click Me!")
    }
}