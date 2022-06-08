package br.com.zup.musicafavorita.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.musicafavorita.databinding.ActivityMainBinding
import br.com.zup.musicafavorita.info.DetalheActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botao.setOnClickListener{
            startActivity(Intent(this, DetalheActivity::class.java))
        }
    }
}