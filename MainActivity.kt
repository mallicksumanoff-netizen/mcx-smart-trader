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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import java.util.Locale
import kotlin.math.abs
import kotlin.math.floor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MaterialTheme { PaperTradingScreen() } }
    }
}

@Composable
fun PaperTradingScreen() {
    var capital by remember { mutableStateOf("100000") }
    var entry by remember { mutableStateOf("") }
    var stop by remember { mutableStateOf("") }
    var target by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("1") }
    var result by remember { mutableStateOf("Enter a hypothetical trade to calculate its risk.") }
    val riskBudget = (capital.toDoubleOrNull() ?: 0.0) * 0.005

    fun calculate() {
        val e = entry.toDoubleOrNull()
        val s = stop.toDoubleOrNull()
        val t = target.toDoubleOrNull()
        val q = quantity.toDoubleOrNull()
        if (e == null || s == null || t == null || q == null || q <= 0 || e <= 0 || s <= 0 || t <= 0) {
            result = "Please enter valid positive numbers in all trade fields."
            return
        }
        val validDirection = (t > e && s < e) || (t < e && s > e)
        if (!validDirection) {
            result = "Check direction: BUY needs target above entry and stop below; SELL is the reverse."
            return
        }
        val risk = abs(e - s) * q
        val reward = abs(t - e) * q
        val maxQty = if (abs(e - s) > 0) floor(riskBudget / abs(e - s)) else 0.0
        result = "Estimated risk: ₹${fmt(risk)}\nEstimated reward: ₹${fmt(reward)}\n0.5% risk budget: ₹${fmt(riskBudget)}\nIndicative max units: ${fmt(maxQty)}"
    }

    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)) {
        Text("MCX SMART TRADER", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
        Text("Crude Oil • 5-minute workflow • Paper mode only")
        Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)) {
            Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text("PAPER TRADING ONLY", fontWeight = FontWeight.Bold)
                Text("Live orders are disabled. No broker connection or live market feed is configured.")
            }
        }
        Text("MCX market data: Not connected", color = MaterialTheme.colorScheme.error)
        Text("Dhan API: Not connected", color = MaterialTheme.colorScheme.error)
        Text("Signal engine: Waiting for verified candle data")
        HorizontalDivider()
        Text("Risk calculator", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        Field("Paper capital (₹)", capital) { capital = it }
        Text("0.5% risk budget: ₹${fmt(riskBudget)}")
        Field("Entry price", entry) { entry = it }
        Field("Stop-loss price", stop) { stop = it }
        Field("Target price", target) { target = it }
        Field("Quantity / units", quantity) { quantity = it }
        Button(onClick = { calculate() }, modifier = Modifier.fillMaxWidth()) { Text("Calculate paper-trade risk") }
        Card { Text(result, Modifier.padding(16.dp)) }
        HorizontalDivider()
        Text("Planned strategy", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
        Text("EMA 9/21 • RSI 14 • VWAP • Volume confirmation • ATR stop concept • 2R target concept")
        Text("Starter UI only: no live prices, verified signals, broker orders, or persistent trade journal. Quantity estimate excludes MCX lot size, tick value, brokerage, taxes and slippage. Confirm contract specifications before relying on any calculation.",
            style = MaterialTheme.typography.bodySmall)
        Text("Version 0.1.0 • Educational paper-trading scaffold", style = MaterialTheme.typography.labelSmall)
    }
}

@Composable
fun Field(label: String, value: String, onChange: (String) -> Unit) {
    OutlinedTextField(value, onChange, label = { Text(label) }, modifier = Modifier.fillMaxWidth(),
        singleLine = true, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal))
}
fun fmt(v: Double) = String.format(Locale.US, "%.2f", v)
