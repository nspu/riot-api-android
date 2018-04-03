package fr.nspu.riot.api.Service

import fr.nspu.riot.api.ServiceTest
import fr.nspu.riot.api.TestUtils
import fr.nspu.riot.api.models.Summoner
import fr.nspu.riot.api.services.riot.SummonerService
import okhttp3.mockwebserver.MockResponse
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mockito
import retrofit2.Retrofit
import java.io.IOException



class SummonerServiceTest: ServiceTest() {
    var service: SummonerService? = null

    override fun implementService(retrofit: Retrofit) {
        service  = retrofit.create(SummonerService::class.java)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetSummonerByAccountIdData() {
        val body = TestUtils.readTestData("summoner.json")
        val fixture = gson!!.fromJson(body, Summoner::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Summoner::class.java)
        Mockito.`when`(
                mockClient!!.newCall(
                        Matchers.argThat(
                                MatchesId(
                                        fixture.accountId!!.toString())))
                        .execute())
                .thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val summoner = service!!.getSummonerByAccountId(fixture.accountId!!)!!.execute()
        this.compareJSONWithoutNulls(body, summoner!!.body())
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetSummonerBySummonerNameData() {
        val body = TestUtils.readTestData("summoner.json")
        val fixture = gson!!.fromJson(body, Summoner::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Summoner::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.argThat(MatchesId(fixture.name!!))).execute()).thenReturn( response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val summoner = service!!.getSummonerByName(fixture.name!!)!!.execute().body()
        this.compareJSONWithoutNulls(body, summoner)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetSummonerBySummonerIdData() {
        val body = TestUtils.readTestData("summoner.json")
        val fixture = gson!!.fromJson(body, Summoner::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Summoner::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.argThat(MatchesId(fixture.id!!.toString()))).execute()).thenReturn( response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val summoner = service!!.getSummonerBySummonerId(fixture.id!!)!!.execute().body()
        this.compareJSONWithoutNulls(body, summoner)
    }
}