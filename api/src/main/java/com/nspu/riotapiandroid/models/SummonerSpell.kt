package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


class SummonerSpell(
        var vars: List<SpellVars>? = null,
        var image: Image? = null,
        var costBurn: String? = null,
        var cooldown: List<Double>? = null,
        var effectBurn: List<String>? = null,
        var id: Int? = null,
        var cooldownBurn: String? = null,
        var tooltip: String? = null,
        var maxrank: Int? = null,
        var rangeBurn: String? = null,
        var description: String? = null,
        var effect: List<List<Double>>? = null,    //This field is a List of List of Double.
        var key: String? = null,
        var leveltip: LevelTip? = null,
        var modes: List<String>? = null,
        var resource: String? = null,
        var name: String? = null,
        var costType: String? = null,
        var sanitizedDescription: String? = null,
        var sanitizedTooltip: String? = null,
        var range: List<Int>? = null,    //This field is either a List of Integer or the String 'self' for spells that target one's own champion.
        var cost: List<Int>? = null,
        var summonerLevel: Int? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.createTypedArrayList(SpellVars.CREATOR),
            source.readParcelable<Image>(Image::class.java.classLoader),
            source.readString(),
            ArrayList<Double>().apply { source.readList(this, Double::class.java.classLoader) },
            source.createStringArrayList(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readString(),
            ArrayList<List<Double>>().apply { source.readList(this, List::class.java.classLoader) },
            source.readString(),
            source.readParcelable<LevelTip>(LevelTip::class.java.classLoader),
            source.createStringArrayList(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            ArrayList<Int>().apply { source.readList(this, Int::class.java.classLoader) },
            ArrayList<Int>().apply { source.readList(this, Int::class.java.classLoader) },
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(vars)
        writeParcelable(image, 0)
        writeString(costBurn)
        writeList(cooldown)
        writeStringList(effectBurn)
        writeValue(id)
        writeString(cooldownBurn)
        writeString(tooltip)
        writeValue(maxrank)
        writeString(rangeBurn)
        writeString(description)
        writeList(effect)
        writeString(key)
        writeParcelable(leveltip, 0)
        writeStringList(modes)
        writeString(resource)
        writeString(name)
        writeString(costType)
        writeString(sanitizedDescription)
        writeString(sanitizedTooltip)
        writeList(range)
        writeList(cost)
        writeValue(summonerLevel)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<SummonerSpell> = object : Parcelable.Creator<SummonerSpell> {
            override fun createFromParcel(source: Parcel): SummonerSpell = SummonerSpell(source)
            override fun newArray(size: Int): Array<SummonerSpell?> = arrayOfNulls(size)
        }
    }
}