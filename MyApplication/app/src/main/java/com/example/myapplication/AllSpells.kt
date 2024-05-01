package com.example.myapplication
import kotlinx.serialization.Serializable

@Serializable
data class AllSpells(
    val count: Int,
    val results: List<Item> = emptyList(),
)

@Serializable
data class Item(
    val index: String,
    val name: String,
    val level: Int,
    val url: String
)

