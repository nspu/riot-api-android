package fr.nspu.riot.api.services.riot

import fr.nspu.riot.api.models.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

/**
 * lol-static-data
 */
interface StaticDataService {
    /**
     * Retrieves champion list
     *
     * @param options Optional parameters. Nullable
     * @return [Call] requested champion list
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionList">Retrieve champion list</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_CHAMPIONS)
    fun getChampions(@QueryMap options: Map<String, String>? = mapOf()): Call<ChampionListData>?

    /**
     * Retrieves champion by ID
     *
     * @param championId id of the champion
     * @param options Optional parameters. Nullable
     * @return [Call] requested champion
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionById">Retrieve champion</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_CHAMPION)
    fun getChampion(@Path("id") championId: Int, @QueryMap options: Map<String, String>? = mapOf()): Call<ChampionData>?

    /**
     * Retrieves item list
     *
     * @param options Optional parameters. Nullable
     * @return [Call] requested item list
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getItemList">Retrieve item list</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_ITEMS)
    fun getItems(@QueryMap options: Map<String, String>? = mapOf()): Call<ItemList>?

    /**
     * Retrieves item by ID
     *
     * @param itemId id of the item
     * @param options Optional parameters. Nullable
     * @return [Call] requested item
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getItemById">Retrieve item</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_ITEM)
    fun getItem(@Path("id") itemId: Int, @QueryMap options: Map<String, String>? = mapOf()): Call<Item>?

    /**
     * Retrieve language strings data
     *
     * @param callback Callback method. Success callback will return language strings
     * @param options Optional parameters. Nullable
     * @return [Call] requested language strings
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getLanguageStrings">Retrieve language strings</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_LANGUAGE_STRING)
    fun getLanguageString(@QueryMap options: Map<String, String>? = mapOf()): Call<LanguageStrings>?

    /**
     * Retrieve supported languages data
     *
     * @param options Optional parameters. Nullable
     * @return [Call] requested supported languages data
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getLanguageStrings">Retrieve supported languages data</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_LANGUAGES)
    fun getLanguages(@QueryMap options: Map<String, String>? = mapOf()): Call<List<String>>?

    /**
     * Retrieve map data
     *
     * @param options Optional parameters. Nullable
     * @return [Call] requested supported map data
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMapData">Retrieve map data</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_MAPS)
    fun getMaps(@QueryMap options: Map<String, String>? = mapOf()): Call<Maps>?

    /**
     * Retrieves mastery list
     *
     * @param options Optional parameters. Nullable
     * @return [Call] requested mastery list
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMasteryList">Retrieve mastery list</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_MASTERIES)
    fun getMasteries(@QueryMap options: Map<String, String>? = mapOf()): Call<MasteryList>?

    /**
     * Retrieves mastery item by ID
     *
     * @param masteryId id of the mastery
     * @param options Optional parameters. Nullable
     * @return [Call] requested mastery item
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMasteryById">Retrieves mastery item</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_MASTERY)
    fun getMastery(@Path("id") masteryId: Int, @QueryMap options: Map<String, String>? = mapOf()): Call<Mastery>?

    /**
     * Retrieve profile icons
     *
     * @param options Optional parameters. Nullable
     * @return [Call] requested profile icons
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getProfileIcons">Retrieve profile icons</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_PROFILE_ICONS)
    fun getProfileIcons(@QueryMap options: Map<String, String>? = mapOf()): Call<ProfileIconData>?

    /**
     * Retrieve realm data
     *
     * @param options Optional parameters. Nullable
     * @return [Call] requested realm data
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRealm">Retrieve realm data</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_REALMS)
    fun getRealms(@QueryMap options: Map<String, String>? = mapOf()): Call<Realm>?

    /**
     * Retrieves reforged rune path list
     *
     * @param options Optional parameters. Nullable
     * @return [Call] requested reforged rune path list
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getReforgedRunePaths">Retrieves reforged rune path list</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNE_PATHS)
    fun getReforgedRunePaths(@QueryMap options: Map<String, String>? = mapOf()): Call<List<ReforgedRunePath>>?

    /**
     * Retrieves reforged rune path by ID
     *
     * @param reforgedRunePathId id of the reforged rune path
     * @param options Optional parameters. Nullable
     * @return [Call] requested reforged rune path
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getReforgedRunePathById">Retrieves reforged rune path</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNE_PATH)
    fun getReforgedRunePath(@Path("id") reforgedRunePathId: Int, @QueryMap options: Map<String, String>? = mapOf()): Call<ReforgedRunePath>?

    /**
     * Retrieves reforged rune list
     *
     * @param options Optional parameters. Nullable
     * @return [Call] requested reforged rune list
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getReforgedRunes">Retrieves reforged rune list</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNES)
    fun getReforgedRunes(@QueryMap options: Map<String, String>? = mapOf()): Call<List<ReforgedRune>>?

    /**
     * Retrieves reforged rune by ID
     *
     * @param reforgedRuneId id of the reforged rune
     * @param options Optional parameters. Nullable
     * @return [Call] requested reforged rune
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getReforgedRuneById">Retrieves reforged rune by ID</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_REFORGED_RUNE)
    fun getReforgedRune(@Path("id") reforgedRuneId: Int, @QueryMap options: Map<String, String>? = mapOf()): Call<ReforgedRune>?

    /**
     * Retrieves rune list
     *
     * @param options Optional parameters. Nullable
     * @return [Call] requested rune list
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRuneList">Retrieves rune list</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_RUNES)
    fun getRunes(@QueryMap options: Map<String, String>? = mapOf()): Call<RuneList>?

    /**
     * Retrieves rune by ID
     *
     * @param runeId id of the rune
     * @param callback Callback method. Success callback will return rune
     * @param options Optional parameters. Nullable
     * @return [Call] requested rune
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRuneById">Retrieves rune by ID</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_RUNE)
    fun getRune(@Path("id") runeId: Int, @QueryMap options: Map<String, String>? = mapOf()): Call<Rune>?

    /**
     * Retrieves summoner spell list
     *
     * @param options Optional parameters. Nullable
     * @return [Call] requested summoner spell list
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getSummonerSpellList">Retrieves summoner spell list</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_SUMMONER_SPELLS)
    fun getSummonerSpells(@QueryMap options: Map<String, String>? = mapOf()): Call<SummonerSpellList>?

    /**
     * Retrieves summoner spell by ID
     *
     * @param summonerSpellId id of the summoner spell
     * @param options Optional parameters. Nullable
     * @return [Call] requested summoner spell
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getSummonerSpellById">Retrieves summoner spell by ID</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_SUMMONER_SPELL)
    fun getSummonerSpell(@Path("id") summonerSpellId: Int, @QueryMap options: Map<String, String>? = mapOf()): Call<SummonerSpell>?

    /**
     * Retrieves full tarball link
     *
     * @param options Optional parameters. Nullable
     * @return [Call] requested full tarball link
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getFullTarballLink">Retrieves full tarball link</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_TARBALL_LINKS)
    fun getTarballLinks(@QueryMap options: Map<String, String>? = mapOf()): Call<String>?

    /**
     * Retrieve version data
     *
     * @param options Optional parameters. Nullable
     * @return [Call] requested version data
     * @see <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getVersions">Retrieve version data</a>
     */
    @GET(RiotUri.URI_STATIC_DATA_VERSIONS)
    fun getVersions(@QueryMap options: Map<String, String>? = mapOf()): Call<List<String>>?

}