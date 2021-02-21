package com.omeriyioz.singleliveevent.screen3

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.omeriyioz.singleliveevent.R
import com.omeriyioz.singleliveevent.databinding.Activity3Binding
import com.omeriyioz.singleliveevent.databinding.FragmentABinding
import com.omeriyioz.singleliveevent.databinding.FragmentBBinding
import com.omeriyioz.singleliveevent.screen4.Activity4

class Activity3 : AppCompatActivity() {

    private val viewModel3: ViewModel3 by viewModels()

    private lateinit var binding: Activity3Binding

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = Activity3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.setOnClickListener {
            viewModel3.userClicksOnButton("Clicked ${++counter} times. Click again to increase counter")
        }

        binding.textView2.setOnClickListener {
            val intent = Intent(this, Activity4::class.java)
            startActivity(intent)
        }

        viewModel3.clickedSingleLiveEvent.observe(this, Observer {
            binding.textView.text = it // Only proceed if the event has never been handled
        })
    }

}

class Fragment3A : Fragment(R.layout.fragment_a){

    private val viewModelB: ViewModel3 by activityViewModels()

    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentABinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelB.clickedSingleLiveEvent.observe(viewLifecycleOwner, Observer {
            binding.textView.text = it // Only proceed if the event has never been handled
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

class Fragment3B : Fragment(R.layout.fragment_b){

    private val viewModelB: ViewModel3 by activityViewModels()

    private var _binding: FragmentBBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelB.clickedSingleLiveEvent.observe(viewLifecycleOwner, Observer {
            binding.textView.text = it // Only proceed if the event has never been handled
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}