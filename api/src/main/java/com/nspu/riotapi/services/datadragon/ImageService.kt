package com.nspu.riotapi.services.datadragon

import android.graphics.Bitmap
import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator

class ImageService(var uri: String) {

    private fun getProfileIconUri(profileIconId: Int, version: String) = "$uri/cdn/$version/img/profileicon/$profileIconId.png"
    private fun getSplashArtUri(nameChampion: String, skinNum: Int) = "$uri/cdn/img/champion/splash/${nameChampion}_$skinNum.jpg"
    private fun getLoadingScreenArtUri(nameChampion: String, skinNum: Int) = "$uri/cdn/img/champion/loading/${nameChampion}_$skinNum.jpg"
    private fun getChampionSquareUri(nameChampion: String, version: String) = "$uri/cdn/$version/img/champion/$nameChampion.png"
    private fun getPassiveAbilityUri(nameImage: String, version: String) = "$uri/cdn/$version/img/passive/$nameImage"
    private fun getChampionAbilityUri(nameImage: String, version: String) = "$uri/cdn/$version/img/spell/$nameImage"
    private fun getSummonerSpellUri(nameImage: String, version: String) = "$uri/cdn/$version/img/spell/$nameImage"
    private fun getItemUri(itemId: Int, version: String) = "$uri/cdn/$version/img/item/$itemId.png"
    private fun getMasteryUri(masteryId: String, version: String) = "$uri/cdn/$version/img/mastery/$masteryId.png"
    private fun getRuneUri(nameImage: String, version: String) = "$uri/cdn/$version/img/rune/$nameImage"
    private fun getSpriteUri(imageName: String, version: String) = "$uri/cdn/$version/img/sprite/$imageName"
    private fun getMapUri(mapId: Int, version: String) = "$uri/cdn/$version/img/map/map$mapId.png"

    /**
     * Get profile icon
     *
     * @param version version of the data dragon
     * @param profileIconId id of profile icon
     * @param options Optional parameters. Nullable
     * @return [Bitmap] requested image in bitmap format
     */
    fun getProfileIcon(version: String, profileIconId: Int, options: Map<String, Any>? = null): Bitmap {
        return getImage(getProfileIconUri(profileIconId, version), options)
    }

    /**
     * Get profile icon
     *
     * @param version version of the data dragon
     * @param profileIconId id of profile icon
     * @param view [ImageView] to display the requested image
     * @param options Optional parameters. Nullable
     */
    fun getProfileIcon(version: String, profileIconId: Int, view: ImageView, options: Map<String, Any>? = null) {
        getImage(getProfileIconUri(profileIconId, version), view, options)
    }

    /**
     * Get profile icon
     *
     * @param version version of the data dragon
     * @param profileIconId id of profile icon
     * @param callback [Callback] to return requested image
     * @param options Optional parameters. Nullable
     */
    fun getProfileIcon(version: String, profileIconId: Int, callback: Callback, options: Map<String, Any>? = null) {
        getImage(getProfileIconUri(profileIconId, version), callback, options)
    }

    /**
     * Get splash art
     *
     * @param nameChampion champion's name
     * @param skinNum skin's number
     * @param options Optional parameters. Nullable
     * @return [Bitmap] requested image in bitmap format
     */
    fun getSplashArt(nameChampion: String, skinNum: Int, options: Map<String, Any>? = null): Bitmap {
        return getImage(getSplashArtUri(nameChampion, skinNum), options)
    }

    /**
     * Get splash art
     *
     * @param nameChampion champion's name
     * @param skinNum skin's number
     * @param view [ImageView] to display the requested image
     * @param options Optional parameters. Nullable
     */
    fun getSplashArt(nameChampion: String, skinNum: Int, view: ImageView, options: Map<String, Any>? = null) {
        getImage(getSplashArtUri(nameChampion, skinNum), view, options)
    }

    /**
     * Get splash art
     *
     * @param nameChampion champion's name
     * @param skinNum skin's number
     * @param callback [Callback] to return requested image
     * @param options Optional parameters. Nullable
     */
    fun getSplashArt(nameChampion: String, skinNum: Int, callback: Callback, options: Map<String, Any>? = null) {
        getImage(getSplashArtUri(nameChampion, skinNum), callback, options)
    }

    /**
     * Get loading screen art
     *
     * @param nameChampion champion's name
     * @param skinNum skin's number
     * @param options Optional parameters. Nullable
     * @return [Bitmap] requested image in bitmap format
     */
    fun getLoadingScreenArt(nameChampion: String, skinNum: Int, options: Map<String, Any>? = null): Bitmap {
        return getImage(getLoadingScreenArtUri(nameChampion, skinNum), options)
    }

