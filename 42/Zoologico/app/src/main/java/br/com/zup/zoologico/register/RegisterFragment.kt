package br.com.zup.zoologico.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.zoologico.ANIMAL_KEY
import br.com.zup.zoologico.R
import br.com.zup.zoologico.REQUIRED
import br.com.zup.zoologico.databinding.FragmentHomeBinding
import br.com.zup.zoologico.register.adapter.AnimalAdapter
import br.com.zup.zoologico.model.Animal

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val adapter: AnimalAdapter by lazy { AnimalAdapter(arrayListOf(), ::animalDetail) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bvAdd.setOnClickListener{
            addAnimal()
        }
    }
    private fun addAnimal(){
        val animalList = mutableListOf<Animal>()
        val animal = getAnimal()
        if(animal != null){
            animalList.add(animal)
            adapter.listUpdate(animalList)
            showList()
        }
    }
    private fun getAnimal(): Animal?{
        val name = binding.etName.text.toString()
        val description = binding.etDesc.text.toString()
        if(name.isNotEmpty() && description.isNotEmpty()){
            clear()
            return Animal(name, description)
        }else{
            binding.etName.error = REQUIRED
            binding.etDesc.error = REQUIRED
            return null
        }
    }
    private fun showList(){
        binding.rvLista.adapter = adapter
        binding.rvLista.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL,false)
    }
    private fun clear(){
        binding.etName.text.clear()
        binding.etDesc.text.clear()
    }
    private fun animalDetail(animal: Animal){
        val bundle = bundleOf(ANIMAL_KEY to animal)
        NavHostFragment.findNavController(this).navigate(R.id.action_homeFragment_to_detailFragment,bundle)
    }
}