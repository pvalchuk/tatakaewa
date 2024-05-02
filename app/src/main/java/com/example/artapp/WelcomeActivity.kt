package com.example.artapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings.Secure
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.artapp.databinding.ActivityWelcomeBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class WelcomeActivity : AppCompatActivity() {

    private var _binding: ActivityWelcomeBinding? = null
    private lateinit var database : DatabaseReference
    private val binding
        get() = _binding ?: throw IllegalStateException("Binding for ActivityWelcomeBinding must not be null")

    @SuppressLint("HardwareIds")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseApp.initializeApp(this)
        database = FirebaseDatabase.getInstance().getReference()

        animation()

        val prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE) // настройки приложения
        val userId = prefs.getString("userId", null)
        val deviceId = Secure.getString(contentResolver, Secure.ANDROID_ID)

        if (userId != null) {
            Toast.makeText(applicationContext, "userId уже создан", Toast.LENGTH_SHORT).show()
        } else {
            database.child("users").orderByChild("deviceId").equalTo(deviceId)
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.exists()) {
                            val userDataSnapshot = snapshot.children.firstOrNull()
                            if (userDataSnapshot != null) {
                                val newUserId = userDataSnapshot.key
                                prefs.edit().putString("userId", newUserId).apply()
                            }
                        } else {
                            val newUserId = database.child("users").push().key
                            val userData = mapOf("deviceId" to deviceId)
                            if (newUserId != null) {
                                database.child("users").child(newUserId).setValue(userData)
                                prefs.edit().putString("userId", newUserId).apply()
                            }
                        }
                    }
                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(applicationContext, "userId ошибка", Toast.LENGTH_SHORT).show()
                    }

                })
        }

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