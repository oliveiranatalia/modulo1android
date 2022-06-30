package br.com.zup.zoologico.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.zoologico.ANIMAL_KEY
import br.com.zup.zoologico.databinding.FragmentDetailBinding
import br.com.zup.zoologico.model.Animal

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentDetailBinding.inflate(inflater,container,false)
        getAnimal()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAnimal()
    }
    private fun getAnimal(){
        val animal = arguments?.getParcelable<Animal>(ANIMAL_KEY)
        if(animal != null){
            binding.tvDetailName.text = animal.getName()
            binding.tvDetailDescription.text = animal.getDescription()
        }
    }
}