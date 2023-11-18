package com.example.transactionlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.transactionlist.ui.screen.TransactionListScreen
import com.example.transactionlist.ui.theme.TransactionListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TransactionListTheme {
                TransactionListScreen()
            }
        }
    }
}