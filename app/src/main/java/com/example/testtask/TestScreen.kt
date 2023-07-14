package com.example.testtask

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TestScreen() {
    val isVisible = remember { mutableStateOf(false) } // Mutable state to track visibility

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val itemList = listOf(R.drawable.horse, R.drawable.moto, R.drawable.horse2)
        LazyRow {
            items(itemList) { item ->
                MyImage(item)
            }
        }
        if (isVisible.value) {
            Text(
                text = "Hello!",
                modifier = Modifier
                    .fillMaxWidth(1f),
                fontSize = 52.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Cursive,
                color = Color.Gray
            )
        }

        Button(
            onClick = {
                isVisible.value = !isVisible.value
            },
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            shape = CutCornerShape(10),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray
            )
        ) {
            Text(text = "Click Me")
        }

    }
}

@Composable
fun MyImage(id: Int) {
    Image(
        painter = painterResource(id = id),
        contentDescription = "Image",
        modifier = Modifier
            .padding(10.dp, 20.dp)
            .size(160.dp)
            .clip(CircleShape)
            .border(width = 2.dp, color = Color.Gray, shape = CircleShape),
        contentScale = ContentScale.Crop
    )
}