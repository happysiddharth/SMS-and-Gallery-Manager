package com.example.basetemplate.data.model

data class UserItem(
    val _links: Links,
    val birthday: String,
    val country: Country,
    val deathday: String,
    val gender: String,
    val id: Int,
    val image: Image,
    val name: String,
    val updated: Int,
    val url: String

){
    data class Links(
        val self: Self
    )
    data class Country(
        val code: String,
        val name: String,
        val timezone: String
    )
    data class Image(
        val medium: String,
        val original: String
    )
    data class Self(
        val href: String
    )
}