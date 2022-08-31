package com.example.bundleshare

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.JsonClass

data class Records (

    var record_id        : String? = null,
    var precise_polyline : String? = null

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(record_id)
        parcel.writeString(precise_polyline)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Records> {
        override fun createFromParcel(parcel: Parcel): Records {
            return Records(parcel)
        }

        override fun newArray(size: Int): Array<Records?> {
            return arrayOfNulls(size)
        }
    }
}