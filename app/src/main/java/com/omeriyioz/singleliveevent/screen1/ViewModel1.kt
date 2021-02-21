package com.omeriyioz.singleliveevent.screen1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel1 : ViewModel() {

    val clickedLiveData = MutableLiveData<Boolean>()

}