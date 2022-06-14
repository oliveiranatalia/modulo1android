package br.com.zup.tabuada.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.tabuada.ERROR
import br.com.zup.tabuada.NUMBER
import br.com.zup.tabuada.calculo.CalculoTabuada
import br.com.zup.tabuada.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var number:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botaoCalcular.setOnClickListener{
            getSendNumber()
        }
    }
    private fun getSendNumber(){
        this.number = binding.inputTabuada.text.toString()
        if(!checkInfo()){
            val intent = Intent(this,CalculoTabuada::class.java).apply {putExtra(NUMBER,number)}
            startActivity(intent)
            clear()
        }
    }
    private fun checkInfo():Boolean{
        if(this.number.isEmpty()){
            binding.inputTabuada.error = ERROR
            return true
        }
        return false
    }
    private fun clear(){
        binding.inputTabuada.text.clear()
    }
}