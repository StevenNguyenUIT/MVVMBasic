package com.nhinhnguyenuit.mvvmbasic.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import com.nhinhnguyenuit.mvvmbasic.viewmodel.CounterViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nhinhnguyenuit.mvvmbasic.model.CounterState

@Composable
fun CounterScreen(viewModel: CounterViewModel = viewModel()) {
    val state by viewModel.state.observeAsState(CounterState())
    val count = state.count
    val name = state.name
    val age = state.age.toString()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Count: ${count}")
        OutlinedTextField(
            value = name,
            onValueChange = { viewModel.updateName(it?:"") },
            label = { Text(text = "Name")}
        )
        Text(text = name)
        OutlinedTextField(value = age,
            onValueChange = {
            val newAge = it.toIntOrNull()?:0
            viewModel.updateAge(newAge)
        },
            label = { Text(text = "Age")})
        Text(text = age)
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