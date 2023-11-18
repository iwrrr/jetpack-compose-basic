package com.example.transactionlist.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.transactionlist.data.DataSource
import com.example.transactionlist.ui.components.TransactionCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionListScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text(text = "Daftar Transaksi") }) },
        containerColor = MaterialTheme.colorScheme.background
    ) {
        val transactions = DataSource.loadTransactions()
        LazyColumn(
            modifier = Modifier.padding(it),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp)
        ) {
            items(transactions) {transaction ->
                TransactionCard(transaction = transaction)
            }
        }
    }
}