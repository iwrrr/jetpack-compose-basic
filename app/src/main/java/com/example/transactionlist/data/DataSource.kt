package com.example.transactionlist.data

import android.util.Log
import com.example.transactionlist.model.Transaction
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.Random

object DataSource {
    fun loadTransactions(): List<Transaction> {
        return listOf(
            Transaction(
                title = "Nasi Padang",
                status = generateRandomStatus(),
                updatedAt = generateRandomDate(),
                item = 3,
                total = "45000"
            ),
            Transaction(
                title = "Ayam Bakar",
                status = generateRandomStatus(),
                updatedAt = generateRandomDate(),
                item = 2,
                total = "50000"
            ),
            Transaction(
                title = "Nasi Goreng",
                status = generateRandomStatus(),
                updatedAt = generateRandomDate(),
                item = 1,
                total = "15000"
            ),
            Transaction(
                title = "Seblak",
                status = generateRandomStatus(),
                updatedAt = generateRandomDate(),
                item = 3,
                total = "15000"
            ),
            Transaction(
                title = "Ketoprak",
                status = generateRandomStatus(),
                updatedAt = generateRandomDate(),
                item = 5,
                total = "60000"
            ),
            Transaction(
                title = "Nasi Bebek",
                status = generateRandomStatus(),
                updatedAt = generateRandomDate(),
                item = 3,
                total = "45000"
            ),
            Transaction(
                title = "Nasi Uduk",
                status = generateRandomStatus(),
                updatedAt = generateRandomDate(),
                item = 1,
                total = "5000"
            ),
            Transaction(
                title = "Ikan Gurame Bakar",
                status = generateRandomStatus(),
                updatedAt = generateRandomDate(),
                item = 3,
                total = "95000"
            ),
            Transaction(
                title = "Kepiting Saus Tiram",
                status = generateRandomStatus(),
                updatedAt = generateRandomDate(),
                item = 1,
                total = "120000"
            ),
            Transaction(
                title = "Pecel Lele",
                status = generateRandomStatus(),
                updatedAt = generateRandomDate(),
                item = 3,
                total = "24000"
            ),
        )
    }

    private fun generateRandomDate(): String {
        val originFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val targetFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
        val random = Random()

        try {
            val startMillis = originFormat.parse("2023-11-01")!!.time
            val endMillis = originFormat.parse("2023-12-31")!!.time

            val randomMillis =
                startMillis + (random.nextDouble() * (endMillis - startMillis)).toLong()

            val randomDate = Date(randomMillis)
            val result = originFormat.format(randomDate)

            val date = originFormat.parse(result)
            return targetFormat.format(date!!)

        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("ERROR PARSE DATE", e.message.toString(), e)
        }

        return "-"
    }

    private fun generateRandomStatus(): String {
        val statusOptions = listOf("Dalam Proses", "Selesai", "Dibatalkan")

        val randomIndex = Random().nextInt(statusOptions.size)
        return statusOptions[randomIndex]
    }
}