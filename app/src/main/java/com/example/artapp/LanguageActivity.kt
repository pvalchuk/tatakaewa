package com.example.artapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.artapp.databinding.ActivityLanguageBinding

class LanguageActivity : AppCompatActivity() {

    private var _binding: ActivityLanguageBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("Binding for ActivityLanguageBinding must not be null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLanguageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}