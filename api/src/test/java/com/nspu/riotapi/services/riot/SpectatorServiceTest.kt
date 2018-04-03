package com.nspu.riotapi.Service

import com.nspu.riotapi.ServiceTest
import com.nspu.riotapi.TestUtils
import com.nspu.riotapi.models.SpectatorFeaturedGames
import com.nspu.riotapi.services.riot.SpectatorService
import okhttp3.Request
import okhttp3.mockwebserver.MockResponse
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mockito
import retrofit2.Retrofit
import java.io.IOException


class SpectatorServiceTest: ServiceTest() {
    private val SUMMONER_ID = 48509080L
    var service: SpectatorService? = null

    override fun implementService(retrofit: Retrofit) {
        service  = retrofit.create(SpectatorService::class.java)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetActiveGameBySummonerData() {
        val body = TestUtils.readTestData("active-game.json")
        val fixture = gson!!.fromJson(body, SpectatorFeaturedGames::class.java)

        val response = TestUtils.getResponseFromModel(fixture, SpectatorFeaturedGames::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.isA(Request::class.java)).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val featuredGames = service!!.getActiveGameBySummonerId(SUMMONER_ID)!!.execute().body()
        this.compareJSONWithoutNulls(body, featuredGames)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetChampionData() {
        val body = TestUtils.readTestData("featured-games.json")
        val fixture = gson!!.fromJson(body, SpectatorFeaturedGames::class.java)

        val response = TestUtils.getResponseFromModel(fixture, SpectatorFeaturedGames::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.isA(Request::class.java)).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val featuredGames = service!!.getFeaturedGame()!!.execute().body()
        this.compareJSONWithoutNulls(body, featuredGames)
    }
}