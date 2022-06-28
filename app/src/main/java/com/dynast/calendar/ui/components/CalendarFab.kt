package com.dynast.calendar.ui.components

import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dynast.calendar.R
import com.dynast.calendar.extension.Animated
import com.dynast.calendar.extension.objects.FabItems
import com.dynast.calendar.extension.objects.FabItems.*

val fabItems = listOf(
    Flag, Alarms, TaskAlt, Event
)

@Composable
fun CalendarFab(
    onFabClick: () -> Unit
) {
    FloatingActionButton(onClick = onFabClick) {
        Icon(imageVector = Add.image, contentDescription = Add.route)
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun ExpandFab(
    currentState: MutableTransitionState<Boolean>,
    onClicked: (FabItems) -> Unit
) {
    var exitState by remember { mutableStateOf(fadeOut()) }
    var exitItemState by remember { mutableStateOf(Animated.slideExit()) }

    AnimatedVisibility(
        visibleState = currentState,
        enter = fadeIn(),
        exit = exitState
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(id = R.color.fab_background),
            onClick = {
                currentState.targetState = !currentState.targetState
                onClicked(Close)
            }
        ) {
            Column(
                modifier = Modifier.padding(padding),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.End
            ) {
                fabItems.forEach { item ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(bottom = 4.dp)
                            .animateEnterExit(
                                enter = Animated.slideEnter(), exit = exitItemState
                            )
                    ) {
                        Text(
                            text = stringResource(id = item.title), modifier = Modifier.padding(end = 8.dp),
                            style = MaterialTheme.typography.labelSmall
                        )
                        SmallFloatingActionButton(onClick = {
                            exitState = ExitTransition.None
                            exitItemState = ExitTransition.None
                            currentState.targetState = !currentState.targetState
                            onClicked(item)
                        }) {
                            Icon(imageVector = item.image, contentDescription = item.route)
                        }
                    }
                }

                FloatingActionButton(onClick = {
                    currentState.targetState = !currentState.targetState
                    onClicked(Close)
                }) {
                    Icon(imageVector = Close.image, contentDescription = Close.route)
                }
            }

        }
    }
}

@Preview
@Composable
fun CalendarFabPreview() {
    CalendarFab(onFabClick = {})
}

@Preview
@Composable
fun ExpandFabPreview() {
    ExpandFab(
        currentState = MutableTransitionState(initialState = true),
        onClicked = {})
}

val padding = 16.dp