package com.amaurypm.videogamesrf.data

import com.amaurypm.videogamesrf.data.remote.GamesApi
import com.amaurypm.videogamesrf.data.remote.model.GameDetailDto
import com.amaurypm.videogamesrf.data.remote.model.GameDto
import retrofit2.Call
import retrofit2.Retrofit

/**
 * Creado por Amaury Perea Matsumura el 02/09/23
 */
class GameRepository(private val retrofit: Retrofit) {

    private val gamesApi: GamesApi = retrofit.create(GamesApi::class.java)

    fun getGames(url: String): Call<List<GameDto>> =
        gamesApi.getGames(url)

    fun getGameDetail(id: String?): Call<GameDetailDto> =
        gamesApi.getGameDetail(id)

    fun getGamesApiary(): Call<List<GameDto>> =
        gamesApi.getGamesApiary()

    fun getGameDetailApiary(id: String?): Call<GameDetailDto> =
        gamesApi.getGameDetailApiary(id)


}