package com.nspu.riotapi.services.riot

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

/**
 * third party code
 */
interface ThirdPartyCodeService {
    /**
     * Get third party code for a given summoner ID
     *
     * @param summonerId id of the summoner
     * @param options Optional parameters. Nullable
     * @return [Call] requested third party code
     * @see <a href="https://developer.riotgames.com/api-methods/#third-party-code-v3/GET_getThirdPartyCodeBySummonerId">Get third party code for a given summoner ID</a>
     */
    @GET(RiotUri.URI_THIRD_PARTY_CODE_BY_SUMMONER_ID)
    fun getThirdPartyCodeBySummonerId(@Path("summonerId") summonerId: Long, @QueryMap options: Map<String, String>? = mapOf()): Call<String>?
}