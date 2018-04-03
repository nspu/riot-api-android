package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class Summoner(
        var profileIconId: Int? = null,// 	ID of the summoner icon associated with the summoner.
        var name: String? = null,// 	Summoner name.
        var summonerLevel: Long? = null,// 	Summoner level associated with the summoner.
        var revisionDate: Long? = null,// 	Date summoner was last modified specified as epoch milliseconds. The following events will update this timestamp: profile icon change, playing the tutorial or advanced tutorial, finishing a game, summoner name change
        var id: Long? = null,// 	Summoner ID.
        var accountId: Long? = null// 	Account ID.
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Long::class.java.classLoader) as Long?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(profileIconId)
        writeString(name)
        writeValue(summonerLevel)
        writeValue(revisionDate)
        writeValue(id)
        writeValue(accountId)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Summoner> = object : Parcelable.Creator<Summoner> {
            override fun createFromParcel(source: Parcel): Summoner = Summoner(source)
            override fun newArray(size: Int): Array<Summoner?> = arrayOfNulls(size)
        }
    }
}