package kz.singularity.jetpackcomposemost

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable
import kz.singularity.jetpackcomposemost.example_hilt.HiltClassWithParams
import kz.singularity.jetpackcomposemost.example_hilt.HiltClassWithSeveralParams
import kz.singularity.jetpackcomposemost.example_hilt.HiltClassWithoutParams
import kz.singularity.jetpackcomposemost.example_hilt.HiltDatabase
import kz.singularity.jetpackcomposemost.ui.theme.JetpackComposeMostTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    //Koin examples
//    val classWithoutParams: ClassWithoutParams by inject()
//    val classWithParams: ClassWithParams by inject()
//    val classWithSeveralParams: ClassWithSeveralParams = get()
//    val database: Database by inject()

    //Hilt Examples
//    @Inject lateinit var variableName: VariableTYpe
    @Inject
    lateinit var hiltClassWithParams: HiltClassWithParams
    @Inject
    lateinit var hiltClassWithoutParams: HiltClassWithoutParams
    @Inject
    lateinit var hiltClassWithSeveralParams: HiltClassWithSeveralParams
//    @Inject
//    lateinit var apiService: ApiService
    @Inject
    lateinit var hiltDatabase: HiltDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



//        classWithoutParams.execute()
//        classWithParams.execute()
//        classWithSeveralParams.execute()


        hiltClassWithoutParams.execute()
        hiltClassWithParams.execute()
        hiltClassWithSeveralParams.execute()


//        MainScope().launch(Dispatchers.IO) {
//            val users = apiService.getUsers()
//            Log.d("TAG", users.toString())
//        }

        Log.e("TAG", hiltDatabase.getUsers().toString())

        setContent {
            JetpackComposeMostTheme {
                val navController = rememberNavController()

                NavHost(
                    modifier = Modifier.fillMaxSize(),
                    navController = navController,
                    startDestination = HelloDestination,
                ) {
                    composable<HelloWorldDestination> {
                        HelloWorldScreen(navController)
                    }
                    composable<HelloDestination> {
                        HelloScreen(navController)
                    }
//                    composable<HelloDestination> {
//                        Box(modifier = Modifier.fillMaxSize().background(Color.Blue))
//                    }
                }
            }
        }
    }
}

@Serializable
data object HelloWorldDestination

@Serializable
data object HelloDestination

@Serializable
data object RandomDestination

@Composable
fun HelloWorldScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.Red)
            .padding(16.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hello World!",
            modifier = Modifier.clickable { navController.navigate(RandomDestination) })

    }
}

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

@Composable
fun Greeting(name: String, greetingWord: String = "Hello", modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            modifier = Modifier.size(48.dp),
            painter = painterResource(id = R.drawable.img_waving_robot),
            contentDescription = "Greeting image"
        )
        Text(text = greetingWord, modifier = Modifier.padding(end = 4.dp))
        Text(
            text = "$name!",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeMostTheme {
        Greeting("Android")
    }
}

@Preview
@Composable
fun HelloContentPreview() {
    JetpackComposeMostTheme {
        HelloContent(
            state = HelloState(name = "World!", counter = 5),
            onNameChanged = {},
            onCounterButtonClicked = {})
    }
}