package com.example.artapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.artapp.databinding.ActivityVectorBinding

class VectorActivity : AppCompatActivity() {

    private var _binding: ActivityVectorBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("Binding for ActivityVectorBinding must not be null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityVectorBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}