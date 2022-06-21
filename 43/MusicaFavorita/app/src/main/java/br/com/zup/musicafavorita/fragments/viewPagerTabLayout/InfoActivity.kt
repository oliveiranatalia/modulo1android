package br.com.zup.musicafavorita.fragments.viewPagerTabLayout

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import br.com.zup.musicafavorita.databinding.ActivityInfoBinding
import br.com.zup.musicafavorita.fragments.viewPagerTabLayout.adapter.InfoPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding
    private val options = listOf("Informações", "Albuns")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        appBar()
        toolbar()
        showViewPagerTabLayout()
    }
    private fun appBar(){
        supportActionBar?.hide()
    }
    private fun toolbar(){
        val navHostFragment = (supportFragmentManager.findFragmentById(binding.navHostFragment.id)) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController,appBarConfiguration)
    }
    private fun showViewPagerTabLayout(){
        val infoPagerAdapter = InfoPagerAdapter(supportFragmentManager,lifecycle, options)
        binding.vpInformacoes.adapter = infoPagerAdapter

        TabLayoutMediator(binding.tlInformacoes, binding.vpInformacoes){ tab, position -> tab.text = options[position]}.attach()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}