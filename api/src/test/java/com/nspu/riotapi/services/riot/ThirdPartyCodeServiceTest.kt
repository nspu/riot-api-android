package com.nspu.riotapi.Service

import com.nspu.riotapi.ServiceTest
import com.nspu.riotapi.TestUtils
import com.nspu.riotapi.services.riot.ThirdPartyCodeService
import okhttp3.mockwebserver.MockResponse
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mockito.`when`
import retrofit2.Retrofit
import java.io.IOException


class ThirdPartyCodeServiceTest: ServiceTest() {
    var service: ThirdPartyCodeService? = null

    override fun implementService(retrofit: Retrofit) {
        service  = retrofit.create(ThirdPartyCodeService::class.java)
    }

    @Test
    @Throws(IOException::class)
    fun shouldGetSummonerByAccountIdData() {
        val body = TestUtils.readTestData("third-party-code.json")
        val fixture = gson!!.fromJson(body, String::class.java)

        val response = TestUtils.getResponseFromModel(fixture, String::class.java)
        `when`(mockClient!!.newCall(Matchers.argThat(MatchesId(48509080.toString()))).execute()).thenReturn(response)

        mockWebServer!!.enqueue(MockResponse().setBody(body).setResponseCode(200))
        val thirdPartyCode = service!!.getThirdPartyCodeBySummonerId(48509080)!!.execute().body()
        this.compareJSONWithoutNulls(body, thirdPartyCode)
    }
}