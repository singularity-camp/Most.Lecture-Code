package kz.singularity.jetpackcomposemost.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kz.singularity.jetpackcomposemost.example.example_hilt.HiltClassWithParams
import kz.singularity.jetpackcomposemost.example.example_hilt.HiltClassWithSeveralParams
import kz.singularity.jetpackcomposemost.example.example_hilt.HiltClassWithoutParams
import kz.singularity.jetpackcomposemost.example.example_hilt.HiltDatabase
import kz.singularity.jetpackcomposemost.presentation.hello_world.HelloWorldScreen
import kz.singularity.jetpackcomposemost.presentation.navigation.HelloWorldDestination
import kz.singularity.jetpackcomposemost.presentation.navigation.UsersDestination
import kz.singularity.jetpackcomposemost.presentation.ui.theme.JetpackComposeMostTheme
import kz.singularity.jetpackcomposemost.presentation.users.UsersScreen
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

        hiltClassWithoutParams.execute()
        hiltClassWithParams.execute()
        hiltClassWithSeveralParams.execute()

        Log.e("TAG", hiltDatabase.getUsers().toString())

        setContent {
            JetpackComposeMostTheme {
                val navController = rememberNavController()
                NavHost(
                    modifier = Modifier.fillMaxSize(),
                    navController = navController,
                    startDestination = UsersDestination,
                ) {
                    composable<HelloWorldDestination> {
                        HelloWorldScreen(navController)
                    }
                    composable<UsersDestination> {
                        UsersScreen()
                    }
                }
            }
        }
    }
}