    /**
     * Get loading screen art
     *
     * @param nameChampion champion's name
     * @param skinNum skin's number
     * @param view [ImageView] to display the requested image
     * @param options Optional parameters. Nullable
     */
    fun getLoadingScreenArt(nameChampion: String, skinNum: Int, view: ImageView, options: Map<String, Any>? = null) {
        getImage(getLoadingScreenArtUri(nameChampion, skinNum), view, options)
    }

    /**
     * Get loading screen art
     *
     * @param nameChampion champion's name
     * @param skinNum skin's number
     * @param callback [Callback] to return requested image
     * @param options Optional parameters. Nullable
     */
    fun getLoadingScreenArt(nameChampion: String, skinNum: Int, callback: Callback, options: Map<String, Any>? = null) {
        getImage(getLoadingScreenArtUri(nameChampion, skinNum), callback, options)
    }

    /**
     * Get champion square
     *
     * @param version version of the data dragon
     * @param nameChampion champion's name
     * @param options Optional parameters. Nullable
     * @return [Bitmap] requested image in bitmap format
     */
    fun getChampionSquare(version: String, nameChampion: String, options: Map<String, Any>? = null): Bitmap {
        return getImage(getChampionSquareUri(nameChampion, version), options)
    }

    /**
     * Get champion square
     *
     * @param version version of the data dragon
     * @param nameChampion champion's name
     * @param view [ImageView] to display the requested image
     * @param options Optional parameters. Nullable
     */
    fun getChampionSquare(version: String, nameChampion: String, view: ImageView, options: Map<String, Any>? = null) {
        getImage(getChampionSquareUri(nameChampion, version), view, options)
    }

    /**
     * Get champion square
     *
     * @param version version of the data dragon
     * @param nameChampion champion's name
     * @param callback [Callback] to return requested image
     * @param options Optional parameters. Nullable
     */
    fun getChampionSquare(version: String, nameChampion: String, callback: Callback, options: Map<String, Any>? = null) {
        getImage(getChampionSquareUri(nameChampion, version), callback, options)
    }

    /**
     * Get passive abilities
     *
     * @param version version of the data dragon
     * @param nameImage image's name
     * @param options Optional parameters. Nullable
     * @return [Bitmap] requested image in bitmap format
     */
    fun getPassiveAbility(version: String, nameImage: String, options: Map<String, Any>? = null): Bitmap {
        return getImage(getPassiveAbilityUri(nameImage, version), options)
    }

    /**
     * Get passive abilities
     *
     * @param version version of the data dragon
     * @param nameImage image's name
     * @param view [ImageView] to display the requested image
     * @param options Optional parameters. Nullable
     */
    fun getPassiveAbility(version: String, nameImage: String, view: ImageView, options: Map<String, Any>? = null) {
        getImage(getPassiveAbilityUri(nameImage, version), view, options)
    }

    /**
     * Get passive abilities
     *
     * @param version version of the data dragon
     * @param nameImage image's name
     * @param callback [Callback] to return requested image
     * @param options Optional parameters. Nullable
     */
    fun getPassiveAbility(version: String, nameImage: String, callback: Callback, options: Map<String, Any>? = null) {
        getImage(getPassiveAbilityUri(nameImage, version), callback, options)
    }

    /**
     * Get champion abilities
     *
     * @param version version of the data dragon
     * @param nameImage image's name
     * @param options Optional parameters. Nullable
     * @return [Bitmap] requested image in bitmap format
     */
    fun getChampionAbility(version: String, nameImage: String, options: Map<String, Any>? = null): Bitmap {
        return getImage(getChampionAbilityUri(nameImage, version), options)
    }

    /**
     * Get champion abilities
     *
     * @param version version of the data dragon
     * @param nameImage image's name
     * @param view [ImageView] to display the requested image
     * @param options Optional parameters. Nullable
     */
    fun getChampionAbility(version: String, nameImage: String, view: ImageView, options: Map<String, Any>? = null) {
        getImage(getChampionAbilityUri(nameImage, version), view, options)
    }

    /**
     * Get champion abilities
     *
     * @param version version of the data dragon
     * @param nameImage image's name
     * @param callback [Callback] to return requested image
     * @param options Optional parameters. Nullable
     */
    fun getChampionAbility(version: String, nameImage: String, callback: Callback, options: Map<String, Any>? = null) {
        getImage(getChampionAbilityUri(nameImage, version), callback, options)
    }


