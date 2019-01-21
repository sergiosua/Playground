package com.example.remotedatastore

import com.example.remotedatastore.extensions.currentTimestamp
import com.example.remotedatastore.extensions.md5

/**
 * Here we should use the common params for all of our Web Services.
 */
open class WebServiceParams(
    ts: String = currentTimestamp,
    hash: String = md5,
    apikey: String = "5f6270ba76555a2fe9fb02461c2ca97b"
) {

    var map: MutableMap<String, String> = mutableMapOf(
        Pair("ts", ts), Pair("hash", hash), Pair("apikey", apikey)
    )

}