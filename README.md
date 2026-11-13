# MCX Smart Trader

Android starter app for an MCX Crude Oil paper-trading workflow.

- Paper-only UI and basic 0.5% risk-budget calculator.
- No live broker orders or live-trading switch.
- GitHub Actions workflow builds a debug APK after files are committed to `main`.

## Important limitations
This is an early UI/build scaffold. It does not connect to MCX market data, TradingView, or Dhan; it does not generate verified BUY/SELL signals or save a trade journal. The calculator excludes exchange lot sizes, tick values, fees, taxes and slippage. Verify contract specifications before using quantity estimates.

## Get the APK
Open the repository Actions tab, open the latest successful “Build Android APK” run, and download the `mcx-smart-trader-debug-apk` artifact. Extract it and install `app-debug.apk`. This is a debug/test build, not a Play Store release.
