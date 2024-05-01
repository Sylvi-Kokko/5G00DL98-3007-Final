package com.example.myapplication

import Spell
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface spellsG {

    @GET("spells/{spellName}")
    fun getSpell(@Path("spellName") spellName: String): Call<Spell>

    @GET("spells")
    fun getAllSpellNames(): Call<AllSpells>
}