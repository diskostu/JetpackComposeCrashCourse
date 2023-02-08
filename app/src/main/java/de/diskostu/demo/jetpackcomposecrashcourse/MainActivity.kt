package de.diskostu.demo.jetpackcomposecrashcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.diskostu.demo.jetpackcomposecrashcourse.ui.theme.JetpackComposeCrashCourseTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCrashCourseTheme {
                demoMethod2()
            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun demoMethod2() {

        var name by remember {
            mutableStateOf("")
        }

        var names by remember {
            mutableStateOf(listOf<String>())
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = name,
                    singleLine = true,
                    onValueChange = { text ->
                        name = text
                    },
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = {
                    if (name.isNotBlank()) {
                        names = names + name
                        name = ""
                    }
                }) {
                    Text(
                        text = "Add"
                    )
                }
            }

            NameList(names)
        }
    }

    @Composable
    private fun NameList(names: List<String>, modifier: Modifier = Modifier) {
        LazyColumn(modifier) {
            items(names) { currentName ->
                Text(
                    text = currentName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                Divider()
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    private fun demoMethod2Preview() {
        demoMethod2()
    }

    @Composable
    private fun demoMethod1() {
        var count by remember {
            mutableStateOf(0)
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(count.toString())
            Button(onClick = {
                count++
            }) {
                Text(text = "Click me! $count")
            }
        }
    }
}
