package fr.nspu.riot.api.services.datadragon

import fr.nspu.riot.api.models.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface DataDragonService {

    /**
     * Profile Icons:
     *   @param version version of the data dragon
     *   @param language language use for get the different informations
     */
    @GET(DataDragonUri.URI_PROFILE_ICON)
    fun getProfileIcon(@Path("version") version: String, @Path("language") language: String): Call<ProfileIconData>?

    /**
     * Champions
     */
    @GET(DataDragonUri.URI_CHAMPIONS)
    fun getChampions(@Path("version") version: String, @Path("language") language: String): Call<ChampionListData>?

    /**
     * Champion
     */
    @GET(DataDragonUri.URI_CHAMPION)
    fun getChampion(@Path("version") version: String, @Path("language") language: String, @Path("championName") championName: String): Call<ChampionListData>?


    /**
     * Items
     */
    @GET(DataDragonUri.URI_ITEMS)
    fun getItems(@Path("version") version: String, @Path("language") language: String): Call<ItemList>?

    /**
     * Masteries
     */
    @GET(DataDragonUri.URI_MASTERIES)
    fun getMasteries(@Path("version") version: String, @Path("language") language: String): Call<MasteryList>?


    /**
     * Runes
     */
    @GET(DataDragonUri.URI_RUNES)
    fun getRunes(@Path("version") version: String, @Path("language") language: String): Call<RuneList>?


    /**
     * Summoner Spells
     */
    @GET(DataDragonUri.URI_SUMMONER_SPELLS)
    fun getSummonerSpells(@Path("version") version: String, @Path("language") language: String): Call<SummonerSpellList>?

    /**
     * Version
     */
    @GET(DataDragonUri.URI_VERSIONS)
    fun getVersions(): Call<List<String>>?

    /**
     * Language
     */
    @GET(DataDragonUri.URI_LANGUAGES)
    fun getLanguages(): Call<List<String>>?

    /**
     * Language Strings
     */
    @GET(DataDragonUri.URI_LANGUAGE_STRINGS)
    fun getLanguageString(): Call<LanguageStrings>

}