package br.com.vitorotero.module.recyclerview.ui.simplelist.adapter

import android.view.View
import br.com.vitorotero.module.recyclerview.R
import br.com.vitorotero.module.recyclerview.shared.model.Simple
import br.com.vitorotero.module.recyclerview.ui.components.recyclerview.BaseAdapter
import br.com.vitorotero.module.recyclerview.ui.components.recyclerview.BaseViewHolder

class SimpleAdapter : BaseAdapter<Simple>() {

    override fun getLayoutItem(): Int {
        return R.layout.generic_list_item
    }

    override fun setList(list: List<Simple>) {
        setModel(list)
    }

    override fun holder(view: View): BaseViewHolder {
        return SimpleViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if (getModel().isNotEmpty()) {
            (holder as SimpleViewHolder).bind(getModel()[position])
        }
    }

}