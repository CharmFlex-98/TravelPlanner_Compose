package com.example.travelplanner.utils

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/*
* Top bar at main screen
*/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TPMainPageTopAppBar(
    modifier: Modifier = Modifier,
    onBackIconClick: () -> Unit,
) {
    TopAppBar(
        navigationIcon = {
            DrawerIconButton(onClick = onBackIconClick)
        },
        title = {
            Text("Travel Planner")
        },
        )
}

/*
* Top bar at new edit screen
*/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TPNewEditTopAppBar(
    modifier: Modifier = Modifier,
    onBackIconClick: () -> Unit,
    isEdit: Boolean = false
) {
    TopAppBar(
        navigationIcon = {
            BackIconButton(onClick = onBackIconClick)
        },
        title = {
            Text(
                text = if (isEdit) "Edit" else "New Plan"
            )
        },
    )
}

@Composable
fun BackIconButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Return")
    }
}

@Composable
fun DrawerIconButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(imageVector = Icons.Filled.Menu, contentDescription = "Return")
    }
}

@Preview
@Composable
fun Preview() {
    TPMainPageTopAppBar(onBackIconClick = { })
}