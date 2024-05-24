package com.nhinhnguyenuit.mvvmbasic.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nhinhnguyenuit.mvvmbasic.model.CounterState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CounterViewModel : ViewModel() {
    private val _state = MutableLiveData(CounterState())
    val state: LiveData<CounterState> get() = _state

    fun increment(num: Int) {
        viewModelScope.launch {
            val newCount = state.value?: CounterState()
            _state.value = newCount.copy(count = newCount.count + num)
        }
    }

    fun decrement(num: Int) {
        viewModelScope.launch {
            val newCount = state.value?: CounterState()
            _state.value = newCount.copy(count = newCount.count - num)
        }
    }

    fun updateName(newName: String) {
        viewModelScope.launch {
            val currentName = _state.value?:CounterState()
            _state.value = currentName.copy(name = newName)
        }
    }

    fun updateAge(newAge: Int) {
        viewModelScope.launch {
            val currentAge = _state.value?:CounterState()
            _state.value = currentAge.copy(age = newAge)
        }
    }
}