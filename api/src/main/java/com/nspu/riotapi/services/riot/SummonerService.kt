package com.nspu.riotapi.services.riot

import com.nspu.riotapi.models.Summoner
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

/**
 * summoner
 */
interface SummonerService {
    /**
     * Get a summoner by account ID
     *
     * @param accountId id of the account
     * @param options Optional parameters. Nullable
     * @return [Call] requested summoner
     * @see <a href="https://developer.riotgames.com/api-methods/#summoner-v3/GET_getByAccountId">Get a summoner by account ID</a>
     */
    @GET(RiotUri.URI_SUMMOMER_BY_ACCOUNT_ID)
    fun getSummonerByAccountId(@Path("accountId") accountId: Long, @QueryMap options: Map<String, String>? = mapOf()): Call<Summoner>?

    /**
     * Get a summoner by summoner name
     *
     * @param summonerName name of the summoner
     * @param options Optional parameters. Nullable
     * @return [Call] requested summoner
     * @see <a href="https://developer.riotgames.com/api-methods/#summoner-v3/GET_getBySummonerName">Get a summoner by summoner name</a>
     */
    @GET(RiotUri.URI_SUMMONER_BY_NAME)
    fun getSummonerByName(@Path("summonerName") summonerName: String, @QueryMap options: Map<String, String>? = mapOf()): Call<Summoner>?

    /**
     * Get a summoner by summoner ID.
     *
     * @param summonerId id of the summoner
     * @param options Optional parameters. Nullable
     * @return [Call] requested summoner
     * @see <a href="https://developer.riotgames.com/api-methods/#summoner-v3/GET_getBySummonerId">Get a summoner by summoner ID</a>
     */
    @GET(RiotUri.URI_SUMMONER_BY_SUMMONER_ID)
    fun getSummonerBySummonerId(@Path("summonerId") summonerId: Long, @QueryMap options: Map<String, String>? = mapOf()): Call<Summoner>?

}