package br.com.zup.zoologico.register.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.zoologico.databinding.AnimalItemBinding
import br.com.zup.zoologico.model.Animal

class AnimalAdapter(private var animalList: MutableList<Animal>,
                    private var click:(animal:Animal)->Unit
): RecyclerView.Adapter<AnimalAdapter.ViewHolder>(){

    class ViewHolder(val binding:AnimalItemBinding):RecyclerView.ViewHolder(binding.root){
        fun showList(animal:Animal){
            val item = animal.getName()
            binding.tvItem.text = item
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(AnimalItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animal = animalList[position]
        holder.showList(animal)
        holder.binding.cvItem.setOnClickListener{
            click(animal)
        }
    }
    override fun getItemCount() = animalList.size

    fun listUpdate(newList: MutableList<Animal>){
        if(animalList.size ==0 || animalList == newList){
            animalList = newList
        }else {
            animalList.addAll(newList)
        }
        notifyDataSetChanged()
    }
}