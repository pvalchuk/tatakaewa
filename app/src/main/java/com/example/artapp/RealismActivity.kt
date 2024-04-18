package com.example.artapp

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.UnderlineSpan
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import com.example.artapp.databinding.ActivityRealismBinding

class RealismActivity : AppCompatActivity() {

    private val realismDataBase = RealismDataBase()
    private var currentIndex = 0

    private var _binding: ActivityRealismBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("Binding for ActivityRealismBinding must not be null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRealismBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.icMenu.setOnClickListener{

        }

        binding.btnShowMore.setOnClickListener {
            currentIndex = (currentIndex + 1) % realismDataBase.realism.size
            val (title, description, link) = realismDataBase.realism[currentIndex]
            with(binding) {
                textView.text = title
                descriptionRealismTextView.text = description
                inspirationLinkTextView.text = link

                val underlineInspiration = SpannableString(link)
                underlineInspiration.setSpan(UnderlineSpan(), 0, link.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                inspirationLinkTextView.text = underlineInspiration
            }

        }

        val (startName, startDescription, startLink) = realismDataBase.realism[currentIndex]
        with(binding) {
            textView.text = startName
            descriptionRealismTextView.text = startDescription
            inspirationLinkTextView.text = startLink

            val underlineInspiration = SpannableString(startLink)
            underlineInspiration.setSpan(UnderlineSpan(), 0, 17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            inspirationLinkTextView.text = underlineInspiration
        }
    }


}