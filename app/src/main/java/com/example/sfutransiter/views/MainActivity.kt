package com.example.sfutransiter.views

import android.os.Bundle
import com.example.sfutransiter.databinding.ActivityMainBinding
import com.example.sfutransiter.views.components.BaseActivity

class MainActivity : BaseActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}