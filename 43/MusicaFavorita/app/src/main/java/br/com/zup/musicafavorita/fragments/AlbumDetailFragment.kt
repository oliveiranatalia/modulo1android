package br.com.zup.musicafavorita.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.musicafavorita.KEY
import br.com.zup.musicafavorita.databinding.FragmentAlbumDetailBinding
import br.com.zup.musicafavorita.model.Album

class AlbumDetailFragment : Fragment() {
    private lateinit var binding: FragmentAlbumDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlbumDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAlbum()
    }
    private fun getAlbum():Album?{
        val album = arguments?.getParcelable<Album>(KEY)
        if(album != null) {
            binding.ivAlbumDetail.setImageResource(album.getImage())
            binding.tvNomeAlbum.text = album.getName()
            binding.tvDescAlbum.text = album.getDesc()
            binding.tvInfoAlbum.text = album.getInfo()
        }
        return album
    }

}