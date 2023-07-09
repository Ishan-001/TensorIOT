package com.example.weather.ui
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.ui.model.ScreenState
import com.example.weather.ui.viewmodel.MainViewModel

@Composable
fun WeatherScreen(
    viewModel: MainViewModel
) {
    var city by remember {
        mutableStateOf(viewModel.weather.value?.city)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        TextField(
            value = city.orEmpty(),
            onValueChange = {
                city = it
            },
            placeholder = {
                Text(text = "Enter City")
            },
            label = {
                Text(text = "Enter city")
            }
        )
        Spacer(modifier = Modifier.size(20.dp))
        Button(onClick = {
            city?.let { viewModel.getWeatherFromApi(it) }
        }) {
            Text(text = "Search")
        }
        Spacer(modifier = Modifier.size(20.dp))

        when (viewModel.screenState.value) {
            ScreenState.Success -> {
                viewModel.weather.value?.let {
                    Text(
                        text = "Temperature",
                        fontSize = 24.sp,
                        color = Color.Black,
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = "${it.temp.toString()} degrees"
                    )
                    Spacer(modifier = Modifier.size(16.dp))

                    Text(
                        text = "Humidity",
                        fontSize = 24.sp,
                        color = Color.Black,
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = it.humidity.toString()
                    )
                    Spacer(modifier = Modifier.size(16.dp))

                    Text(
                        text = "Wind Speed",
                        fontSize = 24.sp,
                        color = Color.Black,
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = it.windSpeed.toString()
                    )
                    Spacer(modifier = Modifier.size(16.dp))

                    Text(
                        text = "Feels like",
                        fontSize = 24.sp,
                        color = Color.Black,
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = "${it.feelsLike.toString()} degrees"
                    )
                    Spacer(modifier = Modifier.size(16.dp))

                    Text(
                        text = "Visibility",
                        fontSize = 24.sp,
                        color = Color.Black,
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = it.visibility.toString()
                    )
                    Spacer(modifier = Modifier.size(16.dp))

                    Text(
                        text = "Pressure",
                        fontSize = 24.sp,
                        color = Color.Black,
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = it.pressure.toString()
                    )
                }
            }
            ScreenState.Loading -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator()
                }
            }
            ScreenState.Error -> {
                Text(text = viewModel.error.value.toString())
            }
        }
    }
}


