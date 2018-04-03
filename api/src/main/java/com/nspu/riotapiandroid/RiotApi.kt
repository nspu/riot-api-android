package fr.nspu.riot.api

import fr.nspu.riot.api.services.riot.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Creates and configures a REST adapter for Riot API.
 *
 * Basic usage:
 * RiotApi riotApi = new RiotApi(endPoint, accessToken);
 *
 * Create instance of RiotApi with given executors.
 * @property callbackExecutor executor for callbacks. If null is passed than the same
 * @property endPoint url for the riot endpoint
 * @property accessToken settings access token
 *
 * @property staticDataService instance for access to static data
 * @property championMasteryService: instance for access to champion mastery
 * @property championService : instance for access to champions
 * @property leagueService: instance for access to league
 * @property lolStatusService : instance for access to lol status
 * @property matchService: instance for access to match
 * @property spectatorService: instance for access to spectator
 * @property summonerService: instance for access to summoner
 * @property thirdPartyCodeService: instance for access to third party code
 * @constructor thread that created the instances.
 */
class RiotApi(
    callbackExecutor: Executor,
    var endPoint: String,
    private var accessToken: String
) {

    val staticDataService: StaticDataService
    val championMasteryService: ChampionMasteryService
    val championService: ChampionService
    val leagueService: LeagueService
    val lolStatusService: LoLStatusService
    val matchService: MatchService
    val spectatorService: SpectatorService
    val summonerService: SummonerService
    val thirdPartyCodeService: ThirdPartyCodeService
    val tournamentStub: TournamentStub

    init {
        val okhttpClient = OkHttpClient.Builder().addInterceptor(AddHeaderTokenInterceptor())
        val restAdapterBuilder = Retrofit.Builder()
            .baseUrl(endPoint)
            .callbackExecutor(callbackExecutor)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(okhttpClient.build())

        val restAdapter = restAdapterBuilder.build()

        staticDataService = restAdapter.create(StaticDataService::class.java)
        championMasteryService = restAdapter.create(ChampionMasteryService::class.java)
        championService = restAdapter.create(ChampionService::class.java)
        leagueService = restAdapter.create(LeagueService::class.java)
        lolStatusService = restAdapter.create(LoLStatusService::class.java)
        matchService = restAdapter.create(MatchService::class.java)
        spectatorService = restAdapter.create(SpectatorService::class.java)
        summonerService = restAdapter.create(SummonerService::class.java)
        thirdPartyCodeService = restAdapter.create(ThirdPartyCodeService::class.java)
        tournamentStub = restAdapter.create(TournamentStub::class.java)
    }

    /**
     *  New instance of RiotApi,
     *  with single thread executor both for http and callbacks.
     *   @param endPoint url for the riot endpoint
     *   @param accessToken settings access token
     */
    constructor(endPoint: String, accessToken: String) : this(
        Executors.newSingleThreadExecutor(),
        endPoint,
        accessToken
    )

    /**
     * The request interceptor that will add the header with OAuth
     * token to every request made with the wrapper.
     */
    inner class AddHeaderTokenInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val builder = chain.request().newBuilder()
            builder.addHeader("X-Riot-Token", accessToken)
            return chain.proceed(builder.build())
        }
    }

}
