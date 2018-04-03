package com.nspu.riotapi.services.riot

import com.nspu.riotapi.models.ChampionMastery
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

/**
 * Champion Mastery
 */
interface ChampionMasteryService {
    /**
     * Get all champion mastery entries sorted by number of champion points descending
     *
     * @param summonerId id of the summoner
     * @param options Optional parameters. Nullable
     * @return [Call] requested all champion mastery entries
     * @see <a href="https://developer.riotgames.com/api-methods/#champion-mastery-v3/GET_getAllChampionMasteries">Get all champion mastery entries</a>
     */
    @GET(RiotUri.URI_CHAMPION_MASTERIES_BY_SUMMONER)
    fun getChampionMasteriesBySummoner(@Path("summonerId") summonerId: Long, @QueryMap options: Map<String, String>? = mapOf()): Call<List<ChampionMastery>>?

    /**
     * Get a champion mastery by player ID and champion ID
     *
     * @param summonerId id of the summoner
     * @param championId id of champion
     * @param options Optional parameters. Nullable
     * @return [Call] requested champion mastery entries
     * @see <a href="https://developer.riotgames.com/api-methods/#champion-mastery-v3/GET_getChampionMastery">Get champion mastery entries</a>
     */
    @GET(RiotUri.URI_CHAMPION_MASTERIES_BY_SUMMONER_BY_CHAMPION)
    fun getChampionMasteriesBySummonerByChampion(@Path("summonerId") summonerId: Long, @Path("championId") championId: Long, @QueryMap options: Map<String, String>? = mapOf()): Call<ChampionMastery>?

    /**
     * Get a player's total champion mastery score, which is the sum of individual champion mastery levels
     *
     * @param summonerId id of the summoner
     * @param options Optional parameters. Nullable
     * @return [Call] requested total champion mastery score
     * @see <a href="https://developer.riotgames.com/api-methods/#champion-mastery-v3/GET_getChampionMasteryScore">Get total champion mastery score</a>
     */
    @GET(RiotUri.URI_CHAMPION_MASTERY_SCORES_BY_SUMMONER)
    fun getScoresBySummoner(@Path("summonerId") summonerId: Long, @QueryMap options: Map<String, String>? = mapOf()): Call<Int>?
}