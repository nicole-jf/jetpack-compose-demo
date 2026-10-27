package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface( modifier = Modifier.fillMaxSize() ) {
                    MyAppLayout()
                }
            }
        }
    }
}

@Composable
fun MyAppLayout() {
    // I managed to get it to update based on the input field, but not make the update triggered by
    // the button press
    var inputName by remember { mutableStateOf("") }
    val name = inputName.ifBlank { null } ?: "Android"



    Column(modifier = Modifier
        .statusBarsPadding()
        .padding(horizontal = 40.dp)
        .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Greeting(
            name = name,
            modifier = Modifier
        )
        NameInputField(
            value = inputName,
            onValueChange = { inputName = it },
            modifier = Modifier
        )
        Button(
            content = { Text("Write") },
            onClick = { writeToGreeting(name, inputName) },
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.greeting, name),
        modifier = modifier
    )
}

@Composable
fun NameInputField(value: String, onValueChange: (String) -> Unit, modifier: Modifier) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(R.string.name_input_field_label)) },
    )
}

fun writeToGreeting(name: String, inputName: String) {
    // TODO: figure out what I am supposed to put here
//    name = if (inputName.isBlank()) {
//        "Android"
//    } else {
//        inputName
//    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyAppLayoutPreview() {
    MyAppLayout()
}