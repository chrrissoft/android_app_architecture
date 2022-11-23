package com.chrrissoft.marvel.framework.db

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> Gson.myFromJson(json: String) =
    fromJson<T>(json, object : TypeToken<T>() {}.type)!!