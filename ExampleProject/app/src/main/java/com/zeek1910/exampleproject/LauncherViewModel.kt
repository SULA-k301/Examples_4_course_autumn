package com.zeek1910.exampleproject

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LauncherViewModel(private val context: Context) : ViewModel() {

    private val pref = AppSettings.getInstance(context)

    private val _event = Channel<Event>(capacity = Channel.CONFLATED)
    val event: ReceiveChannel<Event> get() = _event

    fun init() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000)
            val intent = when {
                pref.isFirstStart -> {
                    pref.isFirstStart = false
                    Intent(context, OnboardingActivity::class.java)
                }

                pref.isUserLogin -> {
                    Intent(context, MainActivity::class.java)
                }

                else -> {
                    Intent(context, SignInActivity::class.java)
                }
            }
            _event.send(Event.Navigate(intent))
        }

    }

    sealed class Event {
        data class Navigate(val intent: Intent) : Event()
        data class ShowError(val message: String) : Event()
    }

    companion object {

        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                // Get the dependency in your factory
                val context =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])?.applicationContext
                        ?: error("No context found")
                LauncherViewModel(
                    context = context
                )
            }
        }
    }
}