    /**
     * Get summoner spell
     *
     * @param version version of the data dragon
     * @param nameImage image's name
     * @param options Optional parameters. Nullable
     * @return [Bitmap] requested image in bitmap format
     */
    fun getSummonerSpell(version: String, nameImage: String, options: Map<String, Any>? = null): Bitmap {
        return getImage(getSummonerSpellUri(nameImage, version), options)
    }

    /**
     * Get summoner spell
     *
     * @param version version of the data dragon
     * @param nameImage image's name
     * @param view [ImageView] to display the requested image
     * @param options Optional parameters. Nullable
     */
    fun getSummonerSpell(version: String, nameImage: String, view: ImageView, options: Map<String, Any>? = null) {
        getImage(getSummonerSpellUri(nameImage, version), view, options)
    }

    /**
     * Get summoner spell
     *
     * @param version version of the data dragon
     * @param nameImage image's name
     * @param callback [Callback] to return requested image
     * @param options Optional parameters. Nullable
     */
    fun getSummonerSpell(version: String, nameImage: String, callback: Callback, options: Map<String, Any>? = null) {
        getImage(getSummonerSpellUri(nameImage, version), callback, options)
    }


    /**
     * Get item
     *
     * @param version version of the data dragon
     * @param itemId item's id
     * @param options Optional parameters. Nullable
     * @return [Bitmap] requested image in bitmap format
     */
    fun getItem(version: String, itemId: Int, options: Map<String, Any>? = null): Bitmap {
        return getImage(getItemUri(itemId, version), options)
    }

    /**
     * Get item
     *
     * @param version version of the data dragon
     * @param itemId item's id
     * @param view [ImageView] to display the requested image
     * @param options Optional parameters. Nullable
     */
    fun getItem(version: String, itemId: Int, view: ImageView, options: Map<String, Any>? = null) {
        getImage(getItemUri(itemId, version), view, options)
    }

    /**
     * Get item
     *
     * @param version version of the data dragon
     * @param itemId item's id
     * @param callback [Callback] to return requested image
     * @param options Optional parameters. Nullable
     */
    fun getItem(version: String, itemId: Int, callback: Callback, options: Map<String, Any>? = null) {
        getImage(getItemUri(itemId, version), callback, options)
    }

    /**
     * Get mastery
     *
     * @param version version of the data dragon
     * @param masteryId mastery's id
     * @param options Optional parameters. Nullable
     * @return [Bitmap] requested image in bitmap format
     */
    fun getMastery(version: String, masteryId: String, options: Map<String, Any>? = null): Bitmap {
        return getImage(getMasteryUri(masteryId, version), options)
    }

    /**
     * Get mastery
     *
     * @param version version of the data dragon
     * @param masteryId mastery's id
     * @param view [ImageView] to display the requested image
     * @param options Optional parameters. Nullable
     */
    fun getMastery(version: String, masteryId: String, view: ImageView, options: Map<String, Any>? = null) {
        getImage(getMasteryUri(masteryId, version), view, options)
    }

    /**
     * Get mastery
     *
     * @param version version of the data dragon
     * @param masteryId mastery's id
     * @param callback [Callback] to return requested image
     * @param options Optional parameters. Nullable
     */
    fun getMastery(version: String, masteryId: String, callback: Callback, options: Map<String, Any>? = null) {
        getImage(getMasteryUri(masteryId, version), callback, options)
    }

    /**
     * Get rune
     *
     * @param version version of the data dragon
     * @param nameImage image's name
     * @param options Optional parameters. Nullable
     * @return [Bitmap] requested image in bitmap format
     */
    fun getRune(version: String, nameImage: String, options: Map<String, Any>? = null): Bitmap {
        return getImage(getRuneUri(nameImage, version), options)
    }

    /**
     * Get rune
     *
     * @param version version of the data dragon
     * @param nameImage image's name
     * @param view [ImageView] to display the requested image
     * @param options Optional parameters. Nullable
     */
    fun getRune(version: String, nameImage: String, view: ImageView, options: Map<String, Any>? = null) {
        getImage(getRuneUri(nameImage, version), view, options)
    }

    /**
     * Get rune
     *
     * @param version version of the data dragon
     * @param nameImage image's name
     * @param callback [Callback] to return requested image
     * @param options Optional parameters. Nullable
     */
    fun getRune(version: String, nameImage: String, callback: Callback, options: Map<String, Any>? = null) {
        getImage(getRuneUri(nameImage, version), callback, options)
    }

