package com.example.travelplanner.ui.travel_plans

import android.graphics.Color
import android.graphics.Paint.Align
import android.widget.GridView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TravelPlanScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(it),


        ) {
            UtilitiesSection(Modifier.weight(0.3f))
            TravelList(Modifier.weight(0.7f))
        }

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
fun TravelList(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 1), modifier = modifier
            .padding(3.dp)
    ) {
        items(1) {

        }
    }
}


@Preview
@Composable
fun Preview() {
    TravelPlanScreen()
}