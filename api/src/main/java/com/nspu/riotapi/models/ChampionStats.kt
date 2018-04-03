package com.nspu.riotapi.models

import android.os.Parcel
import android.os.Parcelable


data class ChampionStats(
        var armorperlevel: Double? = null,
        var hpperlevel: Double? = null,
        var attackdamage: Double? = null,
        var mpperlevel: Double? = null,
        var attackspeedoffset: Double? = null,
        var armor: Double? = null,
        var hp: Double? = null,
        var hpregenperlevel: Double? = null,
        var spellblock: Double? = null,
        var attackrange: Double? = null,
        var movespeed: Double? = null,
        var attackdamageperlevel: Double? = null,
        var mpregenperlevel: Double? = null,
        var mp: Double? = null,
        var spellblockperlevel: Double? = null,
        var crit: Double? = null,
        var mpregen: Double? = null,
        var attackspeedperlevel: Double? = null,
        var hpregen: Double? = null,
        var critperlevel: Double? = null
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(armorperlevel)
        writeValue(hpperlevel)
        writeValue(attackdamage)
        writeValue(mpperlevel)
        writeValue(attackspeedoffset)
        writeValue(armor)
        writeValue(hp)
        writeValue(hpregenperlevel)
        writeValue(spellblock)
        writeValue(attackrange)
        writeValue(movespeed)
        writeValue(attackdamageperlevel)
        writeValue(mpregenperlevel)
        writeValue(mp)
        writeValue(spellblockperlevel)
        writeValue(crit)
        writeValue(mpregen)
        writeValue(attackspeedperlevel)
        writeValue(hpregen)
        writeValue(critperlevel)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ChampionStats> = object : Parcelable.Creator<ChampionStats> {
            override fun createFromParcel(source: Parcel): ChampionStats = ChampionStats(source)
            override fun newArray(size: Int): Array<ChampionStats?> = arrayOfNulls(size)
        }
    }
}