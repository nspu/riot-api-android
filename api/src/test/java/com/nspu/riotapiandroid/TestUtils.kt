package fr.nspu.riot.api

import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okio.BufferedSource
import org.robolectric.Robolectric
import java.io.*
import java.lang.reflect.Type
import java.nio.CharBuffer
import java.nio.charset.Charset

object TestUtils {
    private val TEST_DATA_DIR = "/fixtures/"
    private val MAX_TEST_DATA_FILE_SIZE = 4131072
    private val gson = Gson()

    private class ResponseBody internal constructor(private val mJson: String): okhttp3.ResponseBody() {
        override fun contentLength(): Long {
            return mJson.length.toLong()        }

        override fun contentType(): MediaType? {
            return MediaType.parse("application/json")
        }

        override fun source(): BufferedSource {
            return ByteArrayInputStream(mJson.toByteArray(Charset.forName("UTF-8"))) as BufferedSource
        }
    }

    fun <T> getResponseFromModel(statusCode: Int, model: T, modelClass: Class<T>): Response {
        val responseBody = ResponseBody(gson.toJson(model, modelClass))
        return createResponse(statusCode, responseBody)
    }

    fun <T> getResponseFromModel(model: T, modelClass: Class<T>): Response {
        val responseBody = ResponseBody(gson.toJson(model, modelClass))
        return createResponse(200, responseBody)
    }

    fun <T> getResponseFromModel(model: T, modelType: Type): Response {
        val responseBody = ResponseBody(gson.toJson(model, modelType))
        return createResponse(200, responseBody)
    }

    private fun createResponse(statusCode: Int, responseBody: ResponseBody): Response {
        var request = Request.Builder().url("http://riot.com").tag("").build()
        return Response.Builder()
                .body(responseBody)
                .code(statusCode)
                .protocol(Protocol.HTTP_1_0)
                .message("")
                .request(request)
                .build()
    }

    fun readTestData(fileName: String): String {
        try {
            val path = Robolectric::class.java.getResource(TEST_DATA_DIR + fileName).toURI().path
            return readFromFile(File(path))
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }

    @Throws(IOException::class)
    private fun readFromFile(file: File): String {
        val reader = FileReader(file)
        val charBuffer = CharBuffer.allocate(MAX_TEST_DATA_FILE_SIZE)
        reader.read(charBuffer)
        charBuffer.position(0)
        return charBuffer.toString().trim { it <= ' ' }
    }
}
