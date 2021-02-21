package com.omeriyioz.singleliveevent.screen5

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omeriyioz.singleliveevent.Event

class ViewModel5 : ViewModel() {

    private val _clickedEvent = MutableLiveData<Event<String>>()

    val clickedEvent : LiveData<Event<String>>
        get() = _clickedEvent

    fun userClicksOnButton(itemId: String) {
        _clickedEvent.value = Event(itemId)  // Trigger the event by setting a new Event as a new value
    }

}