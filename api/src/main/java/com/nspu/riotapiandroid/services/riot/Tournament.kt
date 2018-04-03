package fr.nspu.riot.api.services.riot

import fr.nspu.riot.api.models.*
import retrofit2.Call
import retrofit2.http.*

/**
 * Tournament
 */
interface Tournament {
    /**
     * Create a tournament code for the given tournament
     *
     * @param tournamentCodeParameters Metadata for the generated code
     * @param count The number of codes to create (max 1000)
     * @param tournamentId The tournament ID
     * @return Requested list of code created for the tournament
     * @see <a href="https://developer.riotgames.com/api-methods/#tournament-v3/POST_createTournamentCode">Tournament code</a>
     */
    @POST(RiotUri.URI_TOURNAMENT_CODES)
    fun createCodes(@Body tournamentCodeParameters: TournamentCodeParameters, @Query("count") count : Int, @Query("tournamentId") tournamentId: Long): Call<List<String>>

    /**
     * Update the pick type, map, spectator type, or allowed summoners for a code
     *
     * @param tournamentCodeUpdateParameters The fields to update
     * @param tournamentId The tournament ID
     * @see <a href="https://developer.riotgames.com/api-methods/#tournament-v3/PUT_updateCode">Update tournament</a>
     */
    @PUT(RiotUri.URI_TOURNAMENT_UPDATE)
    fun updateCodes(@Body tournamentCodeUpdateParameters: TournamentCodeUpdateParameters, @Query("tournamentId") tournamentId: Long): Call<Unit>


    /**
     * Returns the tournament code DTO([TournamentCode]) associated with a tournament code string.
     *
     * @param tournamentCode The short code to look up lobby events for
     * @param options Optional parameters. Nullable
     * @return [Call] requested tournament info [TournamentCode]
     * @see <a href="https://developer.riotgames.com/api-methods/#tournament-v3/GET_getTournamentCode">Get tournament info</a>
     */
    @GET(RiotUri.URI_TOURNAMENT_RETURN_CODE)
    fun getTournamentInfoByTournamentId(@Path("tournamentCode") tournamentCode: String, @QueryMap options: Map<String, String>? = mapOf()): Call<TournamentCode>?


    /**
     * Gets a list of lobby events by tournament code
     *
     * @param tournamentCode The short code to look up lobby events for
     * @param options Optional parameters. Nullable
     * @return [Call] requested list of LobbyEvent
     * @see <a href="https://developer.riotgames.com/api-methods/#tournament-v3/GET_getLobbyEventsByCode">Gets a list of lobby</a>
     */
    @GET(RiotUri.URI_TOURNAMENT_STUB_LOBBY_EVENTS_BY_CODE)
    fun getListLobbyEventByTournamentCode(@Path("tournamentCode") tournamentCode: String, @QueryMap options: Map<String, String>? = mapOf()): Call<LobbyEvent>?

    /**
     * Creates a tournament provider and returns its ID
     * Implementation Notes : Providers will need to call this endpoint first to register their callback URL and their API key with the tournament system before any other tournament provider endpoints will work.
     *
     * @param providerRegistrationParameters The provider definition.
     * @return Requested id
     * @see <a href="https://developer.riotgames.com/api-methods/#tournament-v3/POST_registerProviderData">Register provider</a>
     */
    @POST(RiotUri.URI_TOURNAMENT_STUB_PROVIDERS)
    fun createProvider(@Body providerRegistrationParameters: ProviderRegistrationParameters): Call<Int>

    /**
     * Creates a tournament and returns its ID.
     *
     * @param tournamentRegistrationParameters The tournament definition.
     * @return Requested id
     * @see <a href="https://developer.riotgames.com/api-methods/#tournament-v3/POST_registerTournament">Creates a tournament</a>
     */
    @POST(RiotUri.URI_TOURNAMENT_STUB_PROVIDERS)
    fun createProvider(@Body tournamentRegistrationParameters : TournamentRegistrationParameters): Call<Int>
}