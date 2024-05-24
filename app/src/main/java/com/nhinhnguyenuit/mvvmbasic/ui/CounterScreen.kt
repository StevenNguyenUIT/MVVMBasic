package com.nhinhnguyenuit.mvvmbasic.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.nhinhnguyenuit.mvvmbasic.viewmodel.CounterViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CounterScreen(viewModel: CounterViewModel = viewModel()) {
    val state = viewModel.state.collectAsState()
    val count = state.value.count
    val name = state.value.name
    val age = state.value.age.toString()

    Column {
        Text(text = "Count: ${count}")
        OutlinedTextField(
            value = name,
            onValueChange = { viewModel.updateName(it?:"") }
        )
        OutlinedTextField(value = age, onValueChange = {
            val newAge = it.toIntOrNull()?:0
            viewModel.updateAge(newAge)
        })
        Row {
            Button(onClick = { viewModel.increment(1) }) {
                Text(text = "Increment")
            }
            Button(onClick = { viewModel.decrement(1) }) {
                Text(text = "Decrement")
            }
        }
    }
}