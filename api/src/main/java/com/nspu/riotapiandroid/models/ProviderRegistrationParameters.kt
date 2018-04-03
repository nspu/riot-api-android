package fr.nspu.riot.api.models

import android.os.Parcel
import android.os.Parcelable

class ProviderRegistrationParameters(
        var region: String? = null, //The provider's callback URL to which tournament game results in this region should be posted. The URL must be well-formed, use the http or https protocol, and use the default port for the protocol (http URLs must use port 80, https URLs must use port 443).
        var url: String? = null //The region in which the provider will be running tournaments. (Legal values: BR, EUNE, EUW, JP, LAN, LAS, NA, OCE, PBE, RU, TR)
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(region)
        writeString(url)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ProviderRegistrationParameters> = object : Parcelable.Creator<ProviderRegistrationParameters> {
            override fun createFromParcel(source: Parcel): ProviderRegistrationParameters = ProviderRegistrationParameters(source)
            override fun newArray(size: Int): Array<ProviderRegistrationParameters?> = arrayOfNulls(size)
        }
    }
}