package com.dynast.calendar.ui.components

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dynast.calendar.R
import com.dynast.calendar.domain.model.card.AgendaCardData
import com.dynast.calendar.presentation.detail.DetailActivity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewAgendaCard(
    modifier: Modifier = Modifier,
    data: AgendaCardData? = null
) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .clip(shape = cardShape)
    ) {
        Card(
            modifier = modifier
                .clickable {
                    context.startActivity(Intent(context, DetailActivity::class.java))
                }
                .fillMaxWidth(),
            shape = cardShape
        ) {
            Row(
                modifier = modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(Modifier.weight(1f)) {
                    Text(
                        text = data?.title ?: stringResource(id = R.string.app_name),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = data?.content ?: stringResource(id = R.string.dummy),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Image(
                    imageVector = Icons.Default.AccountCircle, contentDescription = null
                )
            }
        }
    }
}

@Preview
@Composable
fun ViewAgendaCardPreview() {
    ViewAgendaCard()
}

val cardShape = RoundedCornerShape(16.dp)