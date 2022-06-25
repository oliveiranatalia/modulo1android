package br.com.zup.musicafavorita.viewPager.albums

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import br.com.zup.musicafavorita.*
import br.com.zup.musicafavorita.databinding.FragmentAlbumsBinding
import br.com.zup.musicafavorita.viewPager.albums.adapter.BandAdapter
import br.com.zup.musicafavorita.model.Band

class PhotosFragment : Fragment() {
    private lateinit var binding: FragmentAlbumsBinding
    private val bandAdapter: BandAdapter by lazy { BandAdapter(arrayListOf()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlbumsBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAlbumList()
    }
    private fun getAlbumList(){
        val photosList = mutableListOf<Band>()
        photosList.add(Band(R.drawable.beatles_um))
        photosList.add(Band(R.drawable.beatles_dois))
        photosList.add(Band(R.drawable.beatles_tres))
        photosList.add(Band(R.drawable.beatles_quatro))
        photosList.add(Band(R.drawable.beatles_cinco))
        photosList.add(Band(R.drawable.beatles_seis))
        photosList.add(Band(R.drawable.beatles_sete))
        photosList.add(Band(R.drawable.beatles_oito))
        photosList.add(Band(R.drawable.beatles_nove))
        photosList.add(Band(R.drawable.beatles_dez))
        bandAdapter.update(photosList)
        showRecyclerView()
    }
    private fun showRecyclerView(){
        binding.rvListaAlbum.adapter = bandAdapter
        binding.rvListaAlbum.layoutManager = GridLayoutManager(context,2)
    }
}