package com.example.coroutinechannel.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable


@Serializable
data class Home(val userDetail: UserDetail)

@Parcelize
@Serializable
data class UserDetail(val userName:String,val password:String):Parcelable

@Serializable
object Login

@Serializable
data class SearchResult(val search:String)

@Serializable
data class SearchModel(val query:String,val count:Int)