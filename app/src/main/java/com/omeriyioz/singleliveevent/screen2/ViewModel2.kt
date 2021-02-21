package com.omeriyioz.singleliveevent.screen2

import androidx.lifecycle.ViewModel
import com.omeriyioz.singleliveevent.SingleLiveEvent

class ViewModel2 : ViewModel() {

    val clickedSingleLiveEvent = SingleLiveEvent<Boolean>()

}