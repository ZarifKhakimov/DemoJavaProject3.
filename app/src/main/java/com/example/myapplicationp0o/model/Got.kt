package com.example.myapplicationp0o.model

import java.io.Serializable

class Got(private var have: Int, enough: String) : Serializable{

    private var enough: String? = enough

//    fun Got(part: Int, enough: String?) {
//        this.have = part
//        this.enough = enough
//    }

    override fun toString(): String {
        return "Got " +
                " have=" + have +
                ", enough='" + enough + '\''
    }

}