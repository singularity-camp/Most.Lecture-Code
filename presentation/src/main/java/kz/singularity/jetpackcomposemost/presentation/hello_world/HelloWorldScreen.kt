package kz.singularity.jetpackcomposemost.presentation.hello_world

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kz.singularity.jetpackcomposemost.presentation.navigation.UsersDestination

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
            modifier = Modifier.clickable { navController.navigate(UsersDestination) })

    }
}