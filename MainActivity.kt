
package com.mcxsmarttrader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.input.KeyboardType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {

                var capital by remember {
                    mutableStateOf("20000")
                }

                val amount = capital.toDoubleOrNull() ?: 0.0
                val risk = amount * 0.005

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(20.dp)
                    ) {

                        Text(
                            "MCX SMART TRADER",
                            fontSize = 26.sp
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text("CRUDE OIL DASHBOARD")

                        Spacer(modifier = Modifier.height(24.dp))

                        Card(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.padding(18.dp)
                            ) {
                                Text("TRADING MODE")
                                Text(
                                    "PAPER TRADING",
                                    fontSize = 22.sp
                                )
                                Text("Live Orders: DISABLED")
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Card(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.padding(18.dp)
                            ) {
                                Text(
                                    "CAPITAL MANAGEMENT",
                                    fontSize = 18.sp
                                )

                                Spacer(modifier = Modifier.height(12.dp))

                                Text("Enter Trading Capital (₹)")

                                OutlinedTextField(
                                    value = capital,
                                    onValueChange = {
                                        capital = it.filter { c ->
                                            c.isDigit()
                                        }
                                    },
                                    modifier = Modifier.fillMaxWidth(),
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number
                                    ),
                                    singleLine = true,
                                    label = {
                                        Text("Trading Capital")
                                    }
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                Text(
                                    "Current Capital: ₹${"%.2f".format(amount)}"
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text("RISK MANAGEMENT")

                                Text("Risk per trade: 0.5%")

                                Text(
                                    "Maximum Risk: ₹${"%.2f".format(risk)}",
                                    fontSize = 22.sp
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Card(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.padding(18.dp)
                            ) {
                                Text("CRUDE OIL MARKET")
                                Spacer(modifier = Modifier.height(8.dp))
                                Text("Market data: Not connected")
                                Text("Price: Waiting for data")
                                Text("Trend: Waiting for analysis")
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Card(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.padding(18.dp)
                            ) {
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
                            modifier = Modifier.padding(8.dp)
                        )

                        Text("Paper Trading Only")
                    }
                }
            }
        }
    }
}

