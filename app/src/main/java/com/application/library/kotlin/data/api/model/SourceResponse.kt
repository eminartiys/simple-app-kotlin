package com.application.library.kotlin.data.api.model

/**
 * Created by eminartiys on 8/4/17.
 */

class SourceResponse(val status: String, val sources: List<Sources>) {

    inner class Sources(val id: String, val name: String, val description: String,
                        val url: String, val category: String, val language: String,
                        val country: String)
}