package com.example.myapplication

import Spell
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.theme.fontFamily
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SpellViewModel : ViewModel() {

    private val repository = SpellRepository()

    val spellList = mutableStateListOf<Spell>()
    val spellNames = mutableStateListOf<String>()

    init {
        getSpellNamesList()
    }

    private fun getSpellNamesList() {
        viewModelScope.launch {
            val names = repository.getSpellNamesList()
            spellNames.clear()
            spellNames.addAll(names)
            getSpells()
        }
    }

    private fun getSpells() {
        viewModelScope.launch {
            val spells = repository.getSpells(spellNames)
            spellList.addAll(spells)
        }
    }
}

class Spells {

    @Composable
    fun SpellList(viewModel: SpellViewModel = viewModel()) {

        val spellList = viewModel.spellList
        if (spellList.isNotEmpty()) {
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxSize()
                    .paddingFromBaseline(top = 50.dp),
                columns = GridCells.Adaptive(minSize = 160.dp)
            ) {
                items(spellList.count()) { index ->
                    val spell = spellList[index]
                    SpellCard(spell)
                }
            }
        }
    }
}

class SpellRepository {

    private val r_api = Retrofit.Builder()
        .baseUrl("https://www.dnd5eapi.co/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(spellsG::class.java)

    suspend fun getSpellNamesList(): List<String> =
        withContext(Dispatchers.IO){
            val spellNames = mutableListOf<String>()

            val deferred : Deferred<AllSpells?> =
                async {
                    r_api.getAllSpellNames().execute().body()
                }

            val result = deferred.await()

            if (result != null) {
                for (resul in result.results) {
                    result?.let { spellNames.add(resul.index) }
                }
            }
            return@withContext spellNames
        }

    suspend fun getSpells(spellNames: List<String>): List<Spell> =
        withContext(Dispatchers.IO) {
            val spellList = mutableListOf<Spell>()

            val deferredList = spellNames.map { spellName ->
                async {
                    r_api.getSpell(spellName).execute().body()
                }
            }

            val results = deferredList.awaitAll()

            for (result in results) {
                result?.let { spellList.add(it) }
            }
            return@withContext spellList
        }
}
