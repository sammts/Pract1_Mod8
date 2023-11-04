package com.amaurypm.videogamesrf.ui

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.amaurypm.videogamesrf.R
import com.amaurypm.videogamesrf.data.GameRepository
import com.amaurypm.videogamesrf.data.remote.RetrofitHelper
import com.amaurypm.videogamesrf.data.remote.model.GameDto
import com.amaurypm.videogamesrf.databinding.ActivityMainBinding
import com.amaurypm.videogamesrf.ui.fragments.GamesListFragment
import com.amaurypm.videogamesrf.util.Constants
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    /*private lateinit var repository: GameRepository
    private lateinit var retrofit: Retrofit*/

    private lateinit var mp: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(5000)

        setTheme(R.style.Theme_VideoGamesRF)

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, GamesListFragment())
                .commit()
        }

        mp = MediaPlayer.create(this, R.raw.fondo)
        mp.start()
        /*retrofit = RetrofitHelper().getRetrofit()

        repository = GameRepository(retrofit)

        lifecycleScope.launch {
            val call: Call<List<GameDto>> = repository.getGames("cm/games/games_list.php")

            call.enqueue(object: Callback<List<GameDto>>{
                override fun onResponse(
                    call: Call<List<GameDto>>,
                    response: Response<List<GameDto>>
                ) {
                    Log.d(Constants.LOGTAG, "Respuesta del servidor ${response.body()}")
                }

                override fun onFailure(call: Call<List<GameDto>>, t: Throwable) {
                    //Manejo del error
                    Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                }

            })

        }*/
    }
}