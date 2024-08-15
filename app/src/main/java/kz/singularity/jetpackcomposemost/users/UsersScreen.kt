package kz.singularity.jetpackcomposemost.users

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun UsersScreen() {
    val viewModel = viewModel(modelClass = UsersViewModel::class.java)
    val state by viewModel.state

    UsersContent(
        state = state,
    )
}