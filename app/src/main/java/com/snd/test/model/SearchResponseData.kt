package com.snd.test.model

import com.google.gson.annotations.SerializedName

data class SearchResponseData(
    @SerializedName("data") val data: List<GifData>,
    @SerializedName("pagination") val pagination: Pagination
) {
    data class Pagination(
        @SerializedName("total_count") val total: Int,
        @SerializedName("count") val count: Int,
        @SerializedName("offset") val offset: Int
    )
}