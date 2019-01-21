package com.example.remotedatastore.extensions

import com.example.remotedatastore.hero.HeroWebService
import java.security.MessageDigest
import java.sql.Timestamp

private fun md5(pass: String): String {
    val defaultBytes = pass.toByteArray()
    try {
        val algorithm = MessageDigest.getInstance("MD5")
        algorithm.reset()
        algorithm.update(defaultBytes)
        val messageDigest = algorithm.digest()
        val hexString = StringBuffer()
        for (i in messageDigest.indices) {
            if (Integer.toHexString(0xF0 and messageDigest[i].toInt()) == "0") {
                hexString.append("0")
            }
            hexString.append(Integer.toHexString(0xFF and messageDigest[i].toInt()))
        }
        return hexString.toString()
    } catch (e: Exception) {
        return ""
    }
}

fun defaultParams(): Pair<Long, String> {
    val currentTimestamp = Timestamp(System.currentTimeMillis()).time
    val md5 = md5(currentTimestamp.toString() + HeroWebService.PRIVATE_API_KEY + HeroWebService.PUBLIC_API_KEY)
    return Pair(currentTimestamp, md5)
}

val defaultParams = defaultParams()

val currentTimestamp = defaultParams.first.toString()

val md5 = defaultParams.second