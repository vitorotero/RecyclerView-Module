package br.com.vitorotero.module.recyclerview.ui.components.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    open fun <T> bind(model: T) {}

}