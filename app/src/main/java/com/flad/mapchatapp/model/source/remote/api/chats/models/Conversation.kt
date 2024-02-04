package com.flad.mapchatapp.model.source.remote.api.chats.models

import com.flad.mapchatapp.model.viewdatainterfaces.IViewState

data class Conversation(
    val id: Int,
    val contactName: String,
    val lastMessage: String,
    val timestamp: String
): IViewState
