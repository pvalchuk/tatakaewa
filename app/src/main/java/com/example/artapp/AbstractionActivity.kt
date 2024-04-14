package com.example.artapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.artapp.databinding.ActivityAbstractionBinding

class AbstractionActivity : AppCompatActivity() {

    private var _binding: ActivityAbstractionBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("Binding for ActivityAbstractionBinding must not be null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAbstractionBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}