package br.com.vitorotero.module.recyclerview.ui.components.recyclerview

import android.view.View
import br.com.vitorotero.module.recyclerview.ui.components.emptylist.EmptyObject
import br.com.vitorotero.module.recyclerview.ui.components.emptylist.EmptyObject.Companion.ICON_RESOURCE_ZERO

class EmptyViewHolder(itemView: View, emptyObject: EmptyObject) : BaseViewHolder(itemView) {

    init {
        bind(emptyObject)
    }

    override fun <T> bind(model: T) {

        if (model !is EmptyObject && model == null) {
            return
        }

        cptBtnEmptyList.setVisibility(View.GONE)

        val emptyObject = model as EmptyObject?
        if (ICON_RESOURCE_ZERO !== emptyObject.icon) {
            cptIvEmptyList.setImageResource(emptyObject!!.getIcon())
        }

        if (emptyObject.message != null && emptyObject.message != ICON_RESOURCE_ZERO) {
            cptTextEmptyList.setText(emptyObject.getMessage())
        }

        if (emptyObject.getButtonText() != null) {
            cptBtnEmptyList.setText(emptyObject.getButtonText())
        }

        if (emptyObject.getListener() != null) {
            cptBtnEmptyList.setOnClickListener(emptyObject.getListener())
            cptBtnEmptyList.setVisibility(View.VISIBLE)
        }

        if (emptyObject.getLayoutListener() != null) {
            llEmptyList.setOnClickListener(emptyObject.getLayoutListener())
        }

    }

}