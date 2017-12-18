package com.emrekose.karchi.data.local.entity

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import com.emrekose.karchi.utils.extensions.createParcel
import com.google.gson.annotations.SerializedName

/**
 * Created by emrekose on 13.12.2017.
 */
@Entity(tableName = "repos")
data class Repos(
        @PrimaryKey
        @SerializedName("id")
        var repoId: Int,

        @SerializedName("name")
        var name: String?,

        @SerializedName("description")
        var description: String?,

        @SerializedName("stargazers_count")
        var starCount: Int,

        @SerializedName("language")
        var language: String?,

        @SerializedName("open_issues")
        var openIssues: Int,

        @Embedded
        @SerializedName("owner")
        var user: User?

) : Parcelable {
        companion object {
                @JvmField @Suppress("unused")
                val CREATOR = createParcel { Repos(it) }
        }

        protected constructor(parcelIn: Parcel) : this(
                parcelIn.readInt(),
                parcelIn.readString(),
                parcelIn.readString(),
                parcelIn.readInt(),
                parcelIn.readString(),
                parcelIn.readInt(),
                parcelIn.readParcelable(User::class.java.classLoader)
        )

        override fun writeToParcel(dest: Parcel, flags: Int) {
                dest.writeInt(repoId)
                dest.writeString(name)
                dest.writeString(description)
                dest.writeInt(starCount)
                dest.writeString(language)
                dest.writeInt(openIssues)
                dest.writeParcelable(user, flags)
        }

        override fun describeContents() = 0

}
