package br.com.zup.zoologico

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.zoologico.databinding.FragmentDescricaoBinding

class DescricaoFragment : Fragment() {
    private lateinit var binding: FragmentDescricaoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDescricaoBinding.inflate(inflater,container,false)
        return binding.root
    }
}