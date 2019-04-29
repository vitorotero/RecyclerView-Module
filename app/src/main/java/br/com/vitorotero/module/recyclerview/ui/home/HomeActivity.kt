package br.com.vitorotero.module.recyclerview.ui.home

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.vitorotero.module.recyclerview.R
import br.com.vitorotero.module.recyclerview.shared.model.Person
import br.com.vitorotero.module.recyclerview.ui.components.recyclerview.BaseAdapter
import br.com.vitorotero.module.recyclerview.ui.components.recyclerview.emptylist.EmptyObject
import br.com.vitorotero.module.recyclerview.ui.home.adapter.HomeAdapter
import kotlinx.android.synthetic.main.home_screen.*

class HomeActivity : AppCompatActivity(), BaseAdapter.BaseViewHolderClickListener<Person> {

    lateinit var adapter: HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen)

        setupView()
        setupRecyclerView()

        object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                adapter.setList(Person.getList(resources).toMutableList())
            }

        }.start()
    }

    override fun onClickListener(item: Person, view: View) {
        Toast.makeText(this, item.name, Toast.LENGTH_SHORT)
            .show()
    }

    private fun setupView() {
        adapter = HomeAdapter(this)
        adapter.emptyObject = EmptyObject("Tentar Novamente", View.OnClickListener {
            Toast.makeText(this, "Clicou em tentar novamente", Toast.LENGTH_SHORT)
                .show()
        })
    }

    private fun setupRecyclerView() {
        rvSimpleList.layoutManager = LinearLayoutManager(this)
        rvSimpleList.setHasFixedSize(false)
        rvSimpleList.adapter = adapter
    }

}
