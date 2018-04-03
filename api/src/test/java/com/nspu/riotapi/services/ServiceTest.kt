package com.nspu.riotapi

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert
import org.junit.Before
import org.mockito.ArgumentMatcher
import org.mockito.Mockito
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.UnsupportedEncodingException
import java.net.URLEncoder

abstract class ServiceTest {

    protected var mockClient: OkHttpClient? = null
    protected var gson: Gson? = null
    var mockWebServer: MockWebServer?=null

    protected inner class MatchesId internal constructor(private val mId: String) : ArgumentMatcher<Request>() {

        override fun matches(request: Any?): Boolean {
            try {
                return (request as Request).url().encodedPath().contains(URLEncoder.encode(mId.toString(), "UTF-8"))
            } catch (e: UnsupportedEncodingException) {
                return false
            }

        }
    }

    @Before
    fun setUp() {
        mockClient = Mockito.mock(OkHttpClient::class.java, Mockito.RETURNS_DEEP_STUBS)
        mockWebServer = MockWebServer()
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(mockWebServer!!.url("").toString())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
        implementService(retrofit)
        gson = GsonBuilder().create()
    }

    abstract fun implementService(retrofit: Retrofit)

    /**
     * Compares the mapping fixture <-> object, ignoring NULL fields
     * This is useful to prevent issues with entities such as "Image" in
     * which width and height are not always present, and they result in
     * null values in the Image object
     *
     * @param fixture The JSON to test against
     * @param model   The object to be serialized
     */
    protected fun <T> compareJSONWithoutNulls(fixture: String, model: T?) {
        val parser = JsonParser()

        // Parsing fixture twice gets rid of nulls
        var fixtureJsonElement = parser.parse(fixture)
        val fixtureWithoutNulls = gson!!.toJson(fixtureJsonElement)
        fixtureJsonElement = parser.parse(fixtureWithoutNulls)

        val modelJsonElement = gson!!.toJsonTree(model)

        // We compare JsonElements from fixture
        // with the one created from model. If they're different
        // it means the model is wrong
        Assert.assertEquals(fixtureJsonElement, modelJsonElement)
    }

    /**
     * Compares two JSON strings if they contain the same data even if the order
     * of the keys differs.
     *
     * @param expected The JSON to test against
     * @param actual   The tested JSON
     * @return true if JSONs contain the same data, false otherwise.
     */
    protected fun JSONsContainSameData(expected: String, actual: String): Boolean {
        val parser = JsonParser()
        val expectedJsonElement = parser.parse(expected)
        val actualJsonElement = parser.parse(actual)

        return expectedJsonElement == actualJsonElement
    }
}