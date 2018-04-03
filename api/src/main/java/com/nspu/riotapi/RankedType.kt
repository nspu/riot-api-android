package com.nspu.riotapi

/**
 * Type of queue for ranked
 * @param s name of the type of ranked
 */
enum class RankedType(s: String) {
    RANKED_FLEX_SR("RANKED_FLEX_SR"),
    RANKED_FLEX_TT("RANKED_FLEX_TT"),
    RANKED_SOLO_5x5("RANKED_SOLO_5x5"),
    RANKED_TEAM_5x5("RANKED_TEAM_5x5"),
    RANKED_TEAM_3x3("RANKED_TEAM_3x3"),
}