package br.com.vitorotero.module.recyclerview.ui.home.adapter

import android.view.View
import br.com.vitorotero.module.recyclerview.R
import br.com.vitorotero.module.recyclerview.shared.model.Person
import br.com.vitorotero.module.recyclerview.ui.components.recyclerview.BaseAdapter
import br.com.vitorotero.module.recyclerview.ui.components.recyclerview.BaseViewHolder

class HomeAdapter(clickListener: BaseViewHolderClickListener<Person>) : BaseAdapter<Person>(clickListener),
    BaseAdapter.BaseAdapterListener<Person> {

    override fun getLayoutItem(): Int {
        return R.layout.home_list_item
    }

    override fun setList(list: MutableList<Person>) {
        model = list
    }

    override fun holder(view: View): BaseViewHolder {
        return HomeViewHolder(view, this)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if (model.isNotEmpty()) {
            (holder as HomeViewHolder).bind(model[position])
        }
    }

    override fun notifyPositionItemChanged(item: Person, position: Int) {
        model.removeAt(position)
        notifyItemRemoved(position)
    }

}