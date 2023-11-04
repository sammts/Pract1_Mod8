package com.amaurypm.videogamesrf.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.amaurypm.videogamesrf.R
import com.amaurypm.videogamesrf.data.remote.PokemonApi
import com.amaurypm.videogamesrf.data.remote.model.PokemonDetailDto
import com.amaurypm.videogamesrf.databinding.ActivityTestPokemonBinding
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TestPokemon : AppCompatActivity() {

    private lateinit var binding: ActivityTestPokemonBinding

    private val BASE_URL = "https://pokeapi.co/"

    private val LOGTAG = "LOGS"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityTestPokemonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val pokemonApi: PokemonApi = retrofit.create(PokemonApi::class.java)

        val call: Call<PokemonDetailDto> = pokemonApi.getPokemonDetail("200")

        call.enqueue(object: Callback<PokemonDetailDto>{
            override fun onResponse(
                call: Call<PokemonDetailDto>,
                response: Response<PokemonDetailDto>
            ) {
                Log.d(LOGTAG, "${response.body()?.sprites?.other?.officialArtwork?.frontDefault}")

                Glide.with(this@TestPokemon)
                    .load(response.body()?.sprites?.other?.officialArtwork?.frontDefault)
                    .into(binding.ivPokemon)
            }

            override fun onFailure(call: Call<PokemonDetailDto>, t: Throwable) {
                Toast.makeText(this@TestPokemon, "Error al consultar API", Toast.LENGTH_LONG).show()
            }

        })
    }
}