    /**
     * Get sprite
     *
     * @param version version of the data dragon
     * @param nameImage image's name
     * @param options Optional parameters. Nullable
     * @return [Bitmap] requested image in bitmap format
     */
    fun getSprite(version: String, nameImage: String, options: Map<String, Any>? = null): Bitmap {
        return getImage(getSpriteUri(nameImage, version), options)
    }

    /**
     * Get sprite
     *
     * @param version version of the data dragon
     * @param nameImage image's name
     * @param view [ImageView] to display the requested image
     * @param options Optional parameters. Nullable
     */
    fun getSprite(version: String, nameImage: String, view: ImageView, options: Map<String, Any>? = null) {
        getImage(getSpriteUri(nameImage, version), view, options)
    }

    /**
     * Get sprite
     *
     * @param version version of the data dragon
     * @param nameImage image's name
     * @param callback [Callback] to return requested image
     * @param options Optional parameters. Nullable
     */
    fun getSprite(version: String, nameImage: String, callback: Callback, options: Map<String, Any>? = null) {
        getImage(getSpriteUri(nameImage, version), callback, options)
    }

    /**
     * Get map
     *
     * @param version version of the data dragon
     * @param mapId map's id
     * @param options Optional parameters. Nullable
     * @return [Bitmap] requested image in bitmap format
     */
    fun getMap(version: String, mapId: Int, options: Map<String, Any>? = null): Bitmap {
        return getImage(getMapUri(mapId, version), options)
    }

    /**
     * Get map
     *
     * @param version version of the data dragon
     * @param mapId map's id
     * @param view [ImageView] to display the requested image
     * @param options Optional parameters. Nullable
     */
    fun getMap(version: String, mapId: Int, view: ImageView, options: Map<String, Any>? = null) {
        getImage(getMapUri(mapId, version), view, options)
    }

    /**
     * Get map
     *
     * @param version version of the data dragon
     * @param mapId map's id
     * @param callback [Callback] to return requested image
     * @param options Optional parameters. Nullable
     */
    fun getMap(version: String, mapId: Int, callback: Callback, options: Map<String, Any>? = null) {
        getImage(getMapUri(mapId, version), callback, options)
    }

    /**
     * Generic
     */
    private fun getImage(uri: String, options: Map<String, Any>? = null): Bitmap {
        return initPicasso(uri, options).get()
    }

    private fun getImage(uri: String, view: ImageView, options: Map<String, Any>? = null) {
        initPicasso(uri, options).into(view)
    }

    private fun getImage(uri: String, callback: Callback, options: Map<String, Any>? = null) {
        initPicasso(uri, options).fetch(callback)
    }

    private fun initPicasso(uri: String, options: Map<String, Any>? = null): RequestCreator {
        val picasso = Picasso.get()
        picasso.setIndicatorsEnabled(true)
        val requestCreator: RequestCreator = picasso.load(uri)
        config(options, requestCreator)
        return requestCreator
    }

    private fun config(options: Map<String, Any>?, requestCreator: RequestCreator) {
        if (options == null) return

        if (options.containsKey("resize")) {
            resize(options["resite"], requestCreator)
        }

        if (options.containsKey("center-crop")) {
            centerCrop(options["center-crop"], requestCreator)
        }

        if (options.containsKey("fit")) {
            fit(options["fit"], requestCreator)
        }
    }

    private fun fit(optionFit: Any?, requestCreator: RequestCreator) {
        if (optionFit is Boolean) {
            if (optionFit) {
                requestCreator.fit()
            }
        } else {
            Throwable("Fit value need to be a Boolean")
        }
    }

    private fun centerCrop(optionCenterCrop: Any?, requestCreator: RequestCreator) {
        if (optionCenterCrop is Boolean) {
            if (optionCenterCrop) {
                requestCreator.centerCrop()
            }
        } else if (optionCenterCrop is Int) {
            requestCreator.centerCrop(optionCenterCrop)
        } else {
            Throwable("Center crop value need to be a Boolean")
        }
    }

    private fun resize(optionResite: Any?, requestCreator: RequestCreator) {
        if (optionResite is Pair<*, *>) {
            if (optionResite.first is Int && optionResite.second is Int) {
                requestCreator.resize(optionResite.first as Int, optionResite.second as Int)
            } else {
                Throwable("Value in Pair need to bo a Integer")
            }
        } else {
            Throwable("Resize value need to be a Pair")
        }
    }
}