package com.example.artapp

data class Title(
    var name: String,
    var description: String,
    var link: String,
)

class RealismDataBase {

    val realism = listOf(
        Title("Title1", "Description1", "more inspiration1"),
        Title("text", "12434", "more inspiration211"),
        Title("Title9", "Description9", "more inspiration3"),
        Title("Title4", "Description4", "more inspiration4"),
        Title("Title5", "Description5", "more inspiration5"),
        Title("Title6", "Description6", "more inspiration6"),
        Title("Title7", "Description7", "more inspiration7"),
        Title("Title8", "Description8", "more inspiration8"),
    )

}