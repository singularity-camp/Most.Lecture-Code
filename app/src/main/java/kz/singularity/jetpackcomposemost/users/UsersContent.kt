package kz.singularity.jetpackcomposemost.users

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kz.singularity.jetpackcomposemost.User

@Composable
fun UsersContent(state: UsersState) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)) {
        if (state.isLoading) {
            LoadingState()
        } else {
            UsersList(users = state.users)
        }
    }
}

@Composable
fun LoadingState() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun UsersList(users: List<User>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(users.size) { index ->
            User(users[index])
        }
    }
}

@Composable
fun User(user: User) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondary, shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(text = user.name, color = MaterialTheme.colorScheme.onSurface)
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = user.email, color = MaterialTheme.colorScheme.error)
    }
}

@Preview
@Composable
fun UsersContentPreview() {
    UsersContent(
        state = UsersState(
            users = listOf(
                User(
                    avatar = "",
                    email = "Some@gmail.com",
                    id = 0,
                    name = "John Doe"
                ),
                User(
                    avatar = "",
                    email = "Some@gmail.com",
                    id = 0,
                    name = "John Doe"
                ),
            ),
            isLoading = false
        )
    )
}