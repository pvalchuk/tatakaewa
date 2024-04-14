package com.example.artapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.artapp.databinding.ActivityCategoriesBinding

class CategoriesActivity : AppCompatActivity() {

    private var _binding: ActivityCategoriesBinding? = null
    private val binding
        get() = _binding
            ?: throw IllegalStateException("Binding for ActivityCategoriesBinding must not be null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val activities = listOf(
            RealismActivity::class.java,
            AnimeActivity::class.java,
            MangaActivity::class.java,
            AbstractionActivity::class.java,
            VectorActivity::class.java
        )

        val buttons = listOf(
            binding.btnRealism,
            binding.btnAnime,
            binding.btnManga,
            binding.btnAbstraction,
            binding.btnVector
        )

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                startActivity(Intent(this, activities[index]))
            }
        }
    }
}
