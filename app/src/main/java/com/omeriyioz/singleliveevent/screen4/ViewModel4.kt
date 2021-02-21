package com.omeriyioz.singleliveevent.screen4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omeriyioz.singleliveevent.Event

class ViewModel4 : ViewModel() {

    private val _clickedEvent = MutableLiveData<Event<Boolean>>()

    val clickedEvent : LiveData<Event<Boolean>>
        get() = _clickedEvent

    fun userClicksOnButton(itemId: Boolean) {
        _clickedEvent.value = Event(itemId)  // Trigger the event by setting a new Event as a new value
    }

}