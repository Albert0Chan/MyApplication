package com.alberto.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.alberto.myapplication.R
import com.alberto.myapplication.adapter.ServicosAdapter
import com.alberto.myapplication.databinding.ActivityHomeBinding
import com.alberto.myapplication.model.Servicos

class Home : AppCompatActivity() {

   private lateinit var binding: ActivityHomeBinding
   private lateinit var servicosAdapter: ServicosAdapter
   private val listaServicos: MutableList<Servicos> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_home)
        setContentView(binding.root)

        supportActionBar?.hide()
        val nome = intent.extras?.getString("nome")

        binding.txtpage.text = "Bem Vindo(a),$nome"
        val recyclerViewServicos =binding.recyclerViewServicos
        recyclerViewServicos.layoutManager = GridLayoutManager(this,2)
        servicosAdapter = ServicosAdapter(this,listaServicos)
        recyclerViewServicos.setHasFixedSize(true)
        recyclerViewServicos.adapter = servicosAdapter;
        getServicos()
    }

    private fun getServicos(){
        val servico1 = Servicos(R.drawable.baseline_security_24, "Verificar Site")
        listaServicos.add(servico1)

        val servico2 = Servicos(R.drawable.baseline_password_24, "Salvar Senhas")
        listaServicos.add(servico2)

        val servico3 = Servicos(R.drawable.baseline_signal_wifi_4_bar_lock_24, "Verificar Wifi")
        listaServicos.add(servico3)

        val servico4 = Servicos(R.drawable.baseline_coronavirus_24, "Verificar Ameaça")
        listaServicos.add(servico4)
    }
}