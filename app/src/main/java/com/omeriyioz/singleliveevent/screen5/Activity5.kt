package com.omeriyioz.singleliveevent.screen5

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
import com.omeriyioz.singleliveevent.databinding.Activity5Binding
import com.omeriyioz.singleliveevent.databinding.FragmentABinding
import com.omeriyioz.singleliveevent.databinding.FragmentBBinding

class Activity5 : AppCompatActivity() {

    private val viewModel: ViewModel5 by viewModels()

    private lateinit var binding: Activity5Binding

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = Activity5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.setOnClickListener {
            viewModel.userClicksOnButton("Clicked ${++counter} times. Click again to increase counter.")
        }

        viewModel.clickedEvent.observe(this, Observer {
            binding.textView.text = it.peekContent()
        })
    }

}

class Fragment5A : Fragment(R.layout.fragment_a){

    private val viewModel: ViewModel5 by activityViewModels()

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

        viewModel.clickedEvent.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let { // Only proceed if the event has never been handled
                binding.textView.text = it
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

class Fragment5B : Fragment(R.layout.fragment_b){

    private val viewModel: ViewModel5 by activityViewModels()

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

        viewModel.clickedEvent.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let { // Only proceed if the event has never been handled
                binding.textView.text = it
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}