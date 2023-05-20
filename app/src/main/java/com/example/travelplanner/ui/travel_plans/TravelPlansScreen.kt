package com.example.travelplanner.ui.travel_plans

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.travelplanner.R
import com.example.travelplanner.data.sampleTravelData
import com.example.travelplanner.model.TravelPlan
import com.example.travelplanner.ui.theme.TravelPlannerTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TravelPlanScreen(
    travelPlansViewModel: TravelPlansViewModel = viewModel()
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = { FAB() },
    ) {
        Column(
            modifier = Modifier
                .padding(it),


            ) {
            UtilitiesSection(Modifier.weight(0.3f))
            TravelList(Modifier.weight(0.7f), travelPlansViewModel)
        }

    }

}

@Composable
fun FAB() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
    ) {
        Icon(
            imageVector = Icons.Filled.AddCircle,
            contentDescription = stringResource(id = R.string.add_new_travel_plan)
        )
    }
}

@Composable
fun UtilitiesSection(modifier: Modifier = Modifier) {

    Text(
        text = "This is for filtering function, implement in the future",
        fontSize = 12.sp,
        modifier = modifier
            .fillMaxSize()
            .wrapContentHeight()
            .padding(3.dp),
        textAlign = TextAlign.Center
    )


}

@Composable
fun TravelList(
    modifier: Modifier = Modifier,
    travelPlansViewModel: TravelPlansViewModel = viewModel()
) {
    val uiState by travelPlansViewModel.uiState.collectAsStateWithLifecycle()
    val travelPlans = sampleTravelData
    if (false) {
        Text(
            modifier = modifier
                .fillMaxSize()
                .wrapContentHeight(), text = "Nothing to show", textAlign = TextAlign.Center
        )
    } else {
        LazyColumn(modifier = modifier.padding()) {
            items(travelPlans.count()) {
                TravelListItem(travelPlan = travelPlans[it])
            }

        }
    }

}


@Composable
fun TravelListItem(travelPlan: TravelPlan, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(3.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .border(2.dp, Color.Black, RectangleShape)
            .padding(5.dp)

    ) {
        Text(text = travelPlan.name)
        Text(text = travelPlan.description)

    }

}

fun testing(t: String) {}


@Preview
@Composable
fun Preview2() {
    TravelPlannerTheme {
        TravelPlanScreen()
    }
}