package com.emrekose.karchi.data.local.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import com.emrekose.karchi.utils.extensions.createParcel
import com.google.gson.annotations.SerializedName

/**
 * Created by emrekose on 12.12.2017.
 */

@Entity
data class User(
        @PrimaryKey
        @ColumnInfo(name = "userid")
        @SerializedName("id")
        var userId: Int,

        @SerializedName("login")
        var username: String?,

        @SerializedName("avatar_url")
        var avatarUrl: String?,

        @SerializedName("html_url")
        var htmlUrl: String

): Parcelable {
        companion object {
                @JvmField @Suppress("unused")
                val CREATOR = createParcel { User(it) }
        }

        protected constructor(parcel: Parcel) : this(
                parcel.readInt(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString())

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeInt(userId)
                parcel.writeString(username)
                parcel.writeString(avatarUrl)
                parcel.writeString(htmlUrl)
        }

        override fun describeContents(): Int = 0
}


