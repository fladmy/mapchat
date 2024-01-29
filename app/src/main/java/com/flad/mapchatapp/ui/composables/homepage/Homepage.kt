package com.flad.mapchatapp.ui.composables.homepage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

data class Conversation(
    val id: Int,
    val contactName: String,
    val lastMessage: String,
    val timestamp: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(conversations: List<Conversation> = SampleData()) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Conversas Recentes") })
        }
    ) { innerPadding ->
        ConversationList(conversations, Modifier.padding(innerPadding))
    }
}

@Composable
fun ConversationList(conversations: List<Conversation>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(conversations) { conversation ->
            ConversationItem(conversation)
        }
    }
}

@Composable
fun ConversationItem(conversation: Conversation) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),


    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = conversation.contactName,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = conversation.lastMessage,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = conversation.timestamp,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}


fun SampleData(): List<Conversation> {
    return listOf(
        Conversation(1, "Amigo 1", "Olá, como vai?", "10:45 AM"),
        Conversation(2, "Amigo 2", "Vamos nos encontrar hoje?", "Ontem"),
        // Adicione mais conversas aqui
    )
}