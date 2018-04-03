package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class ChampionSpellVar(var ranksWith: String? = null,
                            var dyn: String? = null,
                            var link: String? = null,
                            var coeff: Any? = null,
                            var key: String? = null,
                            var coefficient: List<Double>? = null) : Parcelable {
    init {
        if (coeff is List<*>) {
            coefficient = coeff as List<Double>
        } else if (coeff is Double) {
            if (coeff != null) coefficient = arrayListOf(coeff as Double)
        }
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readValue(Any::class.java.classLoader),
            source.readString(),
            ArrayList<Double>().apply { source.readList(this, Double::class.java.classLoader) }
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(ranksWith)
        writeString(dyn)
        writeString(link)
        writeValue(coeff)
        writeString(key)
        writeList(coefficient)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ChampionSpellVar> = object : Parcelable.Creator<ChampionSpellVar> {
            override fun createFromParcel(source: Parcel): ChampionSpellVar = ChampionSpellVar(source)
            override fun newArray(size: Int): Array<ChampionSpellVar?> = arrayOfNulls(size)
        }
    }
}
