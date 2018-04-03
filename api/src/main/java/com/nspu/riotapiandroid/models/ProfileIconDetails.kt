package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class ProfileIconDetails(
        var image: Image? = null,
        var id: Long? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readParcelable<Image>(Image::class.java.classLoader),
            source.readValue(Long::class.java.classLoader) as Long?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeParcelable(image, 0)
        writeValue(id)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ProfileIconDetails> = object : Parcelable.Creator<ProfileIconDetails> {
            override fun createFromParcel(source: Parcel): ProfileIconDetails = ProfileIconDetails(source)
            override fun newArray(size: Int): Array<ProfileIconDetails?> = arrayOfNulls(size)
        }
    }
}