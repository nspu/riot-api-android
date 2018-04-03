package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class ItemInventoryDataStats(
        var PercentCritDamageMod: Double? = null,
        var PercentSpellBlockMod: Double? = null,
        var PercentHPRegenMod: Double? = null,
        var PercentMovementSpeedMod: Double? = null,
        var FlatSpellBlockMod: Double? = null,
        var FlatCritDamageMod: Double? = null,
        var FlatEnergyPoolMod: Double? = null,
        var PercentLifeStealMod: Double? = null,
        var FlatMPPoolMod: Double? = null,
        var FlatMovementSpeedMod: Double? = null,
        var PercentAttackSpeedMod: Double? = null,
        var FlatBlockMod: Double? = null,
        var PercentBlockMod: Double? = null,
        var FlatEnergyRegenMod: Double? = null,
        var PercentSpellVampMod: Double? = null,
        var FlatMPRegenMod: Double? = null,
        var PercentDodgeMod: Double? = null,
        var FlatAttackSpeedMod: Double? = null,
        var FlatArmorMod: Double? = null,
        var FlatHPRegenMod: Double? = null,
        var PercentMagicDamageMod: Double? = null,
        var PercentMPPoolMod: Double? = null,
        var FlatMagicDamageMod: Double? = null,
        var PercentMPRegenMod: Double? = null,
        var PercentPhysicalDamageMod: Double? = null,
        var FlatPhysicalDamageMod: Double? = null,
        var PercentHPPoolMod: Double? = null,
        var PercentArmorMod: Double? = null,
        var PercentCritChanceMod: Double? = null,
        var PercentEXPBonus: Double? = null,
        var FlatHPPoolMod: Double? = null,
        var FlatCritChanceMod: Double? = null,
        var FlatEXPBonus: Double? = null
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
        writeValue(PercentCritDamageMod)
        writeValue(PercentSpellBlockMod)
        writeValue(PercentHPRegenMod)
        writeValue(PercentMovementSpeedMod)
        writeValue(FlatSpellBlockMod)
        writeValue(FlatCritDamageMod)
        writeValue(FlatEnergyPoolMod)
        writeValue(PercentLifeStealMod)
        writeValue(FlatMPPoolMod)
        writeValue(FlatMovementSpeedMod)
        writeValue(PercentAttackSpeedMod)
        writeValue(FlatBlockMod)
        writeValue(PercentBlockMod)
        writeValue(FlatEnergyRegenMod)
        writeValue(PercentSpellVampMod)
        writeValue(FlatMPRegenMod)
        writeValue(PercentDodgeMod)
        writeValue(FlatAttackSpeedMod)
        writeValue(FlatArmorMod)
        writeValue(FlatHPRegenMod)
        writeValue(PercentMagicDamageMod)
        writeValue(PercentMPPoolMod)
        writeValue(FlatMagicDamageMod)
        writeValue(PercentMPRegenMod)
        writeValue(PercentPhysicalDamageMod)
        writeValue(FlatPhysicalDamageMod)
        writeValue(PercentHPPoolMod)
        writeValue(PercentArmorMod)
        writeValue(PercentCritChanceMod)
        writeValue(PercentEXPBonus)
        writeValue(FlatHPPoolMod)
        writeValue(FlatCritChanceMod)
        writeValue(FlatEXPBonus)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ItemInventoryDataStats> = object : Parcelable.Creator<ItemInventoryDataStats> {
            override fun createFromParcel(source: Parcel): ItemInventoryDataStats = ItemInventoryDataStats(source)
            override fun newArray(size: Int): Array<ItemInventoryDataStats?> = arrayOfNulls(size)
        }
    }
}