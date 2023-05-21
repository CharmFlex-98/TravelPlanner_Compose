package com.example.travelplanner.ui.new_edit_travel_plan

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.travelplanner.utils.TPNewEditTopAppBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewEditTravelPlanScreen(
    isEdit: Boolean = false,
    onBackIconClick: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TPNewEditTopAppBar(onBackIconClick = onBackIconClick, isEdit = isEdit) }
    ) {
        Text(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .wrapContentHeight(), textAlign = TextAlign.Center, text = "This is add edit screen"
        )
    }
}

@Preview
@Composable
fun Preview() {
    NewEditTravelPlanScreen() { }
}