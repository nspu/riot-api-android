package com.nspu.riotapi.services.riot

import com.nspu.riotapi.RankedType
import com.nspu.riotapi.models.LeagueList
import com.nspu.riotapi.models.LeaguePosition
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

/**
 * league
 */
interface LeagueService {
    /**
     * Get the challenger league for given queue.
     *
     * @param queue type of the queue [RankedType]
     * @param options Optional parameters. Nullable
     * @return [Call] requested challenger league
     * @see <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getChallengerLeague">Get the challenger league</a>
     */
    @GET(RiotUri.URI_LEAGUE_CHALLENGER_BY_QUEUE)
    fun getChallengersByQueue(@Path("queue") queue: RankedType, @QueryMap options: Map<String, String>? = mapOf()): Call<LeagueList>?

    /**
     * Get league with given ID, including inactive entries.
     *
     * @param leagueId id of the league
     * @param options Optional parameters. Nullable
     * @return [Call] requested the league
     * @see <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getLeagueById">Get the league</a>
     */
    @GET(RiotUri.URI_LEAGUE_BY_ID)
    fun getLeagueById(@Path("leagueId") leagueId: String, @QueryMap options: Map<String, String>? = mapOf()): Call<LeagueList>?

    /**
     * Get the master league for given queue.
     *
     * @param queue type of the queue [RankedType]
     * @param options Optional parameters. Nullable
     * @return [Call] requested the master league
     * @see <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getMasterLeague">Get the master league</a>
     */
    @GET(RiotUri.URI_LEAGUE_MASTER_BY_QUEUE)
    fun getLeagueMasterByQueue(@Path("queue") queue: RankedType, @QueryMap options: Map<String, String>? = mapOf()): Call<LeagueList>?

    /**
     * Get league positions in all queues for a given summoner ID.
     *
     * @param summonerId id of the summoner
     * @param options Optional parameters. Nullable
     * @return [Call] requested league positions
     * @see <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getAllLeaguePositionsForSummoner">Get league positions</a>
     */
    @GET(RiotUri.URI_LEAGUE_POSITION_BY_SUMMONER)
    fun getPositionBySummoner(@Path("summonerId") summonerId: Long, @QueryMap options: Map<String, String>? = mapOf()): Call<Set<LeaguePosition>>?
}