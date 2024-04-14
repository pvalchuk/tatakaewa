package com.example.artapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.artapp.databinding.ActivityMangaBinding

class MangaActivity : AppCompatActivity() {

    private var _binding: ActivityMangaBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("Binding for ActivityMangaBinding must not be null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMangaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}