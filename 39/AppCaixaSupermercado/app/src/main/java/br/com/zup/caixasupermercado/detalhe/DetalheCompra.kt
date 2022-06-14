package br.com.zup.caixasupermercado.detalhe

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.caixasupermercado.PRODUTO
import br.com.zup.caixasupermercado.home.MainActivity
import br.com.zup.caixasupermercado.databinding.DetalheCompraBinding
import br.com.zup.caixasupermercado.model.Produto

class DetalheCompra :AppCompatActivity() {
    private lateinit var binding:DetalheCompraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetalheCompraBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getProduto()

        binding.botaoRefazer.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getProduto(){
        val produto = intent.getParcelableExtra<Produto>(PRODUTO)
        if (produto != null) {
            getAmount(produto)
        }
    }
    private fun getAmount(produto:Produto){
        val valor = produto.getQtd() * produto.getValor()
        showToUser(valor)
    }

    private fun showToUser(valor:Double){
        val exibir = "O valor total é de R$ $valor"
        binding.totalTela.text = exibir
    }
}