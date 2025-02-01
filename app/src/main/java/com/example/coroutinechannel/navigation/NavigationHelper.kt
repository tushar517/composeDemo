package com.example.coroutinechannel.navigation

import kotlinx.serialization.Serializable


@Serializable
data class Home(val userName:String,val password:String)
@Serializable
data class UserDetail(val userName:String,val password:String)

@Serializable
object Login

@Serializable
data class SearchResult(val search:String)

@Serializable
data class SearchModel(val query:String,val count:Int)