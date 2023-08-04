package com.example.summerbosch2023basesummerproject

import android.content.Context
import com.example.summerbosch2023basesummerproject.ObjectSerializer.deserialize
import com.example.summerbosch2023basesummerproject.ObjectSerializer.serialize


object SaveData {
     fun saveUsers(context: Context,  arrayList: ArrayList<User>) {


        // Get an instance of the SharedPreferences
        val sharedPreferences = context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)

        // Get an instance of the SharedPreferences.Editor
        val editor = sharedPreferences.edit()

        // Put the Set of strings into the SharedPreferences.Editor
        editor.putString("Users", ObjectSerializer.serialize(arrayList))

        // Apply the changes to the SharedPreferences
        editor.apply()
    }

     fun readUsers(context: Context): ArrayList<User> {
        // Get an instance of the SharedPreferences
        val sharedPreferences = context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)

        // Retrieve the Set of strings from SharedPreferences
        val mySet = sharedPreferences.getStringSet("Users", emptySet())

        // Convert the Set of strings back to an ArrayList
        val myArrayList =
        deserialize(
            sharedPreferences.getString(
                "UserList",
                serialize<ArrayList<*>>(ArrayList<Any?>())
            )!!
        ) as ArrayList<User>?

        return myArrayList!!
    }
}