package com.example.listatelefone.ui.theme

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.Snapshot.Companion.observe
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listatelefone.adapter.ContatoListAdapter
import com.example.listatelefone.adapter.listener.ContatoOnClickListener
import com.example.listatelefone.databinding.ActivityMainBinding
import com.example.listatelefone.model.Contato
import com.example.listatelefone.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var launcher: ActivityResultLauncher<Intent>
    private lateinit var adapter: ContatoListAdapter
    private var listaContatos: List<Contato> = listOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.recyclerViewContatos.layoutManager = LinearLayoutManager(this)
        viewModel.getListaContato()
        observe()

        launcher = registerForActivityResult(ActivityResultContracts .StartActivityForResult()){
            if (it.data!= null && it.resultCode == 1){
                viewModel.getListaContato()
            }
        }
        binding.buttonNovoContato.setOnClickListener {
            launcher.launch(Intent(applicationContext, NovoContatoActivity::class.java))
        }

    }

    private fun observe() {
        viewModel.listaContato().observe(this, Observer {
            listaContatos = it
            placeAdapter()
        })
    }

    private fun placeAdapter() {
        adapter = ContatoListAdapter(listaContatos, ContatoOnClickListener {
            val i = Intent(this, DetalhesContatoActivity::class.java)
            i.putExtra("id", it.id)
            launcher.launch(i)
        })
        binding.recyclerViewContatos.adapter = adapter
    }
}
