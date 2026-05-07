package com.cursosant.pantallalabo3.ui.screens

import android.content.Context
import android.hardware.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SensorScreen(navController: NavController) {

    val context = LocalContext.current

    val sensorManager =
        context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    val lightSensor =
        sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

    var lightValue by remember {
        mutableStateOf(0f)
    }

    DisposableEffect(Unit) {

        val listener = object : SensorEventListener {

            override fun onSensorChanged(event: SensorEvent?) {

                if (event != null) {
                    lightValue = event.values[0]
                }
            }

            override fun onAccuracyChanged(
                sensor: Sensor?,
                accuracy: Int
            ) {
            }
        }

        sensorManager.registerListener(
            listener,
            lightSensor,
            SensorManager.SENSOR_DELAY_NORMAL
        )

        onDispose {
            sensorManager.unregisterListener(listener)
        }
    }

    Column(
        modifier = Modifier
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xFF7F00FF),
                        Color(0xFFE100FF)
                    )
                ),
                shape = RoundedCornerShape(5.dp)
            )
            .fillMaxSize(),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = {
                navController.popBackStack()
            }

        ) {
            Text("Regresar")
        }

        Text(
            text = "Sensor de Luz",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Valor actual: $lightValue"
        )
    }
}