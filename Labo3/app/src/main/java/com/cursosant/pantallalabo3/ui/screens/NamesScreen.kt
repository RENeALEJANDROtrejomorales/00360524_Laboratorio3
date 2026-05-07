package com.cursosant.pantallalabo3.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun NamesScreen(navController: NavController) {

    val names = listOf(
        "Mic",
        "Miguel",
        "María",
        "Andrea",
        "Juan"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xFF7F00FF),
                        Color(0xFFE100FF)
                    )
                ),
                shape = RoundedCornerShape(5.dp)
            ),

    ) {
        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {

            items(names) { name ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {

                    Text(
                        text = name,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
        Button(
            onClick = {
                navController.popBackStack()
            }
        ) {
            Text("Regresar")
        }
    }
}