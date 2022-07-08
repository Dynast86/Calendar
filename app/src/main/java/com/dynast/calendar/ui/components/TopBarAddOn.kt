package com.dynast.calendar.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dynast.calendar.extension.objects.DrawerItems
import com.dynast.calendar.presentation.main.MainViewModel
import com.dynast.calendar.ui.theme.CalendarTheme

@Composable
fun TopBarAddOn(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {
    val scope = rememberCoroutineScope()
    val itemState by remember { viewModel.drawerState }

    Box(modifier = modifier.background(color = MaterialTheme.colorScheme.primaryContainer)) {
//        Row {
//            Column(modifier = Modifier.width(56.dp), horizontalAlignment = Alignment.CenterHorizontally) {
//                Text(text = "월", modifier = Modifier.width(56.dp), textAlign = TextAlign.Center, fontSize = 10.sp)
//                Box(
//                    modifier = Modifier
//                        .size(38.dp)
//                        .clip(shape = CircleShape)
//                        .background(color = MaterialTheme.colorScheme.primary)
//                        .clickable {
//                            scope.launch { viewModel.setDrawerItemState(DrawerItems.ViewAgenda) }
//                        },
//                    contentAlignment = Alignment.Center
//                ) {
//                    Text(text = "8", fontSize = 16.sp, color = Color.White)
//                }
//            }
//            Divider(
//                thickness = Dp.Hairline, modifier = Modifier
//                    .width(1.dp)
//                    .fillMaxHeight(), color = MaterialTheme.colorScheme.primary
//            )
//            Box(modifier = Modifier.weight(1f)) {
//                Text(text = "!!!!")
//            }
//        }
        LazyRow {
            when (itemState.item) {
                DrawerItems.ViewWeek -> {}
                DrawerItems.CalendarViewWeek -> {}
                else -> {
//                    CalendarViewDay
                    item {

                    }
                }
            }
        }
    }
}

private fun getPreviewWeekData(item : DrawerItems) {
//    일월화수목금토

}