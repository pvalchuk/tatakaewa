package com.example.artapp

data class Title(
    var name: String = "",
    var description: String = "",
    var inspiration: String = "",
    var link: String = "",
)
class RealismDataBase {
    companion object{
        val realism = listOf(
            Title("Magic", "Mysterious mystical locations", "more inspiration","https://ru.pinterest.com/search/pins/?q=Mysterious%20mystical%20locations&rs=typed"),
            Title("Reflection", "Reflection of the sky in the lake", "more inspiration", "https://ru.pinterest.com/search/pins/?q=Reflection%20of%20the%20sky%20in%20the%20lake&rs=typed"),
            Title("Abandonment", "Abandoned structures in the wilderness", "more inspiration", "https://ru.pinterest.com/search/pins/?q=Abandoned%20structures%20in%20the%20wilderness&rs=typed"),
            Title("Twilight", "Fog and silence in the woods", "more inspiration", "https://ru.pinterest.com/search/pins/?q=Fog%20and%20silence%20in%20the%20woods&rs=typed"),
            Title("Other Worlds", "Fantastic landscapes on other planets", "more inspiration", "https://ru.pinterest.com/search/pins/?q=Fantastic%20landscapes%20on%20other%20planets&rs=typed"),
            Title("Soul", "A portrait that reflects a person's inner world", "more inspiration", "https://ru.pinterest.com/search/pins/?q=A%20portrait%20that%20reflects%20a%20person%27s%20inner%20world&rs=typed"),
            Title("Mask", "The illusion behind one's true identity", "more inspiration", "https://ru.pinterest.com/search/pins/?q=The%20illusion%20behind%20one%27s%20true%20identity&rs=typed"),
            Title("Supernatural", "A portrait with elements of magic or fantasy", "more inspiration", "https://ru.pinterest.com/search/pins/?q=A%20portrait%20with%20elements%20of%20magic%20or%20fantasy&rs=typed"),
            Title("Doppelganger", "Reflection of two faces on one canvas", "more inspiration", "https://ru.pinterest.com/search/pins/?q=Reflection%20of%20two%20faces%20on%20one%20canvas&rs=typed"),
            Title("Underwater Worlds", "Portraits of people underwater", "more inspiration", "https://ru.pinterest.com/search/pins/?q=Portraits%20of%20people%20underwater&rs=typed"),
            Title("Metamorphosis", "The transformation of objects or scenes into something else", "more inspiration", "https://ru.pinterest.com/search/pins/?q=The%20transformation%20of%20objects%20or%20scenes%20into%20something%20else&rs=typed"),
            Title(" Sense of Time", "A depiction of time as an abstract concept", "more inspiration", "https://ru.pinterest.com/search/pins/?q=A%20depiction%20of%20time%20as%20an%20abstract%20concept&rs=typed"),
            Title(" Illusion", "A painting that plays with the viewer's perception", "more inspiration", "https://ru.pinterest.com/search/pins/?q=A%20painting%20that%20plays%20with%20the%20viewer%27s%20perception&rs=typed"),
            Title("Journey", "Transporting the viewer to another dimension or world", "more inspiration", "https://ru.pinterest.com/search/pins/?q=Transporting%20the%20viewer%20to%20another%20dimension%20or%20world&rs=typed"),
            Title("Emotional Landscape", "Depicting feelings and emotions through landscape", "more inspiration", "https://ru.pinterest.com/search/pins/?q=Depicting%20feelings%20and%20emotions%20through%20landscape&rs=typed"),
        )
    }
}