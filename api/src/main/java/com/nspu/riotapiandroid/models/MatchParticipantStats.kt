package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable


data class MatchParticipantStats(
        var physicalDamageDealt: Long? = null,
        var neutralMinionsKilledTeamJungle: Int? = null,
        var magicDamageDealt: Long? = null,
        var totalPlayerScore: Int? = null,
        var deaths: Int? = null,
        var win: Boolean? = null,
        var neutralMinionsKilledEnemyJungle: Int? = null,
        var altarsCaptured: Int? = null,
        var largestCriticalStrike: Int? = null,
        var totalDamageDealt: Long? = null,
        var magicDamageDealtToChampions: Long? = null,
        var visionWardsBoughtInGame: Int? = null,
        var damageDealtToObjectives: Long? = null,
        var largestKillingSpree: Int? = null,
        var item1: Int? = null,
        var quadraKills: Int? = null,
        var teamObjective: Int? = null,
        var totalTimeCrowdControlDealt: Int? = null,
        var longestTimeSpentLiving: Int? = null,
        var wardsKilled: Int? = null,
        var firstTowerAssist: Boolean? = null,
        var firstTowerKill: Boolean? = null,
        var item2: Int? = null,
        var item3: Int? = null,
        var item0: Int? = null,
        var firstBloodAssist: Boolean? = null,
        var visionScore: Long? = null,
        var wardsPlaced: Int? = null,
        var item4: Int? = null,
        var item5: Int? = null,
        var item6: Int? = null,
        var turretKills: Int? = null,
        var tripleKills: Int? = null,
        var damageSelfMitigated: Long? = null,
        var champLevel: Int? = null,
        var nodeNeutralizeAssist: Int? = null,
        var firstInhibitorKill: Boolean? = null,
        var goldEarned: Int? = null,
        var magicalDamageTaken: Long? = null,
        var kills: Int? = null,
        var doubleKills: Int? = null,
        var nodeCaptureAssist: Int? = null,
        var trueDamageTaken: Long? = null,
        var nodeNeutralize: Int? = null,
        var firstInhibitorAssist: Boolean? = null,
        var assists: Int? = null,
        var unrealKills: Int? = null,
        var neutralMinionsKilled: Int? = null,
        var objectivePlayerScore: Int? = null,
        var combatPlayerScore: Int? = null,
        var damageDealtToTurrets: Long? = null,
        var altarsNeutralized: Int? = null,
        var physicalDamageDealtToChampions: Long? = null,
        var goldSpent: Int? = null,
        var trueDamageDealt: Long? = null,
        var trueDamageDealtToChampions: Long? = null,
        var participantId: Int? = null,
        var pentaKills: Int? = null,
        var totalHeal: Long? = null,
        var totalMinionsKilled: Int? = null,
        var firstBloodKill: Boolean? = null,
        var nodeCapture: Int? = null,
        var largestMultiKill: Int? = null,
        var sightWardsBoughtInGame: Int? = null,
        var totalDamageDealtToChampions: Long? = null,
        var totalUnitsHealed: Int? = null,
        var inhibitorKills: Int? = null,
        var totalScoreRank: Int? = null,
        var totalDamageTaken: Long? = null,
        var killingSprees: Int? = null,
        var timeCCingOthers: Long? = null,
        var physicalDamageTaken: Long? = null,
        var perk0: Int? = null,
        var perk0Var1: Int? = null,
        var perk0Var2: Int? = null,
        var perk0Var3: Int? = null,
        var perk1: Int? = null,
        var perk1Var1: Int? = null,
        var perk1Var2: Int? = null,
        var perk1Var3: Int? = null,
        var perk2: Int? = null,
        var perk2Var1: Int? = null,
        var perk2Var2: Int? = null,
        var perk2Var3: Int? = null,
        var perk3: Int? = null,
        var perk3Var1: Int? = null,
        var perk3Var2: Int? = null,
        var perk3Var3: Int? = null,
        var perk4: Int? = null,
        var perk4Var1: Int? = null,
        var perk4Var2: Int? = null,
        var perk4Var3: Int? = null,
        var perk5: Int? = null,
        var perk5Var1: Int? = null,
        var perk5Var2: Int? = null,
        var perk5Var3: Int? = null,
        var perkPrimaryStyle: Int? = null,
        var perkSubStyle: Int? = null,
        var playerScore0: Int? = 0,
        var playerScore1: Int? = 0,
        var playerScore2: Int? = 0,
        var playerScore3: Int? = 0,
        var playerScore4: Int? = 0,
        var playerScore5: Int? = 0,
        var playerScore6: Int? = 0,
        var playerScore7: Int? = 0,
        var playerScore8: Int? = 0,
        var playerScore9: Int? = 0
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Boolean::class.java.classLoader) as Boolean?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Long::class.java.classLoader) as Long?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readValue(Int::class.java.classLoader) as Int?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(physicalDamageDealt)
        writeValue(neutralMinionsKilledTeamJungle)
        writeValue(magicDamageDealt)
        writeValue(totalPlayerScore)
        writeValue(deaths)
        writeValue(win)
        writeValue(neutralMinionsKilledEnemyJungle)
        writeValue(altarsCaptured)
        writeValue(largestCriticalStrike)
        writeValue(totalDamageDealt)
        writeValue(magicDamageDealtToChampions)
        writeValue(visionWardsBoughtInGame)
        writeValue(damageDealtToObjectives)
        writeValue(largestKillingSpree)
        writeValue(item1)
        writeValue(quadraKills)
        writeValue(teamObjective)
        writeValue(totalTimeCrowdControlDealt)
        writeValue(longestTimeSpentLiving)
        writeValue(wardsKilled)
        writeValue(firstTowerAssist)
        writeValue(firstTowerKill)
        writeValue(item2)
        writeValue(item3)
        writeValue(item0)
        writeValue(firstBloodAssist)
        writeValue(visionScore)
        writeValue(wardsPlaced)
        writeValue(item4)
        writeValue(item5)
        writeValue(item6)
        writeValue(turretKills)
        writeValue(tripleKills)
        writeValue(damageSelfMitigated)
        writeValue(champLevel)
        writeValue(nodeNeutralizeAssist)
        writeValue(firstInhibitorKill)
        writeValue(goldEarned)
        writeValue(magicalDamageTaken)
        writeValue(kills)
        writeValue(doubleKills)
        writeValue(nodeCaptureAssist)
        writeValue(trueDamageTaken)
        writeValue(nodeNeutralize)
        writeValue(firstInhibitorAssist)
        writeValue(assists)
        writeValue(unrealKills)
        writeValue(neutralMinionsKilled)
        writeValue(objectivePlayerScore)
        writeValue(combatPlayerScore)
        writeValue(damageDealtToTurrets)
        writeValue(altarsNeutralized)
        writeValue(physicalDamageDealtToChampions)
        writeValue(goldSpent)
        writeValue(trueDamageDealt)
        writeValue(trueDamageDealtToChampions)
        writeValue(participantId)
        writeValue(pentaKills)
        writeValue(totalHeal)
        writeValue(totalMinionsKilled)
        writeValue(firstBloodKill)
        writeValue(nodeCapture)
        writeValue(largestMultiKill)
        writeValue(sightWardsBoughtInGame)
        writeValue(totalDamageDealtToChampions)
        writeValue(totalUnitsHealed)
        writeValue(inhibitorKills)
        writeValue(totalScoreRank)
        writeValue(totalDamageTaken)
        writeValue(killingSprees)
        writeValue(timeCCingOthers)
        writeValue(physicalDamageTaken)
        writeValue(perk0)
        writeValue(perk0Var1)
        writeValue(perk0Var2)
        writeValue(perk0Var3)
        writeValue(perk1)
        writeValue(perk1Var1)
        writeValue(perk1Var2)
        writeValue(perk1Var3)
        writeValue(perk2)
        writeValue(perk2Var1)
        writeValue(perk2Var2)
        writeValue(perk2Var3)
        writeValue(perk3)
        writeValue(perk3Var1)
        writeValue(perk3Var2)
        writeValue(perk3Var3)
        writeValue(perk4)
        writeValue(perk4Var1)
        writeValue(perk4Var2)
        writeValue(perk4Var3)
        writeValue(perk5)
        writeValue(perk5Var1)
        writeValue(perk5Var2)
        writeValue(perk5Var3)
        writeValue(perkPrimaryStyle)
        writeValue(perkSubStyle)
        writeValue(playerScore0)
        writeValue(playerScore1)
        writeValue(playerScore2)
        writeValue(playerScore3)
        writeValue(playerScore4)
        writeValue(playerScore5)
        writeValue(playerScore6)
        writeValue(playerScore7)
        writeValue(playerScore8)
        writeValue(playerScore9)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MatchParticipantStats> = object : Parcelable.Creator<MatchParticipantStats> {
            override fun createFromParcel(source: Parcel): MatchParticipantStats = MatchParticipantStats(source)
            override fun newArray(size: Int): Array<MatchParticipantStats?> = arrayOfNulls(size)
        }
    }
}