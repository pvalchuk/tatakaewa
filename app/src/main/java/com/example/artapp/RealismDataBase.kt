package com.example.artapp

import android.widget.ImageButton

data class Title(
    var name: String = "",
    var description: String = "",
    var link: String = "",
)
class RealismDataBase {
    companion object{
        val realism = listOf(
            Title("Magic", "Mysterious mystical locations", "more inspiration"),
            Title("Reflection", "Reflection of the sky in the lake", "more inspiration"),
            Title("Abandonment", "Abandoned structures in the wilderness", "more inspiration"),
            Title("Twilight", "Fog and silence in the woods", "more inspiration"),
            Title("Other Worlds", "Fantastic landscapes on other planets", "more inspiration"),
            Title("Soul", "A portrait that reflects a person's inner world", "more inspiration"),
            Title("Mask", "The illusion behind one's true identity", "more inspiration"),
            Title("Supernatural", "A portrait with elements of magic or fantasy", "more inspiration"),
            Title("Doppelganger", "Reflection of two faces on one canvas", "more inspiration"),
            Title("Underwater Worlds", "Portraits of people underwater", "more inspiration"),
            Title("Metamorphosis", "The transformation of objects or scenes into something else", "more inspiration"),
            Title(" Sense of Time", "A depiction of time as an abstract concept", "more inspiration"),
            Title(" Illusion", "A painting that plays with the viewer's perception", "more inspiration"),
            Title("Journey", "Transporting the viewer to another dimension or world", "more inspiration"),
            Title("Emotional Landscape", "Depicting feelings and emotions through landscape", "more inspiration"),
        )
    }
}