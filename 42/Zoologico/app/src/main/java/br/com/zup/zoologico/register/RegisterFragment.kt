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
    private var animalList = arrayListOf<Animal>()
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
        adapter.listUpdate(animalList)
        binding.bvAdd.setOnClickListener{
            getAnimal()
        }
    }
    private fun getAnimal(){
        val name = binding.etName.text.toString()
        val description = binding.etDesc.text.toString()
        if(name.isNotEmpty() && description.isNotEmpty()){
            animalList.add(Animal(name, description))
            adapter.listUpdate(animalList)
            getRecyclerView()
            clear()
        }else{
            binding.etName.error = REQUIRED
            binding.etDesc.error = REQUIRED
        }
    }
    private fun getRecyclerView(){
        binding.rvLista.adapter = adapter
        binding.rvLista.layoutManager = LinearLayoutManager(context)
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