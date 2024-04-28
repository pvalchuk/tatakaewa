package com.example.artapp

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.artapp.databinding.ActivityWelcomeBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class WelcomeActivity : AppCompatActivity() {

    private var _binding: ActivityWelcomeBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("Binding for ActivityWelcomeBinding must not be null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        animation()

        binding.welcomeLayout.setOnClickListener {
            startActivity(Intent(this,CategoriesActivity::class.java))
            finish()
        }

    }
    private fun animation() {

        val fadeIn3000 = AnimationUtils.loadAnimation(this, R.anim.fade_in_3000)
        val fadeIn2000 = AnimationUtils.loadAnimation(this, R.anim.fade_in_2000)

        binding.backgroundVector.startAnimation(fadeIn2000)
        binding.nameTitleTextView.startAnimation(fadeIn2000)
        binding.descriptionTextView.startAnimation(fadeIn3000)
    }

}