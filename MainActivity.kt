package com.mcxsmarttrader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text("MCX SMART TRADER", fontSize = 25.sp)
                        Text("Crude Oil Mini | 5-minute")

                        Card(Modifier.fillMaxWidth()) {
                            Column(Modifier.padding(16.dp)) {
                                Text("PAPER TRADING")
                                Text("Risk per trade: 0.5%")
                                Text("Live orders: DISABLED")
                            }
                        }

                        Card(Modifier.fillMaxWidth()) {
                            Column(Modifier.padding(16.dp)) {
                                Text("MARKET PRICE")
                                Text("ডেটা সংযুক্ত নয়", fontSize = 22.sp)
                                Text("লাইভ দাম পরে যুক্ত হবে।")
                            }
                        }

                        Card(Modifier.fillMaxWidth()) {
                            Column(Modifier.padding(16.dp)) {
                                Text("TRADING SIGNAL")
                                Text("WAIT", fontSize = 26.sp)
                                Text("সিগন্যাল ব্যবস্থা এখনও চালু নয়।")
                            }
                        }

                        Card(Modifier.fillMaxWidth()) {
                            Column(Modifier.padding(16.dp)) {
                                Text("OPEN POSITION")
                                Text("কোনও Paper Trade খোলা নেই")
                            }
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Button(
                                onClick = {},
                                enabled = false,
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("BUY PAPER")
                            }

                            Button(
                                onClick = {},
                                enabled = false,
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("SELL PAPER")
                            }
                        }

                        Text(
                            "প্রাথমিক Dashboard। লাইভ ডেটা ও ট্রেডিং এখনও বন্ধ।"
                        )
                    }
                }
            }
        }
    }
}
