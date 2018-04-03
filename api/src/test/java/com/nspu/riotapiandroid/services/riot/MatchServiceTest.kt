package fr.nspu.riot.api.Service

import fr.nspu.riot.api.ServiceTest
import fr.nspu.riot.api.TestUtils
import fr.nspu.riot.api.models.Match
import fr.nspu.riot.api.models.MatchList
import fr.nspu.riot.api.models.MatchTimeline
import fr.nspu.riot.api.services.riot.MatchService
import okhttp3.mockwebserver.MockResponse
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mockito
import retrofit2.Retrofit
import java.io.IOException


class MatchServiceTest: ServiceTest() {
    var service: MatchService? = null
    override fun implementService(retrofit: Retrofit) {
        service= retrofit.create(MatchService::class.java)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetChallengerByQueueData() {
        val body = TestUtils.readTestData("match-by-id.json")
        val fixture = gson!!.fromJson(body, Match::class.java)

        val response = TestUtils.getResponseFromModel(fixture, Match::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.argThat(MatchesId(fixture.gameId!!.toString()))).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val challengers = service!!.getMatchById(fixture.gameId!!)!!.execute().body()
        this.compareJSONWithoutNulls(body, challengers)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetMatchListByAccountData() {
        val body = TestUtils.readTestData("match-list-by-account.json")
        val fixture = gson!!.fromJson(body, MatchList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, MatchList::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.argThat(MatchesId(211234522.toString()))).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val matchListByAccount = service!!.getMatchListByAccountId(211234522)!!.execute().body()
        this.compareJSONWithoutNulls(body, matchListByAccount)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetRecentMatchListByAccountData() {
        val body = TestUtils.readTestData("recent-match-list-by-account.json")
        val fixture = gson!!.fromJson(body, MatchList::class.java)

        val response = TestUtils.getResponseFromModel(fixture, MatchList::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.argThat(MatchesId(211234522.toString()))).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val matchListByAccount = service!!.getRecentMatchListByAccountId(211234522)!!.execute().body()
        this.compareJSONWithoutNulls(body, matchListByAccount)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetTimelineByMatchIdData() {
        val body = TestUtils.readTestData("timeline-by-match-id.json")
        val fixture = gson!!.fromJson(body, MatchTimeline::class.java)

        val response = TestUtils.getResponseFromModel(fixture, MatchTimeline::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.argThat(MatchesId(211234522.toString()))).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val matchListByAccount = service!!.getTimelineByMatchId(211234522)!!.execute().body()
        this.compareJSONWithoutNulls(body, matchListByAccount)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetTournamentByCodeData() {
        val body = TestUtils.readTestData("timeline-by-match-id.json")
        val fixture = gson!!.fromJson(body, MatchTimeline::class.java)

        val response = TestUtils.getResponseFromModel(fixture, MatchTimeline::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.argThat(MatchesId(211234522.toString()))).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val matchListByAccount = service!!.getTimelineByMatchId(211234522)!!.execute().body()
        this.compareJSONWithoutNulls(body, matchListByAccount)
    }
}