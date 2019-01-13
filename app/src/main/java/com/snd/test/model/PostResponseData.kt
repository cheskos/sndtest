package com.snd.test.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PostResponseData(
    val list: List<Post>
) : Parcelable {
    data class Post(
        @SerializedName("userId") val userId: Int,
        @SerializedName("id") val id: Int,
        @SerializedName("title") val title: String,
        @SerializedName("body") val body: String
    ) : Parcelable {
        companion object {
            @JvmField
            val CREATOR: Parcelable.Creator<Post> = object : Parcelable.Creator<Post> {
                override fun createFromParcel(source: Parcel): Post = Post(source)
                override fun newArray(size: Int): Array<Post?> = arrayOfNulls(size)
            }
        }

        constructor(source: Parcel) : this(
            source.readInt(),
            source.readInt(),
            source.readString(),
            source.readString()
        )

        override fun describeContents() = 0

        override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
            writeInt(userId)
            writeInt(id)
            writeString(title)
            writeString(body)
        }
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<PostResponseData> = object : Parcelable.Creator<PostResponseData> {
            override fun createFromParcel(source: Parcel): PostResponseData = PostResponseData(source)
            override fun newArray(size: Int): Array<PostResponseData?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel): this(
        source.createTypedArrayList(Post.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(list)
    }
}