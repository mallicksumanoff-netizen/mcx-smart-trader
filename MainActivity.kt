package com.mcxsmarttrader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                TraderDashboard()
            }
        }
    }
}

@Composable
fun TraderDashboard() {
    var status by remember { mutableStateOf("Waiting for trade") }
    var balance by remember { mutableStateOf(100000.0) }
    var trades by remember { mutableIntStateOf(0) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF101820)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "MCX SMART TRADER",
                color = Color(0xFFFFC107),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(8.dp))

            Text(
                "CRUDE OIL PAPER TRADING",
                color = Color.White,
                fontSize = 14.sp
            )

            Spacer(Modifier.height(25.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF263746)
                )
            ) {
                Column(Modifier.padding(20.dp)) {
                    Text("Paper Trading Balance", color = Color.LightGray)
                    Text(
                        "₹${"%.2f".format(balance)}",
                        color = Color.White,
                        fontSize = 29.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(Modifier.height(18.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF263746)
                )
            ) {
                Column(Modifier.padding(20.dp)) {
                    Text("CRUDE OIL PRICE", color = Color.LightGray)
                    Text(
                        "Live price not connected",
                        color = Color.Yellow,
                        fontSize = 19.sp
                    )
                    Text(
                        "Connect market data in the next stage",
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }
            }

            Spacer(Modifier.height(20.dp))

            Text(
                "TRADING CONTROLS",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = {
                        status = "Paper BUY signal selected"
                        trades++
                    },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF168A50)
                    )
                ) {
                    Text("BUY")
                }

                Button(
                    onClick = {
                        status = "Paper SELL signal selected"
                        trades++
                    },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFD32F2F)
                    )
                ) {
                    Text("SELL")
                }
            }

            Spacer(Modifier.height(12.dp))

            OutlinedButton(
                onClick = {
                    status = "Waiting for trade"
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("RESET SIGNAL")
            }

            Spacer(Modifier.height(20.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF263746)
                )
            ) {
                Column(Modifier.padding(18.dp)) {
                    Text("Trading Status", color = Color.LightGray)
                    Text(
                        status,
                        color = Color.White,
                        fontSize = 17.sp
                    )
                    Spacer(Modifier.height(12.dp))
                    Text(
                        "Total Signals: $trades",
                        color = Color.White
                    )
                    Text(
                        "Risk Per Trade: 0.5%",
                        color = Color.White
                    )
                    Text(
                        "Trading Mode: PAPER",
                        color = Color(0xFFFFC107)
                    )
                }
            }

            Spacer(Modifier.height(25.dp))

            Text(
                "MCX SMART TRADER",
                color = Color.Gray,
                fontSize = 12.sp
            )
        }
    }
}
