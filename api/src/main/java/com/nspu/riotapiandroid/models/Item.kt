package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class Item(
        var gold: ItemGold? = null,
        var plaintext: String? = null,
        var hideFromAll: Boolean? = null,
        var inStore: Boolean? = null,
        var into: List<String>? = null,
        var id: Int? = null,
        var stats: ItemInventoryDataStats? = null,
        var colloq: String? = null,
        var maps: Map<String, Boolean>? = null,
        var specialRecipe: Int? = null,
        var image: Image? = null,
        var description: String? = null,
        var tags: List<String>? = null,
        var effect: Map<String, String>? = null,
        var requiredChampion: String? = null,
        var from: List<String>? = null,
        var group: String? = null,
        var consumeOnFull: Boolean? = null,
        var name: String? = null,
        var consumed: Boolean? = null,
        var sanitizedDescription: String? = null,
        var depth: Int? = null,
        var stacks: Int? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readParcelable<ItemGold>(ItemGold::class.java.classLoader),
            source.readString(),
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.createStringArrayList(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readParcelable<ItemInventoryDataStats>(ItemInventoryDataStats::class.java.classLoader),
            source.readString(),
            hashMapOf<String, Boolean>().apply { source.readMap(this, Map::class.java.classLoader) },
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readParcelable<Image>(Image::class.java.classLoader),
            source.readString(),
            source.createStringArrayList(),
            hashMapOf<String, String>().apply { source.readMap(this, Map::class.java.classLoader) },
            source.readString(),
            source.createStringArrayList(),
            source.readString(),
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readString(),
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeParcelable(gold, 0)
        writeString(plaintext)
        writeValue(hideFromAll)
        writeValue(inStore)
        writeStringList(into)
        writeValue(id)
        writeParcelable(stats, 0)
        writeString(colloq)
        writeMap(maps)
        writeValue(specialRecipe)
        writeParcelable(image, 0)
        writeString(description)
        writeStringList(tags)
        writeMap(effect)
        writeString(requiredChampion)
        writeStringList(from)
        writeString(group)
        writeValue(consumeOnFull)
        writeString(name)
        writeValue(consumed)
        writeString(sanitizedDescription)
        writeValue(depth)
        writeValue(stacks)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Item> = object : Parcelable.Creator<Item> {
            override fun createFromParcel(source: Parcel): Item = Item(source)
            override fun newArray(size: Int): Array<Item?> = arrayOfNulls(size)
        }
    }
}