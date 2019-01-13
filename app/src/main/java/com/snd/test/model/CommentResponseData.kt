package com.snd.test.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class CommentResponseData(
    val list : List<Comment>
)  {
    data class Comment(
        @SerializedName("postId") val postId: Int,
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String,
        @SerializedName("email") val email: String,
        @SerializedName("body") val body: String
    ) : Parcelable{
        companion object {
            @JvmField
            val CREATOR: Parcelable.Creator<Comment> = object : Parcelable.Creator<Comment> {
                override fun createFromParcel(source: Parcel): Comment = Comment(source)
                override fun newArray(size: Int): Array<Comment?> = arrayOfNulls(size)
            }
        }

        constructor(source: Parcel): this(
            source.readInt(),
            source.readInt(),
            source.readString(),
            source.readString(),
            source.readString()
        )

        override fun describeContents() = 0

        override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
            writeInt(postId)
            writeInt(id)
            writeString(name)
            writeString(email)
            writeString(body)
        }
    }
}