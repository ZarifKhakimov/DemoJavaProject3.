package com.example.myapplicationp0o.model

import java.io.Serializable

class Scope//    fun Scope( age: Int, nick: String) {
//        this.age = age
//        this.nick = nick
//    }
    (private var age: Int, private var nick: String) : Serializable {


    override fun toString(): String {
        return "Scope " +
                " age=" + age +
                ", name='" + nick + '\''
    }

}