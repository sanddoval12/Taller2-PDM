package com.pdmtaller2.DavidSandoval_00379422

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.pdmtaller2.DavidSandoval_00379422.ui.navegacion.appNavigator
import com.pdmtaller2.DavidSandoval_00379422.ui.theme.FoodSpotByDsandovalTheme
import com.pdmtaller2.DavidSandoval_00379422.viewModel.foodSpotViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: foodSpotViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodSpotByDsandovalTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    appNavigator(viewModel)
                }
            }
        }
    }
}
