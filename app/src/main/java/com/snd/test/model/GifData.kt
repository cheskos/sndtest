package com.snd.test.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class GifData(
    @SerializedName("type") val type: String,
    @SerializedName("images") val images: Images
) : Parcelable {

    data class Images(
        @SerializedName("fixed_height_still") val properties: Properties
    ) : Parcelable {

        data class Properties(
            @SerializedName("url") val url: String,
            @SerializedName("width") val width: String,
            @SerializedName("webp") val webpUrl: String?
        ) : Parcelable {

            companion object {
                @JvmField
                val CREATOR: Parcelable.Creator<Properties> = object : Parcelable.Creator<Properties> {
                    override fun createFromParcel(source: Parcel): Properties = Properties(source)
                    override fun newArray(size: Int): Array<Properties?> = arrayOfNulls(size)
                }
            }

            constructor(source: Parcel) : this(
                source.readString(),
                source.readString(),
                source.readString()
            )

            override fun describeContents() = 0

            override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
                writeString(url)
                writeString(width)
                writeString(webpUrl)
            }
        }

        companion object {
            @JvmField
            val CREATOR: Parcelable.Creator<Images> = object : Parcelable.Creator<Images> {
                override fun createFromParcel(source: Parcel): Images = Images(source)
                override fun newArray(size: Int): Array<Images?> = arrayOfNulls(size)
            }
        }

        constructor(source: Parcel) : this(
            source.readParcelable<Properties>(Properties::class.java.classLoader)
        )

        override fun describeContents() = 0

        override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
            writeParcelable(properties, 0)
        }
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<GifData> = object : Parcelable.Creator<GifData> {
            override fun createFromParcel(source: Parcel): GifData = GifData(source)
            override fun newArray(size: Int): Array<GifData?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel): this(
        source.readString(),
        source.readParcelable<Images>(Images::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(type)
        writeParcelable(images, 0)
    }
}