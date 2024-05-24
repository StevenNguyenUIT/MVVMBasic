package com.nhinhnguyenuit.mvvmbasic.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nhinhnguyenuit.mvvmbasic.model.CounterState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.math.BigDecimal

class CounterViewModel : ViewModel() {
    private val _state = MutableStateFlow(CounterState())
    val state: StateFlow<CounterState> get() = _state

    fun increment(num: Int) {
        viewModelScope.launch {
            val newCount = state.value
            _state.value = newCount.copy(count = newCount.count + num)
        }
    }

    fun decrement(num: Int) {
        viewModelScope.launch {
            val newCount = state.value
            _state.value = newCount.copy(count = newCount.count - num)
        }
    }

    fun updateName(newName: String) {
        viewModelScope.launch {
            val currentName = _state.value
            _state.value = currentName.copy(name = newName)
        }
    }

    fun updateAge(newAge: Int) {
        viewModelScope.launch {
            val currentAge = _state.value
            _state.value = currentAge.copy(age = newAge)
        }
    }
}