package com.example.coroutinechannel.data.model

data class CommonResponse<T>(
    val status:Boolean,
    val description:String,
    val data:T
)
