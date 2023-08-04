package com.example.summerbosch2023basesummerproject

data class User (
    var username: String = "",
    var password: String = "",
    var email: String = "",
    var age: Int = -1
){
    fun setUser(username1: String, password1: String, email1: String, age1: Int){
        username = username1
        password = password1
        email = email1
        age = age1
    }
}

