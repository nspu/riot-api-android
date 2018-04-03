package com.nspu.riotapi.services.datadragon

import com.nspu.riotapi.models.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface DataDragonService {

    /**
     * Get profil icon
     *
     * @param version version of the data dragon
     * @param language language use for get the different informations
     * @return [Call] requested profil icon
     */
    @GET(DataDragonUri.URI_PROFILE_ICON)
    fun getProfileIcon(@Path("version") version: String, @Path("language") language: String): Call<ProfileIconData>?

    /**
     * Get champions
     *
     * @param version version of the data dragon
     * @param language language use for get the different informations
     * @return [Call] requested champion list
     */
    @GET(DataDragonUri.URI_CHAMPIONS)
    fun getChampions(@Path("version") version: String, @Path("language") language: String): Call<ChampionListData>?

    /**
     * Get champion
     *
     * @param version version of the data dragon
     * @param language language use for get the different informations
     * @param championName name of the champion
     * @return [Call] requested champion
     */
    @GET(DataDragonUri.URI_CHAMPION)
    fun getChampion(@Path("version") version: String, @Path("language") language: String, @Path("championName") championName: String): Call<ChampionListData>?


    /**
     * Get items
     *
     * @param version version of the data dragon
     * @param language language use for get the different informations
     * @return [Call] requested item list
     */
    @GET(DataDragonUri.URI_ITEMS)
    fun getItems(@Path("version") version: String, @Path("language") language: String): Call<ItemList>?

    /**
     * Get masteries
     *
     * @param version version of the data dragon
     * @param language language use for get the different informations
     * @return [Call] requested masteries
     */
    @GET(DataDragonUri.URI_MASTERIES)
    fun getMasteries(@Path("version") version: String, @Path("language") language: String): Call<MasteryList>?


    /**
     * Get runes
     *
     * @param version version of the data dragon
     * @param language language use for get the different informations
     * @return [Call] requested runes
     */
    @GET(DataDragonUri.URI_RUNES)
    fun getRunes(@Path("version") version: String, @Path("language") language: String): Call<RuneList>?


    /**
     * Get summoner spells
     *
     * @param version version of the data dragon
     * @param language language use for get the different informations
     * @return [Call] requested summoner spells
     */
    @GET(DataDragonUri.URI_SUMMONER_SPELLS)
    fun getSummonerSpells(@Path("version") version: String, @Path("language") language: String): Call<SummonerSpellList>?

    /**
     * Get version
     *
     * @return [Call] requested version
     */
    @GET(DataDragonUri.URI_VERSIONS)
    fun getVersions(): Call<List<String>>?

    /**
     * Get language
     *
     * @return [Call] requested language
     */
    @GET(DataDragonUri.URI_LANGUAGES)
    fun getLanguages(): Call<List<String>>?

    /**
     * Get language strings
     *
     * @return [Call] requested language strings
     */
    @GET(DataDragonUri.URI_LANGUAGE_STRINGS)
    fun getLanguageString(): Call<LanguageStrings>

}