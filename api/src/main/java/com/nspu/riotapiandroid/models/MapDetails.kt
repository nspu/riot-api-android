package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class MapDetails(
        var mapName: String? = null,
        var image: Image? = null,
        var mapId: Long? = null,
        var unpurchasableItemList: List<Long>? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readParcelable<Image>(Image::class.java.classLoader),
            source.readValue(Long::class.java.classLoader) as Long?,
            ArrayList<Long>().apply { source.readList(this, Long::class.java.classLoader) }
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(mapName)
        writeParcelable(image, 0)
        writeValue(mapId)
        writeList(unpurchasableItemList)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MapDetails> = object : Parcelable.Creator<MapDetails> {
            override fun createFromParcel(source: Parcel): MapDetails = MapDetails(source)
            override fun newArray(size: Int): Array<MapDetails?> = arrayOfNulls(size)
        }
    }
}