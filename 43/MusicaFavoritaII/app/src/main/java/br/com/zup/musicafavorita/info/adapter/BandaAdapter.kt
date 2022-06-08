package br.com.zup.musicafavorita.info.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.musicafavorita.databinding.BandaItemBinding
import br.com.zup.musicafavorita.model.Banda
import kotlin.reflect.KFunction0

class BandaAdapter(private var photoList:MutableList<Banda>) : RecyclerView.Adapter<BandaAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BandaAdapter.ViewHolder {
        val binding = BandaItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BandaAdapter.ViewHolder, position: Int) {
        val photos = photoList[position]
        holder.addPhotos(photos)
    }
    override fun getItemCount() = photoList.size

    @SuppressLint("NotifyDataSetChanged")
    fun update(newPhotos:MutableList<Banda>){
        if(photoList.size == 0){
            photoList = newPhotos
        } else {
            photoList.addAll(newPhotos)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(val binding:BandaItemBinding):RecyclerView.ViewHolder(binding.root){
        fun addPhotos(photo:Banda){
            binding.ivPhoto.setImageResource((photo.getImage()))
        }
    }
}
