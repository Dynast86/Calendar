package com.dynast.calendar.ui.main

import android.app.Activity
import android.content.Intent
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.dynast.calendar.extension.ButtonEnum
import com.dynast.calendar.extension.objects.DrawerItems
import com.dynast.calendar.extension.objects.FabItems
import com.dynast.calendar.ui.alarm.AlarmActivity
import com.dynast.calendar.ui.components.*
import com.dynast.calendar.ui.editor.EditorScreen
import com.dynast.calendar.ui.flag.FlagActivity
import com.dynast.calendar.ui.taskalt.TaskAltScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val process by viewModel.processState.collectAsState()

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var selected by remember { mutableStateOf(items[state]) }
    val fabExpand = remember { MutableTransitionState(initialState = false) }
    val taskAlt = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val editorState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    val backState by remember { mutableStateOf(true) }
    BackHandler(enabled = backState) {
        scope.launch {
            if (drawerState.isOpen) drawerState.close().run { return@launch }
            if (taskAlt.isVisible) taskAlt.hide().run { return@launch }
            if (fabExpand.currentState) with(fabExpand) { targetState = false }.run { return@launch }
            if (editorState.isVisible) editorState.hide().run { return@launch }

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
                            viewModel.setProcessState(true)
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
                progressState = process,
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
            FabItems.Event -> scope.launch { editorState.animateTo(ModalBottomSheetValue.Expanded) }
            FabItems.TaskAlt -> scope.launch { taskAlt.animateTo(ModalBottomSheetValue.Expanded) }
            else -> Unit
        }
    })

    TaskAltScreen(state = taskAlt) { item, sheet ->
        sheet.setBottomState(item, scope)
    }
    EditorScreen(state = editorState) { item, sheet ->
        sheet.setBottomState(item, scope)
    }
}

@OptIn(ExperimentalMaterialApi::class)
private fun ModalBottomSheetState.setBottomState(
    item: ButtonEnum,
    scope: CoroutineScope
) {
    when (item) {
        ButtonEnum.Close -> scope.launch {
            hide()
        }
        else -> Unit
    }
}