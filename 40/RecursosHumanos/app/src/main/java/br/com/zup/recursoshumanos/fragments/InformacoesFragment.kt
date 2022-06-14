package br.com.zup.recursoshumanos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.recursoshumanos.KEY
import br.com.zup.recursoshumanos.databinding.FragmentInformacoesBinding
import br.com.zup.recursoshumanos.model.Funcionario

class InformacoesFragment : Fragment() {
    private lateinit var binding: FragmentInformacoesBinding
    private lateinit var objeto:Funcionario

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInformacoesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showInfo()
    }
    private fun getInfo(){
        val func = arguments?.getParcelable<Funcionario>(KEY)
        func?.let {objeto = it}
    }
    private fun showInfo(){
        getInfo()
        binding.tvNomeFunc.text = objeto.getNome()
        binding.tvHorasFunc.text = objeto.getHoras().toString()
        binding.tvValorHora.text = objeto.getValor().toString()
    }
}