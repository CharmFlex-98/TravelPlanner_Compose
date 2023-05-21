package com.example.travelplanner.ui.new_edit_travel_plan

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.travelplanner.R
import com.example.travelplanner.data.SampleRepo
import com.example.travelplanner.ui.theme.TravelPlannerTheme
import com.example.travelplanner.utils.TPNewEditTopAppBar
import com.example.travelplanner.utils.toFormattedString
import com.example.travelplanner.utils.toLocalDateTime
import kotlinx.coroutines.launch
import java.time.LocalDateTime


data class AddEditDatePickerSelectionState(
    val isOpened: Boolean = false,
    val isStartDate: Boolean = true,
    val selectedDate: LocalDateTime? = null
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewEditTravelPlanScreen(
    isEdit: Boolean = false,
    viewModel: NewEditTravelPlanViewModel = viewModel(),
    onUpdateCompleted: () -> Unit,
    onBackIconClick: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val startDatePickerDialogState = rememberDatePickerState()
    val endDatePickerDialogState = rememberDatePickerState()
    var datePickerSelectionState by remember { mutableStateOf(AddEditDatePickerSelectionState()) }
    val snackBarScope = rememberCoroutineScope()
    val snackBarHostState by remember { mutableStateOf(SnackbarHostState()) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TPNewEditTopAppBar(onBackIconClick = onBackIconClick, isEdit = isEdit) },
        snackbarHost = { SnackbarHost(hostState = snackBarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
        ) {
            TPNewEditTextField(
                value = uiState.tripName,
                onValueChange = { viewModel.updateTripName(it) },
                labelText = stringResource(id = R.string.trip_name)
            )
            TPNewEditTextField(
                value = uiState.destination,
                onValueChange = { viewModel.updateDestination(it) },
                labelText = stringResource(id = R.string.trip_destination)
            )
            Row {
                TPNewEditTextField(
                    value = uiState.startDate?.toFormattedString() ?: "",
                    onValueChange = { viewModel.updateStartDate(it.toLocalDateTime()) },
                    labelText = stringResource(id = R.string.trip_start_date),
                    modifier = Modifier.weight(0.5f),
                    onClick = {
                        datePickerSelectionState = datePickerSelectionState.copy(
                            isOpened = true,
                            isStartDate = true,
                        )
                    }
                )
                TPNewEditTextField(
                    value = uiState.endDate?.toFormattedString() ?: "",
                    onValueChange = { viewModel.updateEndDate(it.toLocalDateTime()) },
                    labelText = stringResource(id = R.string.trip_end_date),
                    modifier = Modifier.weight(0.5f),
                    onClick = {
                        datePickerSelectionState = datePickerSelectionState.copy(
                            isOpened = true,
                            isStartDate = false,
                        )
                    }
                )
            }
            TPNewEditTextField(
                value = uiState.description,
                onValueChange = { viewModel.updateDescription(it) },
                labelText = stringResource(id = R.string.trip_description)
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            )
            Button(
                onClick = { viewModel.createNewPlan() },
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            ) {
                Text(text = "Add", modifier = Modifier.padding(horizontal = 3.dp))
            }
        }

        // Side effect
        LaunchedEffect(uiState.updateCompleted) {
            if (uiState.updateCompleted) {
                onUpdateCompleted()
            }
        }
        print("hey showing")
        LaunchedEffect(key1 = uiState.message) {
            uiState.message?.let {
                print("showing snackbar")
                snackBarHostState.showSnackbar(it)
                viewModel.clearUserMessage()
            }
        }
    }
    if (datePickerSelectionState.isOpened) {
        val datePickerDialogState =
            if (datePickerSelectionState.isStartDate) startDatePickerDialogState else endDatePickerDialogState
        DatePickerDialog(onDismissRequest = {
            datePickerSelectionState = datePickerSelectionState.copy(
                isOpened = false,
            )
        }, confirmButton = {
            Button(onClick = {
                // If no selection
                if (datePickerDialogState.selectedDateMillis == null) {
                    snackBarScope.launch {
                        snackBarHostState.showSnackbar("Invalid Date!")
                    }
                }

                if (datePickerSelectionState.isStartDate) viewModel.updateStartDate(
                    datePickerDialogState.selectedDateMillis?.toLocalDateTime()
                        ?: LocalDateTime.now()
                ) else viewModel.updateEndDate(
                    datePickerDialogState.selectedDateMillis?.toLocalDateTime()
                        ?: LocalDateTime.now()
                )
                datePickerSelectionState = datePickerSelectionState.copy(
                    isOpened = false
                )
            }) {
                Text(text = "Confirm")
            }
        },
            dismissButton = {
                Button(onClick = {
                    datePickerSelectionState = datePickerSelectionState.copy(
                        isOpened = false,
                    )
                }) {
                    Text("Cancel")
                }
            }) {
            DatePicker(state = datePickerDialogState)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TPNewEditTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    labelText: String,
    isError: Boolean = false,
    onClick: (() -> Unit)? = null
) {
    OutlinedTextField(
        modifier = modifier
            .padding(5.dp)
            .fillMaxWidth()
            .padding(horizontal = 6.dp, vertical = 10.dp),
        value = value, onValueChange = onValueChange,
        label = { Text(color = Color.Gray, text = labelText) },
        isError = isError,
        readOnly = onClick != null,
        trailingIcon = {
            if (onClick != null) IconButton(onClick = onClick) {
                Icon(imageVector = Icons.Filled.DateRange, contentDescription = "Select Date")
            }
        },
    )
}


@Preview
@Composable
fun Preview() {
    TravelPlannerTheme() {
        NewEditTravelPlanScreen(onUpdateCompleted = {}) { }
    }
}