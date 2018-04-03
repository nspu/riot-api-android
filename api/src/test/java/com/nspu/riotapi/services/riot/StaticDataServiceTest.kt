package com.nspu.riotapi.Service

import com.nspu.riotapi.ServiceTest
import com.nspu.riotapi.TestUtils
import com.nspu.riotapi.models.*
import com.nspu.riotapi.services.riot.StaticDataService
import okhttp3.Request
import okhttp3.mockwebserver.MockResponse
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Matchers.argThat
import org.mockito.Matchers.isA
import org.mockito.Mockito.`when`
import org.robolectric.RobolectricTestRunner
import retrofit2.Retrofit
import java.io.IOException

/**
 * Inspired by spotify-web-api-android
 */
class StaticDataServiceTest : ServiceTest() {

    var service: StaticDataService? = null

    override fun implementService(retrofit: Retrofit) {
        service = retrofit.create(StaticDataService::class.java)
    }


    @Test
    @Throws(IOException::class)
    fun shouldGetChampionsData() {
        val body = TestUtils.readTestData("champions.json")
        val fixture = gson!!.fromJson(body, ChampionListData::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ChampionListData::class.java)
        `when`(mockClient!!.newCall(isA(Request::class.java)).execute()).thenReturn(response)

        var options: Map<String, String> = hashMapOf("tags" to "all", "champListData" to "all")
        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val champions = service!!.getChampions(options)!!.execute().body()
        this.compareJSONWithoutNulls(body, champions)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetChampionData() {
        val body = TestUtils.readTestData("champion-wukong.json")
        val fixture = gson!!.fromJson(body, ChampionData::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ChampionData::class.java)
        `when`(mockClient!!.newCall(isA(Request::class.java)).execute()).thenReturn(response)

        val options: Map<String, String> = hashMapOf("tags" to "all", "champData" to "all")
        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val champion = service!!.getChampion(0, options)!!.execute().body()
        this.compareJSONWithoutNulls(body, champion)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetItemsData() {
        val body = TestUtils.readTestData("items.json")
        val fixture = gson!!.fromJson(body, ItemList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ItemList::class.java)
        `when`(mockClient!!.newCall(isA(Request::class.java)).execute()).thenReturn(response)

        val options: Map<String, String> = hashMapOf("tags" to "all", "itemListData" to "all")
        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val items = service!!.getItems(options)!!.execute().body()
        this.compareJSONWithoutNulls(body, items)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetItemData() {
        val body = TestUtils.readTestData("item-wardens-mail.json")
        val fixture = gson!!.fromJson(body, Item::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Item::class.java)
        `when`(mockClient!!.newCall(argThat(MatchesId(fixture.id!!.toString()))).execute()).thenReturn(response)


        val options: Map<String, String> = hashMapOf("tags" to "all", "itemData" to "all")
        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val item = service!!.getItem(fixture.id!!, options)!!.execute().body()
        this.compareJSONWithoutNulls(body, item)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetLanguageStringsData() {
        val body = TestUtils.readTestData("language-strings.json")
        val fixture = gson!!.fromJson(body, LanguageStrings::class.java)

        val response = TestUtils.getResponseFromModel(fixture, LanguageStrings::class.java)
        `when`(mockClient!!.newCall(isA(Request::class.java)).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val languageStrings = service!!.getLanguageString()!!.execute().body()
        this.compareJSONWithoutNulls(body, languageStrings)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetLanguagesData() {
        val body = TestUtils.readTestData("languages.json")
        val fixture = gson!!.fromJson(body, List::class.java)

        val response = TestUtils.getResponseFromModel(fixture, List::class.java)
        `when`(mockClient!!.newCall(isA(Request::class.java)).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val languages = service!!.getLanguages()!!.execute().body()
        this.compareJSONWithoutNulls(body, languages)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetMapsData() {
        val body = TestUtils.readTestData("maps.json")
        val fixture = gson!!.fromJson(body, Maps::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Maps::class.java)
        `when`(mockClient!!.newCall(isA(Request::class.java)).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val maps = service!!.getMaps()!!.execute().body()
        this.compareJSONWithoutNulls(body, maps)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetMasteriesData() {
        val body = TestUtils.readTestData("masteries.json")
        val fixture = gson!!.fromJson(body, MasteryList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, MasteryList::class.java)
        `when`(mockClient!!.newCall(isA(Request::class.java)).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val options: Map<String, String> = hashMapOf("tags" to "all", "masteryListData" to "all")
        val masteries = service!!.getMasteries(options)!!.execute().body()
        this.compareJSONWithoutNulls(body, masteries)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetMasteryData() {
        val body = TestUtils.readTestData("mastery.json")
        val fixture = gson!!.fromJson(body, Mastery::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Mastery::class.java)
        `when`(mockClient!!.newCall(argThat(MatchesId(fixture.id!!.toString()))).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val options: Map<String, String> = hashMapOf("tags" to "all", "masteryData" to "all")
        val mastery = service!!.getMastery(fixture.id!!, options)!!.execute().body()
        this.compareJSONWithoutNulls(body, mastery)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetProfileIconsData() {
        val body = TestUtils.readTestData("profile-icons.json")
        val fixture = gson!!.fromJson(body, ProfileIconData::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ProfileIconData::class.java)
        `when`(mockClient!!.newCall(isA(Request::class.java)).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val profileIconData = service!!.getProfileIcons()!!.execute().body()
        this.compareJSONWithoutNulls(body, profileIconData)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetRealmsData() {
        val body = TestUtils.readTestData("realms.json")
        val fixture = gson!!.fromJson(body, Realm::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Realm::class.java)
        `when`(mockClient!!.newCall(isA(Request::class.java)).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val realm = service!!.getRealms()!!.execute().body()
        this.compareJSONWithoutNulls(body, realm)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetReforgedRunePathsData() {
        val body = TestUtils.readTestData("reforged-rune-paths.json")
        val fixture = gson!!.fromJson(body, List::class.java)

        val response = TestUtils.getResponseFromModel(fixture, List::class.java)
        `when`(mockClient!!.newCall(isA(Request::class.java)).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val reforgedRunePaths = service!!.getReforgedRunePaths()!!.execute().body()
        this.compareJSONWithoutNulls(body, reforgedRunePaths)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetReforgedRunePathData() {
        val body = TestUtils.readTestData("reforged-rune-path.json")
        val fixture = gson!!.fromJson(body, ReforgedRunePath::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ReforgedRunePath::class.java)
        `when`(mockClient!!.newCall(argThat(MatchesId(fixture.id!!.toString()))).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val reforgedRunePath = service!!.getReforgedRunePath(fixture.id!!)!!.execute().body()
        this.compareJSONWithoutNulls(body, reforgedRunePath)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetReforgedRunesData() {
        val body = TestUtils.readTestData("reforged-runes.json")
        val fixture = gson!!.fromJson(body, List::class.java)

        val response = TestUtils.getResponseFromModel(fixture, List::class.java)
        `when`(mockClient!!.newCall(isA(Request::class.java)).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val reforgedRunes = service!!.getReforgedRunes()!!.execute().body()
        this.compareJSONWithoutNulls(body, reforgedRunes)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetReforgedRuneData() {
        val body = TestUtils.readTestData("reforged-rune.json")
        val fixture = gson!!.fromJson(body, ReforgedRune::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ReforgedRune::class.java)
        `when`(mockClient!!.newCall(argThat(MatchesId(fixture.id!!.toString()))).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val reforgedRune = service!!.getReforgedRune(fixture.id!!)!!.execute().body()
        this.compareJSONWithoutNulls(body, reforgedRune)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetRunesData() {
        val body = TestUtils.readTestData("runes.json")
        val fixture = gson!!.fromJson(body, RuneList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, RuneList::class.java)
        `when`(mockClient!!.newCall(isA(Request::class.java)).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val options: Map<String, String> = hashMapOf("tags" to "all", "runeListData" to "all")

        val runes = service!!.getRunes(options)!!.execute().body()
        this.compareJSONWithoutNulls(body, runes)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetRuneData() {
        val body = TestUtils.readTestData("rune.json")
        val fixture = gson!!.fromJson(body, Rune::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Rune::class.java)
        `when`(mockClient!!.newCall(argThat(MatchesId(fixture.id!!.toString()))).execute()).thenReturn(response)


        val options: Map<String, String> = hashMapOf("tags" to "all", "runeData" to "all")
        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val rune = service!!.getRune(fixture.id!!, options)!!.execute().body()
        this.compareJSONWithoutNulls(body, rune)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetSummonerSpellsData() {
        val body = TestUtils.readTestData("summoner-spells.json")
        val fixture = gson!!.fromJson(body, SummonerSpellList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, SummonerSpellList::class.java)
        `when`(mockClient!!.newCall(isA(Request::class.java)).execute()).thenReturn(response)

        val options: Map<String, String> = hashMapOf("tags" to "all", "spellListData" to "all")
        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val summonerSpells = service!!.getSummonerSpells(options)!!.execute().body()
        this.compareJSONWithoutNulls(body, summonerSpells)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetSummonerSpellData() {
        val body = TestUtils.readTestData("summoner-spell.json")
        val fixture = gson!!.fromJson(body, SummonerSpell::class.java)

        val response = TestUtils.getResponseFromModel(fixture, SummonerSpell::class.java)
        `when`(mockClient!!.newCall(argThat(MatchesId(fixture.id!!.toString()))).execute()).thenReturn(response)


        val options: Map<String, String> = hashMapOf("tags" to "all", "spellData" to "all")
        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val rune = service!!.getSummonerSpell(fixture.id!!, options)!!.execute().body()
        this.compareJSONWithoutNulls(body, rune)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetTabarballLinksData() {
        val body = TestUtils.readTestData("tarball-links.json")
        val fixture = gson!!.fromJson(body, String::class.java)

        val response = TestUtils.getResponseFromModel(fixture, String::class.java)
        `when`(mockClient!!.newCall(isA(Request::class.java)).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val tarballLinks = service!!.getTarballLinks()!!.execute().body()
        this.compareJSONWithoutNulls(body, tarballLinks)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetVersionsData() {
        val body = TestUtils.readTestData("versions.json")
        val fixture = gson!!.fromJson(body, List::class.java)

        val response = TestUtils.getResponseFromModel(fixture, List::class.java)
        `when`(mockClient!!.newCall(isA(Request::class.java)).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val versions = service!!.getVersions()!!.execute().body()
        this.compareJSONWithoutNulls(body, versions)
    }
}
