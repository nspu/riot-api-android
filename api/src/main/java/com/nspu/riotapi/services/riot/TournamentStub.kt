package com.nspu.riotapi.services.riot

import com.nspu.riotapi.models.LobbyEvent
import com.nspu.riotapi.models.ProviderRegistrationParameters
import com.nspu.riotapi.models.TournamentCodeParameters
import com.nspu.riotapi.models.TournamentRegistrationParameters
import retrofit2.Call
import retrofit2.http.*


/**
 * Tournament Stub
 */
interface TournamentStub {
    /**
     * Create a tournament code for a given tournament
     *
     * @param tournamentCodeParameters Metadata for the generated code
     * @param count The number of codes to create (max 1000)
     * @param tournamentId The tournament ID
     * @return Requested list of code created for the tournament
     * @see <a https://developer.riotgames.com/api-methods/#tournament-stub-v3/POST_createTournamentCode">Tournament code</a>
     */
    @POST(RiotUri.URI_TOURNAMENT_STUB_CODES)
    fun createCodes(@Body tournamentCodeParameters: TournamentCodeParameters, @Query("count") count: Int, @Query("tournamentId") tournamentId: Long): Call<List<String>>

    /**
     * Gets a mock list of lobby events by tournament code
     *
     * @param tournamentCode The short code to look up lobby events for
     * @param options Optional parameters. Nullable
     * @return [Call] requested list of LobbyEvent
     * @see <a href="https://developer.riotgames.com/api-methods/#tournament-stub-v3/GET_getLobbyEventsByCode">Gets a mock list of lobby</a>
     */
    @GET(RiotUri.URI_TOURNAMENT_STUB_LOBBY_EVENTS_BY_CODE)
    fun getListLobbyEventByTournamentCode(@Path("tournamentCode") tournamentCode: String, @QueryMap options: Map<String, String>? = mapOf()): Call<LobbyEvent>?

    /**
     * Creates a mock tournament provider and returns its ID
     * Implementation Notes : Providers will need to call this endpoint first to register their callback URL and their API key with the tournament system before any other tournament provider endpoints will work.
     *
     * @param providerRegistrationParameters The provider definition.
     * @return Requested id
     * @see <a href="https://developer.riotgames.com/api-methods/#tournament-stub-v3/POST_registerProviderData">Register provider</a>
     */
    @POST(RiotUri.URI_TOURNAMENT_STUB_PROVIDERS)
    fun createProvider(@Body providerRegistrationParameters: ProviderRegistrationParameters): Call<Int>

    /**
     * Creates a mock tournament and returns its ID.
     *
     * @param tournamentRegistrationParameters The tournament definition.
     * @return Requested id
     * @see <a href="https://developer.riotgames.com/api-methods/#tournament-stub-v3/POST_registerProviderData">Creates a mock tournament</a>
     */
    @POST(RiotUri.URI_TOURNAMENT_STUB_TOURNAMENTS)
    fun createProvider(@Body tournamentRegistrationParameters: TournamentRegistrationParameters): Call<Int>

}