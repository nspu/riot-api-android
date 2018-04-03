package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class SpectatorObserver(
        var encryptionKey: String? = null// 	//Key used to decrypt the spectator grid game data for playback
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(encryptionKey)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<SpectatorObserver> = object : Parcelable.Creator<SpectatorObserver> {
            override fun createFromParcel(source: Parcel): SpectatorObserver = SpectatorObserver(source)
            override fun newArray(size: Int): Array<SpectatorObserver?> = arrayOfNulls(size)
        }
    }
}