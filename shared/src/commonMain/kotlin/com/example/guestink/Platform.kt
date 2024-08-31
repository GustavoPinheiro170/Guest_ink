package com.example.guestink

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform