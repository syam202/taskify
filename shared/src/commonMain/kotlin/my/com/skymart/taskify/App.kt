package my.com.skymart.taskify

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun App() {
    MaterialTheme {
        var taskText by remember { mutableStateOf("") }
        val tasks = remember { mutableStateListOf<String>() }

        Column(Modifier.fillMaxSize().padding(16.dp)) {
            Row(Modifier.fillMaxWidth()) {
                BasicTextField(
                    value = taskText,
                    onValueChange = { taskText = it },
                    modifier = Modifier.weight(1f).padding(end = 8.dp)
                )
                Button(onClick = {
                    if (taskText.isNotBlank()) {
                        tasks.add(taskText)
                        taskText = ""
                    }
                }) {
                    Text("Add")
                }
            }
            Spacer(Modifier.height(16.dp))
            LazyColumn(Modifier.fillMaxWidth()) {
                itemsIndexed(tasks) { index, task ->
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(task, Modifier.weight(1f).padding(8.dp))
                        Button(onClick = { tasks.removeAt(index) }) {
                            Text("Delete")
                        }
                    }
                }
            }
        }
    }
}

expect fun getPlatformName(): String

@Composable
fun MainView() = App()
