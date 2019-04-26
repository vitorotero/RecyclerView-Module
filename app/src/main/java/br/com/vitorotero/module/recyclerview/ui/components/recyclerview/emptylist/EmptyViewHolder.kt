package br.com.vitorotero.module.recyclerview.ui.components.recyclerview.emptylist

import android.view.View
import br.com.vitorotero.module.recyclerview.ui.components.recyclerview.emptylist.EmptyObject.Companion.ICON_RESOURCE_ZERO
import br.com.vitorotero.module.recyclerview.ui.components.recyclerview.BaseViewHolder
import kotlinx.android.synthetic.main.empty_list_component.view.*

class EmptyViewHolder(itemView: View, emptyObject: EmptyObject) : BaseViewHolder(itemView) {

    init {
        bind(emptyObject)
    }

    override fun <T> bind(model: T) {

        if (model !is EmptyObject && model != null) {
            return
        }

        val emptyObject = model as EmptyObject

        itemView.cptBtnEmptyList.visibility = View.GONE

        if (ICON_RESOURCE_ZERO != emptyObject.icon) {
            itemView.cptIvEmptyList.setImageResource(emptyObject.icon)
        }

        if (ICON_RESOURCE_ZERO != emptyObject.message) {
            itemView.cptTextEmptyList.setText(emptyObject.message)
        }

        if (!emptyObject.buttonText.isEmpty()) {
            itemView.cptBtnEmptyList.text = emptyObject.buttonText
        }

        emptyObject.listener?.let {
            itemView.cptBtnEmptyList.setOnClickListener(it)
            itemView.cptBtnEmptyList.visibility = View.VISIBLE
        }

        emptyObject.layoutListener?.let {
            itemView.llEmptyList.setOnClickListener(it)
        }

    }

}