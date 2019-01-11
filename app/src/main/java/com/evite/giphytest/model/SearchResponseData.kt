package com.evite.giphytest.model

import com.google.gson.annotations.SerializedName

data class SearchResponseData(
    @SerializedName("type") val type: String,
    @SerializedName("fixed_height") val images: Images
) {
    data class Images(
        @SerializedName("url") val url: String,
        @SerializedName("width") val width: String,
        @SerializedName("webp") val webpUrl: String
    )
}