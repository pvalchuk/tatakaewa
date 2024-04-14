package com.example.artapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.artapp.databinding.ActivityAnimeBinding

class AnimeActivity : AppCompatActivity() {

    private var _binding: ActivityAnimeBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("Binding for ActivityAnimeBinding must not be null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAnimeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}