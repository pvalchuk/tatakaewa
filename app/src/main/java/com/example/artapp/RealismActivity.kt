package com.example.artapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.appcompat.app.AppCompatActivity
import com.example.artapp.databinding.ActivityRealismBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class RealismActivity : AppCompatActivity() {

    private var _binding: ActivityRealismBinding? = null
    private lateinit var database: DatabaseReference
    private var realismData: List<Title> = RealismDataBase.realism
    private var currentIndex = 0

    private val binding
        get() = _binding ?: throw IllegalStateException("Binding for ActivityRealismBinding must not be null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRealismBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseApp.initializeApp(this)
        database = FirebaseDatabase.getInstance().reference.child("realism")

        binding.menuFragment.menuCategories.setOnClickListener {
            startActivity(Intent(this,CategoriesActivity::class.java))
        }

        with(binding) {

            buttonShowMore.setOnClickListener {
                showNextRealism()
            }

            icFavorites.setOnClickListener {
                toggleFavorite()

            }

            icFavoritesOrange.setOnClickListener {
                toggleFavorite()
            }

            icMenu.setOnClickListener {
                darkBackgroundMenu.isVisible = true
                menuFragment.menu.isVisible = true
            }

            menuFragment.btnBack.setOnClickListener {
                darkBackgroundMenu.isVisible = false
                menuFragment.menu.isVisible = false
            }

            darkBackgroundMenu.setOnClickListener {
                darkBackgroundMenu.isVisible = false
                menuFragment.menu.isVisible = false
            }
        }

        setupUI()
    }

    private fun setupUI() {
        if (realismData.isNotEmpty()) {
            val randomIndex = realismData.indices.random()
            val currentRealism = realismData[randomIndex]
            val spannableString = SpannableString(currentRealism.inspiration)
            spannableString.setSpan(UnderlineSpan(), 0, currentRealism.inspiration.length, 0)

            with(binding) {
                titleRealism.text = currentRealism.name
                descriptionRealism.text = currentRealism.description
                inspirationRealism.text = currentRealism.inspiration
                inspirationRealism.text = spannableString
                inspirationRealism.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(currentRealism.link))
                    Toast.makeText(applicationContext, "открытие ссылки", Toast.LENGTH_SHORT).show()
                    startActivity(intent)

                }
            }

            currentIndex = randomIndex

            val currentRealismName = currentRealism.name
            val favoriteRef = database.child("favorites").child(currentRealismName)
            favoriteRef.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        binding.icFavoritesOrange.isVisible = true
                        binding.icFavorites.isVisible = false
                    } else {
                        binding.icFavorites.isVisible = true
                        binding.icFavoritesOrange.isVisible = false
                    }
                }
                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(applicationContext, "Ошибка загрузки избранного", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    private fun showNextRealism() {
        if (realismData.isNotEmpty()) {
            currentIndex = (currentIndex + 1) % realismData.size
            setupUI()
        }
    }

    private fun toggleFavorite() {
        if (realismData.isNotEmpty()) {
            val currentRealism = realismData[currentIndex]
            val favoriteRef = database.child("favorites").child(currentRealism.name)

            favoriteRef.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        favoriteRef.removeValue()
                        binding.icFavoritesOrange.isVisible = false
                        binding.icFavorites.isVisible = true
                        Toast.makeText(applicationContext, "Удалено из избранного", Toast.LENGTH_SHORT).show()
                    } else {
                        favoriteRef.setValue(currentRealism)
                        binding.icFavorites.isVisible = false
                        binding.icFavoritesOrange.isVisible = true
                        Toast.makeText(applicationContext, "Добавленно в избранное", Toast.LENGTH_SHORT).show()
                    }
                }
                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(applicationContext, "Ошибка обновления состояния избранного", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}


