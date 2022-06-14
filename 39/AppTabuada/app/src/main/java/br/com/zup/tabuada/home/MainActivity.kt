package br.com.zup.tabuada.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.tabuada.calculo.CalculoTabuada
import br.com.zup.tabuada.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var number:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clear()
        binding.botaoCalcular.setOnClickListener{
            getTabuada()
        }
    }
    private fun getTabuada(){
        this.number = binding.inputTabuada.text.toString()
        val intent = Intent(this,CalculoTabuada::class.java).apply{
            putExtra("number",number.toInt())
        }
        startActivity(intent)
        clear()
    }
    private fun clear(){
        binding.inputTabuada.text.clear()
    }
}