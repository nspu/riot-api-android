package com.nspu.riotapi.services.riot

import com.nspu.riotapi.models.Match
import com.nspu.riotapi.models.MatchList
import com.nspu.riotapi.models.MatchTimeline
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

/**
 * match
 */
interface MatchService {
    /**
     * Get match by match ID.
     *
     * @param matchId id of the match
     * @param options Optional parameters. Nullable
     * @return [Call] requested the match
     * @see <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatch">Get the match</a>
     */
    @GET(RiotUri.URI_MATCH_BY_ID)
    fun getMatchById(@Path("matchId") matchId: Long, @QueryMap options: Map<String, String>? = mapOf()): Call<Match>?

    /**
     * Get matchlist for games played on given account ID and platform ID and filtered using given filter parameters, if any.
     *
     * @param accountId id of the account
     * @param options Optional parameters. Nullable
     * @return [Call] requested list of match
     * @see <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Get list of match</a>
     */
    @GET(RiotUri.URI_MATCH_LIST_BY_ACCOUNT)
    fun getMatchListByAccountId(@Path("accountId") accountId: Long, @QueryMap options: Map<String, String>? = mapOf()): Call<MatchList>?

    /**
     * Get matchlist for last 20 matches played on given account ID and platform ID.
     *
     * @param accountId id of the account
     * @param options Optional parameters. Nullable
     * @return [Call] requested list of last match
     * @see <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getRecentMatchlist">Get list last match</a>
     */
    @GET(RiotUri.URI_MATCH_LIST_BY_ACCOUNT_RECENT)
    fun getRecentMatchListByAccountId(@Path("accountId") accountId: Long, @QueryMap options: Map<String, String>? = mapOf()): Call<MatchList>?

    /**
     * Get match timeline by match ID.
     *
     * @param matchId id of the match
     * @param options Optional parameters. Nullable
     * @return [Call] requested match timeline
     * @see <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchTimeline">Get match timeline</a>
     */
    @GET(RiotUri.URI_MATCH_TIMELINE_BY_ID)
    fun getTimelineByMatchId(@Path("matchId") matchId: Long, @QueryMap options: Map<String, String>? = mapOf()): Call<MatchTimeline>?

    /**
     * Get match IDs by tournament code
     * TODO not testing (need tournament code)
     *
     * @param tournamentCode tournament code
     * @param options Optional parameters. Nullable
     * @return [Call] requested match ids
     * @see <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchTimeline">Get match ids</a>
     */
    @GET(RiotUri.URI_IDS_MATCH_LIST_BY_TOURNAMENT)
    fun getIdsMatchListByTounrament(@Path("tournamentCode") tournamentCode: Long, @QueryMap options: Map<String, String>? = mapOf()): Call<List<Long>>?

    /**
     * Get match by match ID and tournament code.
     * TODO not testing (need tournament code)
     *
     * @param matchId id of the match
     * @param options Optional parameters. Nullable
     * @return [Call] requested match
     * @see <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchByTournamentCode">Get match</a>
     */
    @GET(RiotUri.URI_MATCH_BY_ID_BY_TOUNRAMENT)
    fun getMatchByMatchIdAndByTounrament(@Path("matchId") matchId: Long, @Path("tournamentCode") tournamentCode: Long, @QueryMap options: Map<String, String>? = mapOf()): Call<Match>?
}