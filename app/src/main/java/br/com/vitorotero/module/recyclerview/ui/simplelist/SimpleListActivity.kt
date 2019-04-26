package br.com.vitorotero.module.recyclerview.ui.simplelist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.vitorotero.module.recyclerview.R
import br.com.vitorotero.module.recyclerview.shared.model.Simple
import br.com.vitorotero.module.recyclerview.ui.simplelist.adapter.SimpleAdapter
import kotlinx.android.synthetic.main.simple_list_screen.*


class SimpleListActivity : AppCompatActivity() {

    lateinit var adapter: SimpleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.simple_list_screen)

        setupView()
        setupRecyclerView()

        object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                adapter.setList(Simple.getList(resources))
            }

        }.start()
    }

    private fun setupView() {
        adapter = SimpleAdapter()
    }

    private fun setupRecyclerView() {
        rvSimpleList.layoutManager = LinearLayoutManager(this)
        rvSimpleList.setHasFixedSize(false)
        rvSimpleList.adapter = adapter
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, SimpleListActivity::class.java)
        }
    }

}
