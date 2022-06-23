package com.dynast.calendar.presentation.userAdd

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.dynast.calendar.R
import com.dynast.calendar.domain.model.card.UserData
import com.dynast.calendar.extension.type.UserAddType
import com.dynast.calendar.ui.components.editor.UserCard

@Composable
fun UserAddItems(
    textState: TextFieldValue,
    uiState: UserAddUiState,
    onClick: UserAddType.(UserData) -> Unit
) {
    LazyColumn {
        if (textState.text.isNotEmpty()) {
            items(uiState.filteredUsers) { item ->
                UserCard(userData = item, option = false, delete = false) { onClick(item) }
            }
        } else {
            if (uiState.addUsers.isNotEmpty()) {
                item {
                    Text(
                        modifier = Modifier.padding(start = 56.dp, top = 8.dp, bottom = 8.dp),
                        text = stringResource(id = R.string.editor_users_add),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                item {
                    UserCard(userData = me, option = true, delete = false) { }
                }

                items(uiState.addUsers) { item ->
                    UserCard(userData = item, option = true, delete = true) { onClick(item) }
                }
            }
        }
    }
}

private val me = UserData(name = "나", email = "cgkim@eduwill.net")