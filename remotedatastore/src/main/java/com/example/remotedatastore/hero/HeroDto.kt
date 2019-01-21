package com.example.remotedatastore.hero

import com.example.model.Hero
import com.example.model.HeroElement
import com.google.gson.annotations.SerializedName

//Generics
data class DataDto<T>(@SerializedName("data") val data: ResultDto<T>)

data class ResultDto<T>(@SerializedName("results") val heroes: List<T>)

//Util
data class Thumbnail(val path: String, val extension: String)

open class ElementDto(
    @SerializedName("id") override val id: Int,
    @SerializedName("title") override val name: String,
    @SerializedName("description") override val description: String
) : HeroElement

//Dto
data class HeroDto(
    @SerializedName("id") override val id: Int,
    @SerializedName("name") override val name: String,
    @SerializedName("thumbnail") val thumbnail: Thumbnail,
    @SerializedName("description") override val description: String,
    @SerializedName("resourceURI") override val resourceUri: String
) : Hero {

    override val photo: String
        get() = thumbnail.path + "." + thumbnail.extension
}

data class ComicDto(override val id: Int, override val name: String, override val description: String) :
    ElementDto(id, name, description)

data class EventDto(
    override val id: Int, override val name: String, override val description: String
) : ElementDto(id, name, description)

data class StoryDto(
    override val id: Int, override val name: String, override val description: String
) : ElementDto(id, name, description)

data class SerieDto(
    override val id: Int, override val name: String, override val description: String
) : ElementDto(id, name, description)