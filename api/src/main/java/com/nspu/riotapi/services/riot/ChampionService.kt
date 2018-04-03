package com.nspu.riotapi.services.riot

import com.nspu.riotapi.models.ChampionInfo
import com.nspu.riotapi.models.ChampionListInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

/**
 * champion
 */
interface ChampionService {
    /**
     * Retrieve all champions.
     *
     * @param options Optional parameters. Nullable
     * @return [Call] requested all champion
     * @see <a href="https://developer.riotgames.com/api-methods/#champion-v3/GET_getChampions">Retrieve all champions</a>
     */
    @GET(RiotUri.URI_CHAMPIONS)
    fun getChampions(@QueryMap options: Map<String, String>? = mapOf()): Call<ChampionListInfo>?

    /**
     * Retrieve champion by ID.
     *
     * @param options Optional parameters. Nullable
     * @return [Call] requested all champion
     * @see <a href="https://developer.riotgames.com/api-methods/#champion-v3/GET_getChampionsById">Retrieve champion by ID</a>
     */
    @GET(RiotUri.URI_CHAMPION)
    fun getChampion(@Path("id") id: Long, @QueryMap options: Map<String, String>? = mapOf()): Call<ChampionInfo>?
}