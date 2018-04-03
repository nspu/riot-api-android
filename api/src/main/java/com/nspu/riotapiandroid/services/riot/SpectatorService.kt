package fr.nspu.riot.api.services.riot

import fr.nspu.riot.api.models.SpectatorFeaturedGames
import fr.nspu.riot.api.models.SpectatorGameInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

/**
 * spectator
 */
interface SpectatorService {
    /**
     * Get current game information for the given summoner ID.
     *
     * @param summonerId id of the summoner
     * @param options Optional parameters. Nullable
     * @return [Call] requested the current game
     * @see <a href="https://developer.riotgames.com/api-methods/#spectator-v3/GET_getCurrentGameInfoBySummoner">Get the current game</a>
     */
    @GET(RiotUri.URI_SPECTATOR_ACTIVE_GAMES_BY_SUMMONER_ID)
    fun getActiveGameBySummonerId(@Path("summonerId") summonerId: Long, @QueryMap options: Map<String, String>? = mapOf()): Call<SpectatorGameInfo>?

    /**
     * Get list of featured games
     *
     * @param options Optional parameters. Nullable
     * @return [Call] requested list of featured games
     * @see <a href="https://developer.riotgames.com/api-methods/#spectator-v3/GET_getCurrentGameInfoBySummoner">Get list of featured games</a>
     */
    @GET(RiotUri.URI_SPECTATOR_FEATURED_GAME)
    fun getFeaturedGame(@QueryMap options: Map<String, String>? = mapOf()): Call<SpectatorFeaturedGames>?

}