package com.snd.test.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class AlbumResponseData(
    val list : List<Album>
) : Parcelable {
    data class Album(
        @SerializedName("albumId") val albumId: Int,
        @SerializedName("id") val id: Int,
        @SerializedName("title") val title: String,
        @SerializedName("url") val url: String,
        @SerializedName("thumbnailUrl") val thumbnail: String
    ) : Parcelable {
        companion object {
            @JvmField
            val CREATOR: Parcelable.Creator<Album> = object : Parcelable.Creator<Album> {
                override fun createFromParcel(source: Parcel): Album = Album(source)
                override fun newArray(size: Int): Array<Album?> = arrayOfNulls(size)
            }
        }

        constructor(source: Parcel) : this(
            source.readInt(),
            source.readInt(),
            source.readString(),
            source.readString(),
            source.readString()
        )

        override fun describeContents() = 0

        override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
            writeInt(albumId)
            writeInt(id)
            writeString(title)
            writeString(url)
            writeString(thumbnail)
        }
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<AlbumResponseData> = object : Parcelable.Creator<AlbumResponseData> {
            override fun createFromParcel(source: Parcel): AlbumResponseData = AlbumResponseData(source)
            override fun newArray(size: Int): Array<AlbumResponseData?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel): this(
    source.createTypedArrayList(Album.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(list)
    }
}