package com.dynast.calendar.ui.main

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.dynast.calendar.extension.objects.DrawerItems
import com.dynast.calendar.extension.objects.FabItems
import com.dynast.calendar.extension.type.BottomType
import com.dynast.calendar.extension.type.ButtonType
import com.dynast.calendar.ui.alarm.AlarmActivity
import com.dynast.calendar.ui.components.*
import com.dynast.calendar.ui.editor.EditorSheetContent
import com.dynast.calendar.ui.flag.FlagActivity
import com.dynast.calendar.ui.location.LocationActivity
import com.dynast.calendar.ui.main.state.rememberMainState
import com.dynast.calendar.ui.taskalt.TaskAltSheetContent
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
    var selected by remember { mutableStateOf(items[state]) }
    val mainState = rememberMainState()

    val backState by remember { mutableStateOf(true) }
    BackHandler(enabled = backState) {
        scope.launch {
            with(mainState) {
                if (drawerState.isOpen) drawerState.close().run { return@launch }
                if (bottomSheetState.isVisible) bottomSheetState.hide().run { return@launch }
                if (fabState.currentState) with(fabState) { targetState = false }.run { return@launch }
            }

            (context as Activity).apply { finish() }
        }
    }

    ModalNavigationDrawer(
        drawerContentColor = MaterialTheme.colorScheme.inverseOnSurface,
        drawerContent = {
            CalendarDrawer(
                selectedDestination = selected,
                onDrawerClicked = { item ->
                    when (item) {
                        DrawerItems.Refresh -> launch { viewModel.setProcessState(true) }
                        else -> selected = item
                    }
                    launch { mainState.drawerState.close() }
                },
                onHeaderClicked = { launch { mainState.drawerState.close() } }
            )
        },
        drawerState = mainState.drawerState
    ) {
        Scaffold(
            topBar = {
                CalendarTopBar(
                    title = "7월"
                ) { launch { mainState.drawerState.open() } }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { mainState.fabState.targetState = true }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
                }
            },
            snackbarHost = { SnackBarHost(snackBarHostState = mainState.snackBarHostState) }
        ) { paddingValues ->
            AppContent(
                modifier = Modifier.padding(paddingValues),
                progressState = process,
                paging = viewModel.getPagingData
            )
        }
    }

    ExpandFab(currentState = mainState.fabState, onClicked = { item ->
        mainState.fabState.targetState = false
        when (item) {
            FabItems.Flag -> context.startActivity(Intent(context, FlagActivity::class.java))
            FabItems.Add -> context.startActivity(Intent(context, FlagActivity::class.java))
            FabItems.Alarms -> context.startActivity(Intent(context, AlarmActivity::class.java))
            FabItems.Event -> scope.launch {
                with(mainState) {
                    bottomType.value = BottomType.Editor
                    bottomSheetState.animateTo(ModalBottomSheetValue.Expanded)
                }
            }
            FabItems.TaskAlt -> scope.launch {
                with(mainState) {
                    bottomType.value = BottomType.TaskAlt
                    bottomSheetState.animateTo(ModalBottomSheetValue.Expanded)
                }
            }
            else -> Unit
        }
    })

    BottomSheetContent(
        state = mainState.bottomSheetState,
        onClicked = { item ->
            setBottomState(item, scope, context)
        }) { clear ->
        with(mainState) {
            when (bottomType.value) {
                BottomType.TaskAlt -> TaskAltSheetContent(clear = clear) {
                    bottomSheetState.setBottomState(item = this, scope = scope, context = context)
//                    if (this == ButtonType.Close) clear = true
                }
                BottomType.Editor -> EditorSheetContent(clear = clear) {
                    bottomSheetState.setBottomState(item = this, scope = scope, context = context)
//                    if (this == ButtonType.Close) clear = true
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
private fun ModalBottomSheetState.setBottomState(
    item: ButtonType,
    scope: CoroutineScope,
    context: Context? = null
) {
    when (item) {
        ButtonType.Close -> scope.launch {
            hide()
        }
        ButtonType.ViewAgenda -> scope.launch {
            animateTo(ModalBottomSheetValue.HalfExpanded)
        }
        ButtonType.Location -> context?.startActivity(Intent(context, LocationActivity::class.java))
        else -> Unit
    }
}