package com.example.chucknorrisjokes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val chuckNorrisApi: ChuckNorrisApi
) : ViewModel() {

    private val _joke: MutableLiveData<Joke> = MutableLiveData()
    val joke: LiveData<Joke> get() = _joke

    fun updateJoke() {
        viewModelScope.launch {
            _joke.value = chuckNorrisApi.getRandomJoke()
        }
    }
}