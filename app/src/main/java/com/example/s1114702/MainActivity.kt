package com.example.s1114702

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import com.example.s1114702.ui.theme.S1114702Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            S1114702Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val activity = (LocalContext.current as? Activity)

    val backgroundColors = listOf(
        Color(0xff95fe95),
        Color(0xfffdca0f),
        Color(0xfffea4a4),
        Color(0xffa5dfed)
    )

    val currentColorIndex = remember { mutableStateOf(0) }
    val currentImage = remember { mutableStateOf(R.drawable.class_b) }

    Box(
        Modifier.background(backgroundColors[currentColorIndex.value]).fillMaxSize()
        .pointerInput(Unit) {
            detectHorizontalDragGestures { _, dragAmount ->
                if (dragAmount > 0) {
                    currentColorIndex.value = (currentColorIndex.value + 1) % backgroundColors.size
                } else {

                    currentColorIndex.value =
                        (currentColorIndex.value - 1 + backgroundColors.size) % backgroundColors.size
                }
            }
        }

    ){

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = "2024期末上機考(資管三B李怡蓁)",
                modifier = modifier

            )
            Image(
                painter = painterResource(id = R.drawable.class_b),
                contentDescription = "圖片",
                alpha = 0.7f,
                modifier = Modifier
                .background(Color.Black)
            )
            Text(
                text = "遊戲持續時間 0 秒",
            )
            Text(
                text = "您的成績 0 分",
            )
            Button(onClick = {
                activity?.finish()
            }) {
                Text(text = "結束App")
            }

        }
    }
}




