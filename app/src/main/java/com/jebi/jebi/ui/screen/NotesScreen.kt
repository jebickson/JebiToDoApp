package com.jebi.jebi.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Note(val title: String, val desc: String)

@Composable
fun NotesScreen() {

    val notes = listOf(
        Note("Design System Checklist", "Review UI components"),
        Note("Grocery List", "Milk, Eggs, Bread"),
        Note("App Ideas", "Build a notes app")
    )

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Text("+")
            }
        }
    ) { padding ->

        Column(modifier = Modifier.padding(padding)) {

            Text(
                "Jebi",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )

            LazyColumn {
                items(notes) { note ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(note.title)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(note.desc)
                        }
                    }
                }
            }
        }
    }
}