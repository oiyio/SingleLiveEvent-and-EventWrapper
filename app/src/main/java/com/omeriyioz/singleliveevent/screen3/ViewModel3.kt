package com.omeriyioz.singleliveevent.screen3

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.omeriyioz.singleliveevent.SingleLiveEvent

class ViewModel3 : ViewModel() {

    private val _clickedSingleLiveEvent = SingleLiveEvent<String>()

    val clickedSingleLiveEvent : LiveData<String>
        get() = _clickedSingleLiveEvent

    fun userClicksOnButton(itemId: String) {
        _clickedSingleLiveEvent.value = itemId  // Trigger the event by setting a new Event as a new value
    }

}