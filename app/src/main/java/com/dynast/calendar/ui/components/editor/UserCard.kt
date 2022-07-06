package com.dynast.calendar.ui.components.editor

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dynast.calendar.R
import com.dynast.calendar.domain.model.card.UserData
import com.dynast.calendar.extension.type.UserAddType
import com.dynast.calendar.ui.theme.CalendarTheme


@Composable
fun UserCard(
    userData: UserData,
    option: Boolean = false,
    delete: Boolean = false,
    onClicked: UserAddType.() -> Unit
) {
    var options by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClicked(UserAddType.Select) }
            .padding(16.dp)
    ) {
        Box(
            modifier = defaultSize
                .clip(CircleShape)
                .background(userData.circleColor),
            contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = Icons.Default.Person, contentDescription = "User", tint = Color.White)
        }
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = userData.name)
            Text(text = userData.email)
            if (options) {
                Text(text = stringResource(id = R.string.editor_options))
            }
        }
        Row {
            if (!option) {
                Spacer(modifier = defaultSize)
            } else {
                IconButton(onClick = { options = !options }) {
                    Icon(imageVector = if (options) Icons.Outlined.Person else Icons.Default.Person, contentDescription = "User")
                }
            }
            if (!delete) {
                Spacer(modifier = defaultSize)
            } else {
                IconButton(onClick = { onClicked(UserAddType.Delete) }) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "User")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserCardPreview() {
    val userData = UserData(name = "김창구", email = "test@gmail.com")
    CalendarTheme {
        UserCard(userData = userData, option = true, delete = true) { }
    }
}

val defaultSize = Modifier.size(48.dp)
