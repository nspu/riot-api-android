package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class Service(
        var status: String? = null,
        var incidents: List<Incident>? = null,
        var name: String? = null,
        var slug: String? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.createTypedArrayList(Incident.CREATOR),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(status)
        writeTypedList(incidents)
        writeString(name)
        writeString(slug)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Service> = object : Parcelable.Creator<Service> {
            override fun createFromParcel(source: Parcel): Service = Service(source)
            override fun newArray(size: Int): Array<Service?> = arrayOfNulls(size)
        }
    }
}