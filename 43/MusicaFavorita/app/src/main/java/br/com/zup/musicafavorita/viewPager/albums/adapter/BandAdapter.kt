package br.com.zup.musicafavorita.viewPager.albums.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.musicafavorita.databinding.AlbumItemBinding
import br.com.zup.musicafavorita.model.Band

class BandAdapter(private var albumsList:MutableList<Band>):RecyclerView.Adapter<BandAdapter.ViewHolder>() {

    class ViewHolder(val binding: AlbumItemBinding):RecyclerView.ViewHolder(binding.root){
        fun showList(band:Band){
            binding.ivItem.setImageResource(band.getImage())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AlbumItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album = albumsList[position]
        holder.showList(album)
    }

    override fun getItemCount() = albumsList.size

    fun update(newList:MutableList<Band>){
        if(newList.size == 0 || albumsList == newList){
            albumsList = newList
        }else{
            albumsList.addAll(newList)
        }
        notifyDataSetChanged()
    }
}