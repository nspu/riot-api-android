package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


class ChampionData(
        var info: ChampionDataInfo? = null,
        var enemytips: List<String>? = null,
        var stats: ChampionStats? = null,
        var name: String? = null,
        var title: String? = null,
        var image: Image? = null,
        var tags: List<String>? = null,
        var partype: String? = null,
        var skins: List<ChampionSkin>? = null,
        var passive: ChampionPassive? = null,
        var recommended: List<ChampionRecommandedData>? = null,
        var allytips: List<String>? = null,
        var key: String? = null,
        var lore: String? = null,
        var id: Any? = null,
        var blurb: String? = null,
        var spells: List<ChampionSpell>? = null) : Parcelable {


    var championId: Int? = null
        set
        get() {
            if (id != null && id is Int) {
                return id as Int
            } else if (key != null) {
                return key!!.toIntOrNull()
            }
            return null
        }
    var nameKey: String? = null
        set
        get() {
            if (id != null && !(id is Int)) {
                return id as String
            } else if (key != null) {
                return key!!
            }
            return null
        }

    constructor(source: Parcel) : this(
            source.readParcelable<ChampionDataInfo>(ChampionDataInfo::class.java.classLoader),
            source.createStringArrayList(),
            source.readParcelable<ChampionStats>(ChampionStats::class.java.classLoader),
            source.readString(),
            source.readString(),
            source.readParcelable<Image>(Image::class.java.classLoader),
            source.createStringArrayList(),
            source.readString(),
            source.createTypedArrayList(ChampionSkin.CREATOR),
            source.readParcelable<ChampionPassive>(ChampionPassive::class.java.classLoader),
            source.createTypedArrayList(ChampionRecommandedData.CREATOR),
            source.createStringArrayList(),
            source.readString(),
            source.readString(),
            source.readValue(Any::class.java.classLoader),
            source.readString(),
            source.createTypedArrayList(ChampionSpell.CREATOR)) {
    }

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeParcelable(info, 0)
        writeStringList(enemytips)
        writeParcelable(stats, 0)
        writeString(name)
        writeString(title)
        writeParcelable(image, 0)
        writeStringList(tags)
        writeString(partype)
        writeTypedList(skins)
        writeParcelable(passive, 0)
        writeTypedList(recommended)
        writeStringList(allytips)
        writeString(key)
        writeString(lore)
        writeValue(id)
        writeString(blurb)
        writeTypedList(spells)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ChampionData> = object : Parcelable.Creator<ChampionData> {
            override fun createFromParcel(source: Parcel): ChampionData {
                return ChampionData(source)
            }

            override fun newArray(size: Int): Array<ChampionData?> {
                return arrayOfNulls(size)
            }
        }
    }


}