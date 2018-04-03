package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class Realm(
        var lg: String? = null,    //Legacy script mode for IE6 or older.
        var dd: String? = null,    //Latest changed version of Dragon Magic.
        var l: String? = null,    //Default language for this realm.
        var n: Map<String, String>? = null,    //Latest changed version for each data type listed.
        var profileiconmax: Int? = null,    //Special behavior number identifying the largest profile icon ID that can be used under 500. Any profile icon that is requested between this number and 500 should be mapped to 0.
        var store: String? = null,    //Additional API data drawn from other sources that may be related to Data Dragon functionality.
        var v: String? = null,    //Current version of this file for this realm.
        var cdn: String? = null,    //The base CDN URL.
        var css: String? = null //	Latest changed version of Dragon Magic's CSS file.
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            hashMapOf<String, String>().apply { source.readMap(this, Map::class.java.classLoader) },
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(lg)
        writeString(dd)
        writeString(l)
        writeMap(n)
        writeValue(profileiconmax)
        writeString(store)
        writeString(v)
        writeString(cdn)
        writeString(css)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Realm> = object : Parcelable.Creator<Realm> {
            override fun createFromParcel(source: Parcel): Realm = Realm(source)
            override fun newArray(size: Int): Array<Realm?> = arrayOfNulls(size)
        }
    }
}