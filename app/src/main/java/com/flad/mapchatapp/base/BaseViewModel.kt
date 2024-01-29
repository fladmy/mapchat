package com.flad.mapchatapp.base


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flad.mapchatapp.model.viewdatainterfaces.IViewEvent
import com.flad.mapchatapp.model.viewdatainterfaces.IViewState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch


abstract class BaseViewModel<State : IViewState, Event : IViewEvent> : ViewModel() {

    private val initialState: State by lazy { createInitialState() }
    abstract fun createInitialState(): State

    val currentState: State get() = uiState.value


    private val _uiState: MutableStateFlow<State> = MutableStateFlow(initialState)
    val uiState: StateFlow<State> = _uiState

    private val _eventFlow = MutableSharedFlow<Event>()
    val eventFlow = _eventFlow.asSharedFlow()

    protected fun emitEvent(event: Event) {
        viewModelScope.launch {
            _eventFlow.emit(event)
        }
    }

    init {
        viewModelScope.launch {
            _eventFlow.collect { event ->
                onEvent(event)
            }
        }
    }
    open suspend fun onEvent(event: Event) {

    }

    protected fun setState(reduce: State.() -> State) {
        val newState = currentState.reduce()
        _uiState.value = newState
    }

}
