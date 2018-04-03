package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class ChampionSpell(
        var cooldownBurn: String? = null,
        var resource: String? = null,
        var leveltip: LevelTip? = null,
        var vars: List<ChampionSpellVar>? = null,
        var costType: String? = null,
        var image: Image? = null,
        var sanitizedDescription: String? = null,
        var sanitizedTooltip: String? = null,
        var effect: List<List<Double>>? = null,
        var tooltip: String? = null,
        var maxrank: Int? = null,
        var costBurn: String? = null,
        var rangeBurn: String? = null,
        var range: List<Int>? = null,   //This field is either a List of Integer or the String 'self' for spells that target one's own StaticDataService.
        var cooldown: List<Double>? = null,
        var cost: List<Int>? = null,
        var key: String? = null,
        var description: String? = null,
        var effectBurn: List<String>? = null,
        var altimages: List<Image>? = null,
        var name: String? = null) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readParcelable<LevelTip>(LevelTip::class.java.classLoader),
            source.createTypedArrayList(ChampionSpellVar.CREATOR),
            source.readString(),
            source.readParcelable<Image>(Image::class.java.classLoader),
            source.readString(),
            source.readString(),
            ArrayList<List<Double>>().apply { source.readList(this, List::class.java.classLoader) },
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readString(),
            ArrayList<Int>().apply { source.readList(this, Int::class.java.classLoader) },
            ArrayList<Double>().apply { source.readList(this, Double::class.java.classLoader) },
            ArrayList<Int>().apply { source.readList(this, Int::class.java.classLoader) },
            source.readString(),
            source.readString(),
            source.createStringArrayList(),
            source.createTypedArrayList(Image.CREATOR),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(cooldownBurn)
        writeString(resource)
        writeParcelable(leveltip, 0)
        writeTypedList(vars)
        writeString(costType)
        writeParcelable(image, 0)
        writeString(sanitizedDescription)
        writeString(sanitizedTooltip)
        writeList(effect)
        writeString(tooltip)
        writeValue(maxrank)
        writeString(costBurn)
        writeString(rangeBurn)
        writeList(range)
        writeList(cooldown)
        writeList(cost)
        writeString(key)
        writeString(description)
        writeStringList(effectBurn)
        writeTypedList(altimages)
        writeString(name)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ChampionSpell> = object : Parcelable.Creator<ChampionSpell> {
            override fun createFromParcel(source: Parcel): ChampionSpell = ChampionSpell(source)
            override fun newArray(size: Int): Array<ChampionSpell?> = arrayOfNulls(size)
        }
    }
}