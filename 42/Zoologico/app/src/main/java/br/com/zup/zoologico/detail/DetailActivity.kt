package br.com.zup.zoologico.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.com.zup.zoologico.ANIMAL_KEY
import br.com.zup.zoologico.R
import br.com.zup.zoologico.databinding.ActivityDetailBinding
import br.com.zup.zoologico.model.Animal

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        appBar()
        getAnimal()
    }
    private fun getAnimal(){
        val animal = intent.getParcelableExtra<Animal>(ANIMAL_KEY)
        if(animal != null){
            binding.tvDetailName.text = animal.getName()
            binding.tvDetailDescription.text = animal.getDescription()
        }
    }
    private fun appBar(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.app_name)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}