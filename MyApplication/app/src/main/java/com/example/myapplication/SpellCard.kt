package com.example.myapplication

import Dc
import School
import Spell
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.fontFamily

@Composable
fun SpellCard(spell: Spell) {

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        border = BorderStroke(3.dp, MaterialTheme.colorScheme.secondary),
        modifier = Modifier
            .padding(8.dp)
            .size(width = 200.dp, height = 300.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = spell.name,
                style = TextStyle(
                    fontFamily = fontFamily,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 24.dp, top = 24.dp)
            )
            Row {
                Text(
                    text = spell.level.toString(),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontFamily = fontFamily,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    ),
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = spell.school.name,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontFamily = fontFamily,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    ),
                )
                Spacer(modifier = Modifier
                    .width(8.dp)
                    .height(10.dp))
            }
            Row {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Casting Time",
                        style = TextStyle(
                            fontFamily = fontFamily,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        ),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = spell.castingTime,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontFamily = fontFamily,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        ),
                        modifier = Modifier.padding(bottom = 14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Components",
                        style = TextStyle(
                            fontFamily = fontFamily,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        ),
                    )
                    Text(
                        text = spell.components.toString(),
                        style = TextStyle(
                            fontFamily = fontFamily,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        ),
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Range",
                        style = TextStyle(
                            fontFamily = fontFamily,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        ),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = spell.range,
                        style = TextStyle(
                            fontFamily = fontFamily,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        ),
                        modifier = Modifier.padding(bottom = 14.dp)
                    )
                    Text(
                        text = "Duration",
                        style = TextStyle(
                            fontFamily = fontFamily,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        ),
                    )
                    Text(
                        text = spell.duration,
                        style = TextStyle(
                            fontFamily = fontFamily,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        ),
                    )
                }
            }
            LazyColumn{
                items(1) {
                    Text(
                        text = spell.desc.toString(),
                        style = TextStyle(
                            fontFamily = fontFamily,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        ),
                        modifier = Modifier
                            .padding(bottom = 5.dp, top = 14.dp)
                    )}}
        }
    }
}