package fr.nspu.riot.api.Service

import android.os.Parcel
import android.os.Parcelable

import com.google.common.collect.Lists
import com.google.gson.GsonBuilder
import fr.nspu.riot.api.ModelAssert
import fr.nspu.riot.api.ModelPopulator
import fr.nspu.riot.api.TestUtils
import fr.nspu.riot.api.models.*

import org.fest.util.Arrays
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

import java.util.ArrayList

import org.fest.assertions.api.Assertions.assertThat

@RunWith(RobolectricTestRunner::class)
class ParcelableModelsTest {

    private val modelClasses: ArrayList<Class<out Parcelable>>
        get() = Lists.newArrayList(
                Image::class.java,
                ChampionListData::class.java,
                ChampionSpellVar::class.java,
                ChampionDataInfo::class.java,
                LevelTip::class.java,
                ChampionPassive::class.java,
                ChampionRecommandedBlockItem::class.java,
                ChampionRecommandedData::class.java,
                ChampionSkin::class.java,
                ChampionSpell::class.java,
                ChampionStats::class.java,
                ChampionData::class.java,
                Item::class.java,
                ItemGold::class.java,
                ItemGroup::class.java,
                ItemInventoryDataStats::class.java,
                ItemList::class.java,
                ItemTree::class.java,
                LanguageStrings::class.java,
                MapDetails::class.java,
                Maps::class.java,
                Mastery::class.java,
                MasteryList::class.java,
                MasteryTree::class.java,
                MasteryTreeItem::class.java,
                MasteryTreeList::class.java,
                ProfileIconData::class.java,
                ProfileIconDetails::class.java,
                Realm::class.java,
                ReforgedRune::class.java,
                ReforgedRunePath::class.java,
                ReforgedRuneSlot::class.java,
                MetaData::class.java,
                Rune::class.java,
                RuneList::class.java,
                RuneStats::class.java,
                SummonerSpell::class.java,
                SummonerSpellList::class.java,
                SpellVars::class.java,
                ChampionMastery::class.java,
                ChampionInfo::class.java,
                ChampionListInfo::class.java,
                LeagueItem::class.java,
                LeagueList::class.java,
                LeaguePosition::class.java,
                MiniSeries::class.java,
                Message::class.java,
                Service::class.java,
                ShardStatus::class.java,
                Translation::class.java,
                Match::class.java,
                MatchMastery::class.java,
                MatchParticipant::class.java,
                MatchParticipantIdentity::class.java,
                MatchParticipantStats::class.java,
                MatchParticipantTimeline::class.java,
                MatchPlayer::class.java,
                MatchRune::class.java,
                MatchTeamBans::class.java,
                MatchTeamStats::class.java,
                MatchList::class.java,
                MatchReference::class.java,
                MatchEvent::class.java,
                MatchFrame::class.java,
                MatchParticipantFrame::class.java,
                MatchPosition::class.java,
                MatchTimeline::class.java,
                SpectatorBannedChampion::class.java,
                SpectatorCurrentGameParticipant::class.java,
                SpectatorGameCustomization::class.java,
                SpectatorGameInfo::class.java,
                SpectatorObserver::class.java,
                SpectatorPerks::class.java,
                SpectatorFeaturedGames::class.java,
                Summoner::class.java,
                LobbyEvent::class.java,
                ProviderRegistrationParameters::class.java,
                TournamentCode::class.java,
                TournamentCodeParameters::class.java,
                TournamentCodeUpdateParameters::class.java,
                TournamentRegistrationParameters::class.java
        )

    @Test
    @Throws(IllegalAccessException::class, InstantiationException::class, NoSuchFieldException::class)
    fun allParcelables() {

        val populator = ModelPopulator("CREATOR", "\$jacocoData", "companion")

        for (modelClass in modelClasses) {

            val instance = populator.populateWithRandomValues(modelClass as Class<Parcelable>)

            testSingleParcelable(instance)
            testParcelableArray(instance)

            /* Trick to increase code coverage */
            instance.describeContents()
            (modelClass.getField("CREATOR").get(null) as Parcelable.Creator<*>).newArray(13)
        }
    }

    private fun <T : Parcelable> testSingleParcelable(underTest: T) {

        val parcel = Parcel.obtain()
        parcel.writeParcelable(underTest, 0)
        parcel.setDataPosition(0)
        val fromParcel = parcel.readParcelable<T>(underTest.javaClass.classLoader)

        ModelAssert.assertThat(fromParcel).isEqualByComparingFields(underTest)
    }

    private fun <T : Parcelable> testParcelableArray(underTest: T) {

        val parcel = Parcel.obtain()
        parcel.writeParcelableArray(Arrays.array(underTest, underTest), 0)
        parcel.setDataPosition(0)
        val fromParcel = parcel.readParcelableArray(underTest.javaClass.classLoader)

        assertThat(fromParcel).hasSize(2)
        assertThat(fromParcel[0]).isEqualsToByComparingFields(underTest)
        assertThat(fromParcel[1]).isEqualsToByComparingFields(underTest)
    }

}