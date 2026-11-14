

package com.mcxsmarttrader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
                            .verticalScroll(rememberScrollState())
                            .padding(20.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            "MCX SMART TRADER",
                            fontSize = 26.sp
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text("CRUDE OIL DASHBOARD")

                        Spacer(modifier = Modifier.height(24.dp))

                        Card(modifier = Modifier.fillMaxWidth()) {
                            Column(modifier = Modifier.padding(18.dp)) {
                                Text("TRADING MODE")
                                Text(
                                    "PAPER TRADING",
                                    fontSize = 22.sp
                                )
                                Text("Live Orders: DISABLED")
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Card(modifier = Modifier.fillMaxWidth()) {
                            Column(modifier = Modifier.padding(18.dp)) {
                                Text("RISK MANAGEMENT")
                                Spacer(modifier = Modifier.height(8.dp))
                                Text("Risk per trade: 0.5%")
                                Text("Capital: Not configured")
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Card(modifier = Modifier.fillMaxWidth()) {
                            Column(modifier = Modifier.padding(18.dp)) {
                                Text("CRUDE OIL MARKET")
                                Spacer(modifier = Modifier.height(8.dp))
                                Text("Market data: Not connected")
                                Text("Price: Waiting for data")
                                Text("Trend: Waiting for analysis")
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Card(modifier = Modifier.fillMaxWidth()) {
                            Column(modifier = Modifier.padding(18.dp)) {
                                Text("TRADE SIGNALS")
                                Spacer(modifier = Modifier.height(8.dp))
                                Text("Entry: Waiting")
                                Text("Stop Loss: Waiting")
                                Text("Target: Waiting")
                                Text("Exit: Waiting")
                            }
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        Text(
                            "MCX SMART TRADER",
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )

                        Text(
                            "Paper Trading Only",
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    }
                }
            }
        }
    }
}
