package br.com.zup.musicafavorita.info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import br.com.zup.musicafavorita.R
import br.com.zup.musicafavorita.databinding.ActivityDetalheBinding
import br.com.zup.musicafavorita.info.adapter.DetalhePagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class DetalheActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetalheBinding
    private val infoBand = listOf("info","photos")

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
      binding.vpDetalhe.adapter = detalhePagerAdapter
      TabLayoutMediator(binding.tlDetalhe, binding.vpDetalhe) { tab, position ->
          tab.text = infoBand[position] }.attach()
   }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}