# Riot API for Android

This project is a wrapper for [Riot API](https://developer.riotgames.com/).
It uses [Retrofit](http://square.github.io/retrofit/) and [Picasso](http://square.github.io/picasso/).

[Documentation here](https://nspu.github.io/riot-api-android/docs/index.html)

## Getting starting
To build this project, use `./gradlew assemble`. 
Then put the `aar` file that can be found in `riot-api/build/outputs/aar/riot-api-0.0.1.aar` to your lib directory 

#### Example

```kotlin
//datadragon api(no need api key, only static data)
var dataDragonApi: DataDragonApi = DataDragonApi(context) //forced cache
var dataDragonApi: DataDragonApi = DataDragonApi() //auto cache

//riot api (do not publish app with your api key)
val riotApi: RiotApi = RiotApi("api-key", "na1.api.riotgames.com")
```

```kotlin
var call: Call<ChampionListData> = dataDragon.getChampions() //champions list
var call: Call<ShardStatus> = riotApi.getLoLStatus() //servers status
```

#### You can pass optional options for riot api
```kotlin 
val options = mapOf("Accept-Language" to "en-US,en;q=0.5")
riotApi.matchService.getMatchById(000000000, options)
```


[Doc about Call (Retrofit)](https://square.github.io/retrofit/2.x/retrofit/retrofit2/Call.html)


## Image

#### Get the square image of Aatrox
```kotlin
var bitmap: Bitmap =  dataDragonApi.getChampionSquare("6.24.1", "en_US", "Aatrox.png") //get directly the bitmap
dataDragonApi.getChampionSquare("6.24.1", "en_US","Aatrox.png", callback) //with Callback
dataDragonApi.getChampionSquare("6.24.1", "en_US","Aatrox.png", imageView) //with ImageView
```

[Doc about Callback (Picasso)](http://square.github.io/picasso/2.x/picasso/com/squareup/picasso/Callback.html)

#### You can pass optional options
```kotlin 
val options = mapOf("fit" to false, "center-crop" to false, "resize" to  Pair(50, 50))
dataDragonApi.getChampionSquare("Aatrox.png", imageView, options)
```



## Progress 
Implementation of all api reference is done.

Todo: Test Tounament-Stub and Tournament


Inspired by [spotify-web-api-android](https://github.com/kaaes/spotify-web-api-android)