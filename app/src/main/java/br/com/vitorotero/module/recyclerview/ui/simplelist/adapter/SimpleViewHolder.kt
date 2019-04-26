package br.com.vitorotero.module.recyclerview.ui.simplelist.adapter

import android.view.View
import br.com.vitorotero.module.recyclerview.shared.model.Simple
import br.com.vitorotero.module.recyclerview.ui.components.recyclerview.BaseViewHolder
import kotlinx.android.synthetic.main.generic_list_item.view.*

class SimpleViewHolder(itemView: View) : BaseViewHolder(itemView) {

    override fun <T> bind(model: T) {
        super.bind(model)

        if (model !is Simple && model != null) {
            return
        }

        val item = model as Simple

        itemView.glTvName.text = item.name

    }

}