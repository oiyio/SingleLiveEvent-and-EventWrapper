package com.omeriyioz.singleliveevent.screen2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.omeriyioz.singleliveevent.databinding.Activity2Binding
import com.omeriyioz.singleliveevent.screen3.Activity3
import com.omeriyioz.singleliveevent.screen4.Activity4

class Activity2 : AppCompatActivity() {

    private val viewModel2: ViewModel2 by viewModels()

    private lateinit var binding: Activity2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.setOnClickListener{
            viewModel2.clickedSingleLiveEvent.postValue(true)
        }

        /*
        * clickedSingleLiveEvent emits the data only once and then stops observing.
        * */
        viewModel2.clickedSingleLiveEvent.observe(this) {
            Toast.makeText(baseContext, "invoked SingleLiveEvent observer", Toast.LENGTH_SHORT).show()
            if (isFinishing) return@observe
            it?.let {
                if(it){
                    val intent = Intent(this, Activity3::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}