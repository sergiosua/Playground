package com.example.model

interface Hero {
    val id: Int
    val name: String
    val photo: String
    val description: String
    val resourceUri: String
}

interface HeroElement {
    val id: Int
    val name: String
    val description: String
}