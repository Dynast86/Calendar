package com.dynast.calendar.ui.main

import android.app.Activity
import android.content.Intent
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.dynast.calendar.ui.alarm.AlarmActivity
import com.dynast.calendar.ui.alarm.AlarmEnum
import com.dynast.calendar.ui.components.*
import com.dynast.calendar.ui.flag.FlagActivity
import com.dynast.calendar.ui.taskalt.TaskAltScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }
    var processState by remember { mutableStateOf(false) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var selected by remember { mutableStateOf(items[0]) }
    val fabExpand = remember { MutableTransitionState(initialState = false) }
    val taskAlt = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    val backState by remember { mutableStateOf(true) }
    BackHandler(enabled = backState) {
        scope.launch {
            if (drawerState.isOpen) {
                drawerState.close()
                return@launch
            }
            if (taskAlt.isVisible) {
                taskAlt.hide()
                return@launch
            }
            if (fabExpand.currentState) {
                fabExpand.targetState = false
                return@launch
            }
            (context as Activity).apply { finish() }
        }
    }

    ModalNavigationDrawer(
        drawerContent = {
            CalendarDrawer(
                selectedDestination = selected,
                onDrawerClicked = { item ->
                    when (item) {
                        DrawerItems.Refresh -> scope.launch {
                            processState = true
                            delay(2000L)
                            processState = false
                        }
                        else -> selected = item
                    }
                    scope.launch { drawerState.close() }
                },
                onHeaderClicked = { scope.launch { drawerState.close() } }
            )
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = { CalendarTopBar(title = "7월", onDrawerClick = { scope.launch { drawerState.open() } }) },
            floatingActionButton = {
                FloatingActionButton(onClick = { fabExpand.targetState = true }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
                }
//                CalendarFab(onFabClick = {
//                    scope.launch {
//                        val snackResult = snackBarHostState.showSnackbar(
//                            message = "FAB선택",
//                            actionLabel = "확인",
//                            duration = SnackbarDuration.Indefinite
//                        )
//                        if (snackResult == SnackbarResult.ActionPerformed) {
//                            processState = false
//                        }
//                    }
//                })
            },
            snackbarHost = { SnackBarHost(snackBarHostState = snackBarHostState) }
        ) { paddingValues ->
            AppContent(
                modifier = Modifier.padding(paddingValues),
                progressState = processState,
                paging = viewModel.getPagingData
            )
        }
    }

    ExpandFab(currentState = fabExpand, onClicked = { item ->
        fabExpand.targetState = false
        when (item) {
            FabItems.Flag -> context.startActivity(Intent(context, FlagActivity::class.java))
            FabItems.Add -> context.startActivity(Intent(context, FlagActivity::class.java))
            FabItems.Alarms -> context.startActivity(Intent(context, AlarmActivity::class.java))
            FabItems.Event -> context.startActivity(Intent(context, FlagActivity::class.java))
            FabItems.TaskAlt -> scope.launch { taskAlt.animateTo(ModalBottomSheetValue.Expanded) }
            else -> Unit
        }
    })

    TaskAltScreen(state = taskAlt) { item ->
        when (item) {
            AlarmEnum.Close -> scope.launch {
                taskAlt.hide()
            }
            else -> Unit
        }
    }
}