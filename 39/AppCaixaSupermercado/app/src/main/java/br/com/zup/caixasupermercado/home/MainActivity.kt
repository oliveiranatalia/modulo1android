package br.com.zup.caixasupermercado.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.caixasupermercado.ERROR
import br.com.zup.caixasupermercado.PRODUTO
import br.com.zup.caixasupermercado.databinding.ActivityMainBinding
import br.com.zup.caixasupermercado.detalhe.DetalheCompra
import br.com.zup.caixasupermercado.model.Produto

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var nome:String
    private lateinit var qtd: String
    private lateinit var preco:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calcular.setOnClickListener{
            userInfo()
        }
    }
    private fun userInfo(){
        this.nome = binding.nomeProduto.text.toString()
        this.qtd = binding.qtdProduto.text.toString()
        this.preco = binding.valor.text.toString()

        checkInfo()
        if(!checkInfo()) {
            val produto = Produto(this.nome, this.qtd.toInt(), this.preco.toDouble())
            val intent = Intent(this, DetalheCompra::class.java).apply{
                putExtra(PRODUTO,produto)
            }
            startActivity(intent)
            clear()
        }
    }
    private fun checkInfo():Boolean{
        when{
            this.nome.isEmpty() -> {
                binding.nomeProduto.error = ERROR
                return true
            }
            this.qtd.isEmpty() -> {
                binding.qtdProduto.error = ERROR
                return true
            }
            this.preco.isEmpty() -> {
                binding.valor.error = ERROR
            return true}
        }
        return false
    }
    private fun clear(){
        binding.nomeProduto.text.clear()
        binding.qtdProduto.text.clear()
        binding.valor.text.clear()
    }
}