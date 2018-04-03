package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class RuneStats(
        var PercentTimeDeadModPerLevel: Double? = null,
        var PercentArmorPenetrationModPerLevel: Double? = null,
        var PercentCritDamageMod: Double? = null,
        var PercentSpellBlockMod: Double? = null,
        var PercentHPRegenMod: Double? = null,
        var PercentMovementSpeedMod: Double? = null,
        var FlatSpellBlockMod: Double? = null,
        var FlatEnergyRegenModPerLevel: Double? = null,
        var FlatEnergyPoolMod: Double? = null,
        var FlatMagicPenetrationModPerLevel: Double? = null,
        var PercentLifeStealMod: Double? = null,
        var FlatMPPoolMod: Double? = null,
        var PercentCooldownMod: Double? = null,
        var PercentMagicPenetrationMod: Double? = null,
        var FlatArmorPenetrationModPerLevel: Double? = null,
        var FlatMovementSpeedMod: Double? = null,
        var FlatTimeDeadModPerLevel: Double? = null,
        var FlatArmorModPerLevel: Double? = null,
        var PercentAttackSpeedMod: Double? = null,
        var FlatDodgeModPerLevel: Double? = null,
        var PercentMagicDamageMod: Double? = null,
        var PercentBlockMod: Double? = null,
        var FlatDodgeMod: Double? = null,
        var FlatEnergyRegenMod: Double? = null,
        var FlatHPModPerLevel: Double? = null,
        var PercentAttackSpeedModPerLevel: Double? = null,
        var PercentSpellVampMod: Double? = null,
        var FlatMPRegenMod: Double? = null,
        var PercentHPPoolMod: Double? = null,
        var PercentDodgeMod: Double? = null,
        var FlatAttackSpeedMod: Double? = null,
        var FlatArmorMod: Double? = null,
        var FlatMagicDamageModPerLevel: Double? = null,
        var FlatHPRegenMod: Double? = null,
        var PercentPhysicalDamageMod: Double? = null,
        var FlatCritChanceModPerLevel: Double? = null,
        var FlatSpellBlockModPerLevel: Double? = null,
        var PercentTimeDeadMod: Double? = null,
        var FlatBlockMod: Double? = null,
        var PercentMPPoolMod: Double? = null,
        var FlatMagicDamageMod: Double? = null,
        var PercentMPRegenMod: Double? = null,
        var PercentMovementSpeedModPerLevel: Double? = null,
        var PercentCooldownModPerLevel: Double? = null,
        var FlatMPModPerLevel: Double? = null,
        var FlatEnergyModPerLevel: Double? = null,
        var FlatPhysicalDamageMod: Double? = null,
        var FlatHPRegenModPerLevel: Double? = null,
        var FlatCritDamageMod: Double? = null,
        var PercentArmorMod: Double? = null,
        var FlatMagicPenetrationMod: Double? = null,
        var PercentCritChanceMod: Double? = null,
        var FlatPhysicalDamageModPerLevel: Double? = null,
        var PercentArmorPenetrationMod: Double? = null,
        var PercentEXPBonus: Double? = null,
        var FlatMPRegenModPerLevel: Double? = null,
        var PercentMagicPenetrationModPerLevel: Double? = null,
        var FlatTimeDeadMod: Double? = null,
        var FlatMovementSpeedModPerLevel: Double? = null,
        var FlatGoldPer10Mod: Double? = null,
        var FlatArmorPenetrationMod: Double? = null,
        var FlatCritDamageModPerLevel: Double? = null,
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
        writeValue(PercentTimeDeadModPerLevel)
        writeValue(PercentArmorPenetrationModPerLevel)
        writeValue(PercentCritDamageMod)
        writeValue(PercentSpellBlockMod)
        writeValue(PercentHPRegenMod)
        writeValue(PercentMovementSpeedMod)
        writeValue(FlatSpellBlockMod)
        writeValue(FlatEnergyRegenModPerLevel)
        writeValue(FlatEnergyPoolMod)
        writeValue(FlatMagicPenetrationModPerLevel)
        writeValue(PercentLifeStealMod)
        writeValue(FlatMPPoolMod)
        writeValue(PercentCooldownMod)
        writeValue(PercentMagicPenetrationMod)
        writeValue(FlatArmorPenetrationModPerLevel)
        writeValue(FlatMovementSpeedMod)
        writeValue(FlatTimeDeadModPerLevel)
        writeValue(FlatArmorModPerLevel)
        writeValue(PercentAttackSpeedMod)
        writeValue(FlatDodgeModPerLevel)
        writeValue(PercentMagicDamageMod)
        writeValue(PercentBlockMod)
        writeValue(FlatDodgeMod)
        writeValue(FlatEnergyRegenMod)
        writeValue(FlatHPModPerLevel)
        writeValue(PercentAttackSpeedModPerLevel)
        writeValue(PercentSpellVampMod)
        writeValue(FlatMPRegenMod)
        writeValue(PercentHPPoolMod)
        writeValue(PercentDodgeMod)
        writeValue(FlatAttackSpeedMod)
        writeValue(FlatArmorMod)
        writeValue(FlatMagicDamageModPerLevel)
        writeValue(FlatHPRegenMod)
        writeValue(PercentPhysicalDamageMod)
        writeValue(FlatCritChanceModPerLevel)
        writeValue(FlatSpellBlockModPerLevel)
        writeValue(PercentTimeDeadMod)
        writeValue(FlatBlockMod)
        writeValue(PercentMPPoolMod)
        writeValue(FlatMagicDamageMod)
        writeValue(PercentMPRegenMod)
        writeValue(PercentMovementSpeedModPerLevel)
        writeValue(PercentCooldownModPerLevel)
        writeValue(FlatMPModPerLevel)
        writeValue(FlatEnergyModPerLevel)
        writeValue(FlatPhysicalDamageMod)
        writeValue(FlatHPRegenModPerLevel)
        writeValue(FlatCritDamageMod)
        writeValue(PercentArmorMod)
        writeValue(FlatMagicPenetrationMod)
        writeValue(PercentCritChanceMod)
        writeValue(FlatPhysicalDamageModPerLevel)
        writeValue(PercentArmorPenetrationMod)
        writeValue(PercentEXPBonus)
        writeValue(FlatMPRegenModPerLevel)
        writeValue(PercentMagicPenetrationModPerLevel)
        writeValue(FlatTimeDeadMod)
        writeValue(FlatMovementSpeedModPerLevel)
        writeValue(FlatGoldPer10Mod)
        writeValue(FlatArmorPenetrationMod)
        writeValue(FlatCritDamageModPerLevel)
        writeValue(FlatHPPoolMod)
        writeValue(FlatCritChanceMod)
        writeValue(FlatEXPBonus)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<RuneStats> = object : Parcelable.Creator<RuneStats> {
            override fun createFromParcel(source: Parcel): RuneStats = RuneStats(source)
            override fun newArray(size: Int): Array<RuneStats?> = arrayOfNulls(size)
        }
    }
}