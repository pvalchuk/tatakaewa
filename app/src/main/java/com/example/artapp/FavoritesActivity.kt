package com.example.artapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.artapp.databinding.ActivityFavoritesBinding

class FavoritesActivity : AppCompatActivity() {

    private var _binding: ActivityFavoritesBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("Binding for ActivityFavoritesBinding must not be null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityFavoritesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}