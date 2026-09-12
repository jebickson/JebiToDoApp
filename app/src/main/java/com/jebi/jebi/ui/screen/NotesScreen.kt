package com.jebi.jebi.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jebi.jebi.model.Note

@Composable
fun NotesScreen(onLogout: () -> Unit) {

    var noteText by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf(listOf<Note>()) }

    Box(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Notes", style = MaterialTheme.typography.headlineMedium)

                IconButton(onClick = onLogout) {
                    Icon(Icons.Default.ExitToApp, contentDescription = "Logout")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = noteText,
                onValueChange = { noteText = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Enter note") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                itemsIndexed(notes) { index, note ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(note.title)

                            Row {
                                IconButton(onClick = {
                                    noteText = note.title
                                }) {
                                    Icon(Icons.Default.Edit, "Edit")
                                }

                                IconButton(onClick = {
                                    notes = notes.toMutableList().apply {
                                        removeAt(index)
                                    }
                                }) {
                                    Icon(Icons.Default.Delete, "Delete")
                                }
                            }
                        }
                    }
                }
            }
        }

        FloatingActionButton(
            onClick = {
                if (noteText.isNotEmpty()) {
                    notes = notes + Note(notes.size, noteText)
                    noteText = ""
                }
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(Icons.Default.Add, "Add")
        }
    }
}