package de.diskostu.demo.jetpackcomposecrashcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.diskostu.demo.jetpackcomposecrashcourse.ui.theme.JetpackComposeCrashCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCrashCourseTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    LazyColumnDemo()
                }
            }
        }
    }
}


@Composable
fun LazyColumnDemo() {
    LazyColumn {
        items(100) {
            Row {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
                Text(text = it.toString())
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LazyColumnDemoPreview() {
    JetpackComposeCrashCourseTheme {
        LazyColumnDemo()
    }
}

@Composable
fun ImageDemo(name: String) {
    Column {
        if (name.length > 5) {
            Image(
                painter = painterResource(
                    id = R.drawable.ic_launcher_foreground
                ),
                contentDescription = null,
                modifier = Modifier.background(Color.Black)
            )
        } else {
            for (i in 1..10) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        }
    }
}


//@Preview(showBackground = true)
@Composable
fun ImageDemoPreview1() {
    JetpackComposeCrashCourseTheme {
        ImageDemo("denny")
    }
}


// @Preview(showBackground = true)
@Composable
fun ImageDemoPreview2() {
    JetpackComposeCrashCourseTheme {
        ImageDemo("denny<<<")
    }
}


@Composable
fun LayoutDemo(name: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.Gray)
    ) {
        Text(
            text = "Hello $name!",
            color = Color.Blue,
            fontSize = 24.sp,
            modifier = Modifier
                // modifiers are applied sequentially
                .background(Color.Red)
                .padding(16.dp)
                .background(Color.Green)
        )
        Text(
            text = "Some other text quite long",
            color = Color.Blue,
            fontSize = 24.sp,
        )
        Box(
            modifier = Modifier
                .size(400.dp)
        ) {
            Text(
                text = "Now Box Layout starts",
                color = Color.Blue,
                fontSize = 24.sp,
                modifier = Modifier
                    // modifiers are applied sequentially
                    .background(Color.Red)
                    .padding(16.dp)
                    .background(Color.Green)
            )
            Text(
                text = "Some other text quite long",
                color = Color.Blue,
                fontSize = 24.sp,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
            )
        }
    }
}

// @Preview(showBackground = true)
@Composable
fun LayoutDemoPreview() {
    JetpackComposeCrashCourseTheme {
        LayoutDemo("Denny")
    }
}