
package com.mcxsmarttrader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text("MCX SMART TRADER", fontSize = 26.sp)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text("Crude Oil Paper Trading")
                        Spacer(modifier = Modifier.height(12.dp))
                        Text("Mode: PAPER TRADING")
                        Text("Risk per trade: 0.5%")
                        Text("Live orders: DISABLED")
                    }
                }
            }
        }
    }
}
