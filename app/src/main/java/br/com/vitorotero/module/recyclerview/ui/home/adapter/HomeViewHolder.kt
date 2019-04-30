package br.com.vitorotero.module.recyclerview.ui.home.adapter

import android.view.View
import br.com.vitorotero.module.recyclerview.shared.model.Person
import br.com.vitorotero.module.recyclerview.ui.components.recyclerview.BaseAdapter
import br.com.vitorotero.module.recyclerview.ui.components.recyclerview.BaseViewHolder
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.home_list_item.view.*

class HomeViewHolder(itemView: View, private val adapterListener: BaseAdapter.BaseAdapterListener<Person>) :
    BaseViewHolder(itemView) {

    private val disposables: CompositeDisposable = CompositeDisposable()


    override fun <T> bind(model: T) {
        super.bind(model)

        if (model !is Person && model != null) {
            return
        }

        val item = model as Person

        itemView.glTvName.text = item.name
        adapterListener.notifyPositionItemChanged(item, adapterPosition)
    }

}