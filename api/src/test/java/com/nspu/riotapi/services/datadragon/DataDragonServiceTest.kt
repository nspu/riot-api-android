package com.nspu.riotapi.Service

import com.nspu.riotapi.ServiceTest
import com.nspu.riotapi.TestUtils
import com.nspu.riotapi.models.*
import com.nspu.riotapi.services.datadragon.DataDragonService
import okhttp3.Request
import okhttp3.mockwebserver.MockResponse
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mockito
import retrofit2.Retrofit
import java.io.IOException

class DataDragonServiceTest : ServiceTest() {
    var service: DataDragonService? = null
    override fun implementService(retrofit: Retrofit) {
        service = retrofit.create(DataDragonService::class.java)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetProfileIconData() {
        val body = TestUtils.readTestData("profile-icons.json")
        val fixture = gson!!.fromJson(body, ProfileIconData::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ProfileIconData::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.isA(Request::class.java)).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val profileIconData = service!!.getProfileIcon("","")!!.execute().body()
        this.compareJSONWithoutNulls(body, profileIconData)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetChampionsData() {
        val body = TestUtils.readTestData("champions.json")
        val fixture = gson!!.fromJson(body, ChampionListData::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ChampionListData::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.isA(Request::class.java)).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val championListData = service!!.getChampions("","")!!.execute().body()
        this.compareJSONWithoutNulls(body, championListData)
    }

    //Disable because the Riot Data dragon api is not update
//    @Test
//    @Throws(IOException::class)
//    fun shouldGetChampionData() {
//        val body = TestUtils.readTestData("champion-data-dragon.json")
//        val fixture = gson!!.fromJson(body, ChampionListData::class.java)
//
//        val response = TestUtils.getResponseFromModel(fixture, ChampionListData::class.java)
//        Mockito.`when`(mockClient!!.newCall(Matchers.isA(Request::class.java)).execute()).thenReturn( response )
//
//        val championData = service!!.getChampion("","","")
//        this.compareJSONWithoutNulls(body, championData)
//    }

    @Test
    @Throws(IOException::class)
    fun shouldGetItemsData() {
        val body = TestUtils.readTestData("items.json")
        val fixture = gson!!.fromJson(body, ItemList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ItemList::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.isA(Request::class.java)).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val items = service!!.getItems("","")!!.execute().body()
        this.compareJSONWithoutNulls(body, items)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetMasteriesData() {
        val body = TestUtils.readTestData("masteries.json")
        val fixture = gson!!.fromJson(body, MasteryList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, MasteryList::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.isA(Request::class.java)).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val masteries = service!!.getMasteries("","")!!.execute().body()
        this.compareJSONWithoutNulls(body, masteries)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetRunesData() {
        val body = TestUtils.readTestData("runes.json")
        val fixture = gson!!.fromJson(body, RuneList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, RuneList::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.isA(Request::class.java)).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val runes = service!!.getRunes("","")!!.execute().body()
        this.compareJSONWithoutNulls(body, runes)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetSummonerSpellsData() {
        val body = TestUtils.readTestData("summoner-spells.json")
        val fixture = gson!!.fromJson(body, SummonerSpellList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, SummonerSpellList::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.isA(Request::class.java)).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val summonerSpells = service!!.getSummonerSpells("","")!!.execute().body()
        this.compareJSONWithoutNulls(body, summonerSpells)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetVersionsData() {
        val body = TestUtils.readTestData("versions.json")
        val fixture = gson!!.fromJson(body, List::class.java)

        val response = TestUtils.getResponseFromModel(fixture, List::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.isA(Request::class.java)).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val versions = service!!.getVersions()!!.execute().body()
        this.compareJSONWithoutNulls(body, versions)
    }


    @Test
    @Throws(IOException::class)
    fun shouldGetLanguagesData() {
        val body = TestUtils.readTestData("languages.json")
        val fixture = gson!!.fromJson(body, List::class.java)

        val response = TestUtils.getResponseFromModel(fixture, List::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.isA(Request::class.java)).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val languages = service!!.getLanguages()!!.execute().body()
        this.compareJSONWithoutNulls(body, languages)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetLanguageStringsData() {
        val body = TestUtils.readTestData("language-strings.json")
        val fixture = gson!!.fromJson(body, LanguageStrings::class.java)

        val response = TestUtils.getResponseFromModel(fixture, LanguageStrings::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.isA(Request::class.java)).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val languageStrings = service!!.getLanguageString().execute().body()
        this.compareJSONWithoutNulls(body, languageStrings)
    }

}