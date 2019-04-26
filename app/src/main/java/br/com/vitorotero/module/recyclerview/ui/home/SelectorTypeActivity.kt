package br.com.vitorotero.module.recyclerview.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.vitorotero.module.recyclerview.R
import br.com.vitorotero.module.recyclerview.ui.simplelist.SimpleListActivity
import kotlinx.android.synthetic.main.selector_type_screen.*

class SelectorTypeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.selector_type_screen)

        setupView()
    }

    private fun setupView() {
        btnSimpleList.setOnClickListener {
            startActivity(SimpleListActivity.getIntent(this))
        }

        btnClickListenerList.setOnClickListener {

        }

        btnLongListenerList.setOnClickListener {

        }
    }
}
