package com.jebi.jebi.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jebi.jebi.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesScreen(onLogout: () -> Unit) {

    var notes by remember { mutableStateOf(listOf<Note>()) }
    var text by remember { mutableStateOf("") }
    var selectedIndex by remember { mutableIntStateOf(-1) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Notes") },
                actions = {
                    IconButton(onClick = { onLogout() }) {
                        Icon(Icons.AutoMirrored.Filled.ExitToApp, contentDescription = "Logout")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                if (text.isNotEmpty()) {
                    if (selectedIndex >= 0) {
                        notes = notes.toMutableList().also {
                            it[selectedIndex] = Note(text)
                        }
                        selectedIndex = -1
                    } else {
                        notes = notes + Note(text)
                    }
                    text = ""
                }
            }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { padding ->

        Column(modifier = Modifier.padding(padding).padding(16.dp)) {

            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Enter note") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                itemsIndexed(notes) { index, note ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(note.title)

                            Row {
                                IconButton(onClick = {
                                    text = note.title
                                    selectedIndex = index
                                }) {
                                    Icon(Icons.Default.Edit, contentDescription = "Edit")
                                }

                                IconButton(onClick = {
                                    notes = notes.toMutableList().also {
                                        it.removeAt(index)
                                    }
                                }) {
                                    Icon(Icons.Default.Delete, contentDescription = "Delete")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}