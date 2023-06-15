package com.devexperto.modulo9

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.devexperto.modulo9.ui.theme.KotlinAndroid2023Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinAndroid2023Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    //modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyButton(text = "Hello World")
                }
            }
        }
    }
}

@Composable
fun MyButton(text: String) {
    val ctx = LocalContext.current
    Button(onClick = {
        Toast.makeText(ctx, "Button Clicked", Toast.LENGTH_SHORT).show()
    }) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KotlinAndroid2023Theme {
        MyButton(text = "Hello World")
    }
}