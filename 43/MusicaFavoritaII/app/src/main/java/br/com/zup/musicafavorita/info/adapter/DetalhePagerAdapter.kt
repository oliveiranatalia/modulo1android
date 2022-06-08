package br.com.zup.musicafavorita.info.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.com.zup.musicafavorita.info.InfoFragment
import br.com.zup.musicafavorita.info.PhotosFragment

class DetalhePagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, private var infoBand:List<String>
): FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return InfoFragment()
            1 -> return PhotosFragment()
        }
        return InfoFragment()
    }
    override fun getItemCount(): Int = infoBand.size
}