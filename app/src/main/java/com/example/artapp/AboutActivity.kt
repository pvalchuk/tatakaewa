package com.example.artapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.artapp.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private var _binding: ActivityAboutBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("Binding for ActivityAboutBinding must not be null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}