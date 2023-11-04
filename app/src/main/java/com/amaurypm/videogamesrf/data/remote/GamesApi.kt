package com.amaurypm.videogamesrf.data.remote


import com.amaurypm.videogamesrf.data.remote.model.GameDetailDto
import com.amaurypm.videogamesrf.data.remote.model.GameDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

/**
 * Creado por Amaury Perea Matsumura el 02/09/23
 */
interface GamesApi {

    @GET
    fun getGames(
        @Url url: String?
    ): Call<List<GameDto>>
    //getGames("cm/games/games_list.php")


    @GET("cm/games/game_detail.php")
    fun getGameDetail(
        @Query("id") id: String?/*,
        @Query("name") name: String?*/
    ): Call<GameDetailDto>
    //getGameDetail("21347","amaury")
    //cm/games/game_detail.php?id=21347&name=amaury

    //Para Apiary
    @GET("pacient/pacient_list")
    fun getGamesApiary(): Call<List<GameDto>>

    //games/game_detail/21357
    @GET("pacient/pacient_detail/{id}")
    fun getGameDetailApiary(
        @Path("id") id: String?/*,
        @Path("name") name: String?*/
    ): Call<GameDetailDto>

    //getGameDetailApiary("21357","Amaury")
    //games/game_detail/21347/Amaury




}