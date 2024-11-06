package com.example.recyclerviewtest

fun <T> T.applyd(block:T.()->Unit):T
{
    block()
    return this
}


fun <T> T.applyd2(block:T.()->Unit):T
{
    block()
    return this
}


fun main()
{
    java.lang.StringBuilder().applyd {
        append("string")
        append("String2")
    }
}

