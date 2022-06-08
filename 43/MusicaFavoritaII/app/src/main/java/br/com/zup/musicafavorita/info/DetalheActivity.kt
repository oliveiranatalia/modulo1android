package br.com.zup.musicafavorita.info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.musicafavorita.R
import br.com.zup.musicafavorita.databinding.ActivityDetalheBinding
import br.com.zup.musicafavorita.info.adapter.BandaAdapter
import br.com.zup.musicafavorita.info.adapter.DetalhePagerAdapter
import br.com.zup.musicafavorita.model.Banda

class DetalheActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetalheBinding
    private val infoBand = listOf("info","photos")
    private val adapterPhotos: BandaAdapter by lazy { BandaAdapter(arrayListOf(), this::showRecyclerView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalheBinding.inflate(layoutInflater)
        setContentView(binding.root)

        actionBar()
        goToViewPagerTabLayout()
    }
    private fun actionBar(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.detalhe_banda)
    }
   private fun goToViewPagerTabLayout(){
       val detalhePagerAdapter = DetalhePagerAdapter(supportFragmentManager,lifecycle,infoBand)
    //TODO checar chamada segura e vp2
    //binding.vpDetalhe.adapter = detalhePagerAdapter
    //TabLayoutMediator(binding.tlDetalhe, binding.vpDetalhe) { tab, position ->
    //    tab.text = infoBand[position] }.attach()
   }
    private fun showRecyclerView(){
        addPhotos()
        binding.rvPhotos.adapter = adapterPhotos
        binding.rvPhotos.layoutManager = GridLayoutManager(this,4)
    }
    private fun addPhotos(){
        val photos = mutableListOf<Banda>()
        photos.add(Banda(R.drawable.beatles3))
        photos.add(Banda(R.drawable.beatles4))
        photos.add(Banda(R.drawable.beatles5))
        photos.add(Banda(R.drawable.beatles6))
        adapterPhotos.update(photos)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}