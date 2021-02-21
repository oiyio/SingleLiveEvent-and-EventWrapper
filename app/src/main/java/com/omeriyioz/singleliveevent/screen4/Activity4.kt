package com.omeriyioz.singleliveevent.screen4

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.omeriyioz.singleliveevent.databinding.Activity3Binding
import com.omeriyioz.singleliveevent.databinding.Activity4Binding
import com.omeriyioz.singleliveevent.screen3.Activity3
import com.omeriyioz.singleliveevent.screen5.Activity5

class Activity4 : AppCompatActivity() {

    private val viewModel4: ViewModel4 by viewModels()

    private lateinit var binding: Activity4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = Activity4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.setOnClickListener {
            viewModel4.userClicksOnButton(true)
        }

        viewModel4.clickedEvent.observe(this, Observer {
            it.getContentIfNotHandled()?.let { // Only proceed if the event has never been handled
                val intent = Intent(this, Activity5::class.java)
                startActivity(intent)
            }
        })
    }

}