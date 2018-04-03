package com.nspu.riotapi.services.datadragon


object DataDragonUri {
    const val PREFIX = "/cdn/{version}/data/{language}/"

    const val URI_PROFILE_ICON = PREFIX + "profileicon.json"
    const val URI_CHAMPIONS = PREFIX + "champion.json"
    const val URI_CHAMPION = PREFIX + "champion/{championName}.json"
    const val URI_ITEMS = PREFIX + "item.json"
    const val URI_MASTERIES = PREFIX + "mastery.json"
    const val URI_RUNES = PREFIX + "rune.json"
    const val URI_SUMMONER_SPELLS = PREFIX + "summoner.json"


    const val URI_VERSIONS = "/api/versions.json"
    const val URI_LANGUAGES = "/cdn/languages.json"
    const val URI_LANGUAGE_STRINGS = PREFIX + "language.json"
}