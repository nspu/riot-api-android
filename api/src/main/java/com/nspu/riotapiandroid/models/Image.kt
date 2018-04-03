package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable

data class Image(var full: String? = null,
                 var group: String? = null,
                 var sprite: String? = null,
                 var h: Int? = null,
                 var w: Int? = null,
                 var y: Int? = null,
                 var x: Int? = null) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(full)
        writeString(group)
        writeString(sprite)
        writeValue(h)
        writeValue(w)
        writeValue(y)
        writeValue(x)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Image> = object : Parcelable.Creator<Image> {
            override fun createFromParcel(source: Parcel): Image = Image(source)
            override fun newArray(size: Int): Array<Image?> = arrayOfNulls(size)
        }
    }
}
