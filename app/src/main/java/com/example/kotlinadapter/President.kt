package com.example.kotlinadapter

class President(var name: String, var startDuty: Int, var endDuty: Int, var description: String)
    : Comparable<President> {

    override fun toString(): String {
        return "$name\n$startDuty - $endDuty\n$description"
    }

    override fun compareTo(other: President): Int {
        return Integer.compare(this.startDuty, other.startDuty)
    }
}