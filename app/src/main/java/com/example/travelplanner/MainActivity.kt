package com.example.travelplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.travelplanner.ui.new_edit_travel_plan.NewEditTravelPlanScreen
import com.example.travelplanner.ui.theme.TravelPlannerTheme
import com.example.travelplanner.ui.travel_plans.TravelPlanScreen

// Enum for navigation path
enum class TPNavigationPath {
    MAIN,
    NEW_EDIT
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelPlannerTheme {
                TravelPlanAppNavHost()
            }
        }
    }
}

@Composable
fun TravelPlanAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = TPNavigationPath.MAIN.name
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(TPNavigationPath.MAIN.name) {
            TravelPlanScreen(onAddEditTravelPlan = { navController.navigateToAddEditTPPage() })
        }
        composable(TPNavigationPath.NEW_EDIT.name) {
            NewEditTravelPlanScreen(onBackIconClick = { navController.popBackStack() })
        }
    }
}



