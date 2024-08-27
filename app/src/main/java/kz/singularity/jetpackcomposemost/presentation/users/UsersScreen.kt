package kz.singularity.jetpackcomposemost.presentation.users

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun UsersScreen() {
    val viewModel = hiltViewModel<UsersViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    UsersContent(
        state = state,
    )
}