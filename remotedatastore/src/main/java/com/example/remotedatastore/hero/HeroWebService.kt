package com.example.remotedatastore.hero

import com.example.remotedatastore.WebService
import com.example.remotedatastore.api

class HeroWebService : WebService<HeroApi, HeroParams>() {

    companion object {
        const val PRIVATE_API_KEY = "4933502a834bcb2cc909256dd63c6a4b58bad37d"
        const val PUBLIC_API_KEY = "5f6270ba76555a2fe9fb02461c2ca97b"
        const val HEROES_PER_PAGE = 20
    }

    val api = api<HeroApi>(retrofit)

    override fun url() = "https://gateway.marvel.com/v1/public/"

    /**
     * Here we should place the common parameters for HeroWebService. Also, we could use a data class (HeroParams or
     * any child) to insert via constructor information and avoid huge parametrized functions
     */
    /*
    override fun params(webServiceParams: HeroParams?): MutableMap<String, String> =
        super.params(webServiceParams).apply {
            // Change of context, now @this is our params map
            this["page"] = ""
        }
    */

}