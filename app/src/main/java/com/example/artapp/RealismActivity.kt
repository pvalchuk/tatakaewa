package com.example.artapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.artapp.databinding.ActivityRealismBinding

class RealismActivity : AppCompatActivity() {

    private var _binding: ActivityRealismBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("Binding for ActivityRealismBinding must not be null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRealismBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}