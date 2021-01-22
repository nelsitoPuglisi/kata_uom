package com.nelsito.kata_uom

class MySample {

    fun greetings(name: String): String {
        if (name.isEmpty()) throw Exception("Name is mandatory")
        return "Hello Bob!"
    }

}