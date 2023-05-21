package com.example.travelplanner

import androidx.navigation.NavController

fun NavController.navigateToMainPage() {
    navigate(TPNavigationPath.MAIN.name) {

    }
}

fun NavController.navigateToAddEditTPPage() {
    navigate(TPNavigationPath.NEW_EDIT.name) {

    }
}