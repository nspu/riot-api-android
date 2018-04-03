package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable

class TournamentRegistrationParameters(
        var providerId: Int? = null,    //The provider ID to specify the regional registered provider data to associate this tournament.
        var name: String? = null   //The optional name of the tournament.
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(providerId)
        writeString(name)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<TournamentRegistrationParameters> = object : Parcelable.Creator<TournamentRegistrationParameters> {
            override fun createFromParcel(source: Parcel): TournamentRegistrationParameters = TournamentRegistrationParameters(source)
            override fun newArray(size: Int): Array<TournamentRegistrationParameters?> = arrayOfNulls(size)
        }
    }
}