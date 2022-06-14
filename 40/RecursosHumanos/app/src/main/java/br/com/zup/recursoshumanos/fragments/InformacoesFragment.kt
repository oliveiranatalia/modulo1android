package br.com.zup.recursoshumanos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.recursoshumanos.databinding.FragmentInformacoesBinding

class InformacoesFragment : Fragment() {
    private lateinit var binding: FragmentInformacoesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInformacoesBinding.inflate(inflater,container,false)
        return binding.root
    }
}