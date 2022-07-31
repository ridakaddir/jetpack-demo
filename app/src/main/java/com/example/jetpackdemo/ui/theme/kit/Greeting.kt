package com.example.jetpackdemo.ui.theme.kit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Message(val prefix: String = "Hello, ", val name: String = "world" )

@Composable
fun Greeting(name: String) {



    val myText = remember { mutableStateOf(Message("Hello, ", name)) }

    Row(modifier = Modifier.padding(24.dp)) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = myText.value.prefix)
            Text(text = myText.value.name)
        }
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "${myText.value.prefix}${myText.value.name}!")

        }
    }
    Row(modifier = Modifier.padding(top = 70.dp, start = 20.dp)) {
        Column() {
            Button(onClick = {
                myText.value = Message("goodbye, ", "there")

            }  ) {
                Text(text = "Click")

            }
        }
        Column() {
            TextField(
                value = myText.value.name,
                onValueChange = {myText.value = Message(myText.value.prefix,it)}
            )
        }
    }
}