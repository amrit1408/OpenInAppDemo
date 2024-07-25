package com.itarm.openinappdemo.utils

import androidx.lifecycle.MutableLiveData
import com.itarm.openinappdemo.model.StandardizedError

typealias StateMachine = MutableLiveData<DataFetchState>

fun StateMachine.onApiLoading() {
    postValue(DataFetchState.Loading)
}

fun StateMachine.onApiSuccess() {
    postValue(DataFetchState.Success)
}

fun StateMachine.onApiError(error: StandardizedError) {
    postValue(DataFetchState.Error(error))
}

sealed class DataFetchState {
    data object Loading : DataFetchState()
    data object Success : DataFetchState()
    class Error(val error: StandardizedError) : DataFetchState()
}