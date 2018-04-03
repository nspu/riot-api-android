package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class Rune(
        var stats: RuneStats? = null,
        var name: String? = null,
        var tags: List<String>? = null,
        var image: Image? = null,
        var sanitizedDescription: String? = null,
        var rune: MetaData? = null,
        var id: Int? = null,
        var description: String? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readParcelable<RuneStats>(RuneStats::class.java.classLoader),
            source.readString(),
            source.createStringArrayList(),
            source.readParcelable<Image>(Image::class.java.classLoader),
            source.readString(),
            source.readParcelable<MetaData>(MetaData::class.java.classLoader),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeParcelable(stats, 0)
        writeString(name)
        writeStringList(tags)
        writeParcelable(image, 0)
        writeString(sanitizedDescription)
        writeParcelable(rune, 0)
        writeValue(id)
        writeString(description)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Rune> = object : Parcelable.Creator<Rune> {
            override fun createFromParcel(source: Parcel): Rune = Rune(source)
            override fun newArray(size: Int): Array<Rune?> = arrayOfNulls(size)
        }
    }
}