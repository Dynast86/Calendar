package com.dynast.calendar.ui.components

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.dynast.calendar.R
import com.dynast.calendar.domain.model.card.AgendaCardData
import com.dynast.calendar.presentation.detail.DetailActivity
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun ViewAgendaCard(
    modifier: Modifier = Modifier,
    data: AgendaCardData? = null
) {
    val context = LocalContext.current
    val squareSize = 320.dp
    val swipeableState = rememberSwipeableState(0)
    val sizePx = with(LocalDensity.current) { squareSize.toPx() }
    val anchors = mapOf(0f to 0, sizePx to 1) // Maps anchor points (in px) to states

    Box(
        modifier = Modifier
            .clip(shape = cardShape)
            .background(MaterialTheme.colorScheme.primary)
            .swipeable(
                state = swipeableState,
                anchors = anchors,
                thresholds = { _, _ -> FractionalThreshold(0.3f) },
                orientation = Orientation.Horizontal
            )
    ) {
        Card(
            modifier = modifier
                .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) }
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