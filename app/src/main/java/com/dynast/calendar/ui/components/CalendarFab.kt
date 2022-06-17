package com.dynast.calendar.ui.components

import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.dynast.calendar.R

sealed class FabItems(val image: ImageVector, val title: String, val route: String) {
    object Add : FabItems(Icons.Default.Add, "", "Add")

    object Event : FabItems(Icons.Default.Event, "일정", "Event")
    object TaskAlt : FabItems(Icons.Default.TaskAlt, "할일", "TaskAlt")
    object Alarms : FabItems(Icons.Default.AlarmAdd, "알림", "Alarms")
    object Flag : FabItems(Icons.Default.Flag, "목표", "Flag")

    object Close : FabItems(Icons.Default.Close, "", "Close")
}

val fabItems = listOf(
    FabItems.Flag, FabItems.Alarms, FabItems.TaskAlt, FabItems.Event
)

@Composable
fun CalendarFab(
    onFabClick: () -> Unit
) {
    FloatingActionButton(onClick = onFabClick) {
        Icon(imageVector = FabItems.Add.image, contentDescription = FabItems.Add.route)
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun ExpandFab(
    currentState: MutableTransitionState<Boolean>,
    onClicked: (FabItems) -> Unit
) {
    var exitState by remember { mutableStateOf(fadeOut()) }
    var exitItemState by remember { mutableStateOf(slideExit()) }

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
                onClicked(FabItems.Close)
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
                                enter = slideEnter(), exit = exitItemState
                            )
                    ) {
                        Text(
                            text = item.title, modifier = Modifier.padding(end = 8.dp),
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
                    onClicked(FabItems.Close)
                }) {
                    Icon(imageVector = FabItems.Close.image, contentDescription = FabItems.Close.route)
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalendarFabPreview() {
    CalendarFab(onFabClick = {})
}

@Preview(showBackground = true)
@Composable
fun ExpandFabPreview() {
    ExpandFab(
        currentState = MutableTransitionState(initialState = true),
        onClicked = {})
}

val padding = 16.dp

private fun slideEnter() = slideIn(
    initialOffset = { IntOffset(0, y = (it.height / 4)) },
    animationSpec = spring(
        stiffness = Spring.StiffnessMedium,
        visibilityThreshold = IntOffset.VisibilityThreshold
    )
)

private fun slideExit() = slideOut(
    targetOffset = { IntOffset(0, y = (it.height / 4)) },
    animationSpec = spring(
        stiffness = Spring.StiffnessMedium,
        visibilityThreshold = IntOffset.VisibilityThreshold
    )
)