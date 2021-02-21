package com.omeriyioz.singleliveevent.screen1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.omeriyioz.singleliveevent.databinding.Activity1Binding
import com.omeriyioz.singleliveevent.screen2.Activity2

class Activity1 : AppCompatActivity() {

    private val viewModel1: ViewModel1 by viewModels()

    private lateinit var binding: Activity1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = Activity1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.setOnClickListener{
            viewModel1.clickedLiveData.postValue(true)
        }

        viewModel1.clickedLiveData.observe(this) {
            Toast.makeText(baseContext, "invoked liveData observer", Toast.LENGTH_SHORT).show()
            if (isFinishing) return@observe
            it?.let {
                if(it){
                    val intent = Intent(this, Activity2::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}