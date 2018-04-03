package fr.nspu.riot.api.Service

import fr.nspu.riot.api.ServiceTest
import fr.nspu.riot.api.TestUtils
import fr.nspu.riot.api.models.ShardStatus
import fr.nspu.riot.api.services.riot.LoLStatusService
import okhttp3.Call
import okhttp3.Request
import okhttp3.mockwebserver.MockResponse
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mockito
import retrofit2.Retrofit
import java.io.IOException


class LoLStatusServiceTest: ServiceTest(){
    var service: LoLStatusService? = null
    override fun implementService(retrofit: Retrofit) {
        service= retrofit.create(LoLStatusService::class.java)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetChallengerByQueueData() {
        val body = TestUtils.readTestData("lol-status.json")
        val fixture = gson!!.fromJson(body, ShardStatus::class.java)

        val response = TestUtils.getResponseFromModel(fixture, ShardStatus::class.java)
        Mockito.`when`(mockClient!!.newCall(Matchers.isA(Request::class.java)).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val challengers = service!!.getLoLStatus()!!.execute().body()
        this.compareJSONWithoutNulls(body, challengers)
    }
}