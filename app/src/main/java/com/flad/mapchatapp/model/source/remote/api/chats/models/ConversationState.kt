package com.flad.mapchatapp.model.source.remote.api.chats.models

import com.flad.mapchatapp.model.viewdatainterfaces.IViewState

data class ConversationsState(
    val conversations: List<Conversation> = emptyList()
): IViewState
