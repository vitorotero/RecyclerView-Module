package br.com.vitorotero.module.recyclerview.ui.components.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import br.com.vitorotero.module.recyclerview.R
import br.com.vitorotero.module.recyclerview.ui.components.recyclerview.emptylist.EmptyObject
import br.com.vitorotero.module.recyclerview.ui.components.recyclerview.emptylist.EmptyViewHolder
import java.util.*

abstract class BaseAdapter<V> : RecyclerView.Adapter<BaseViewHolder> {

    protected var adapterListener: BaseAdapterListener<V>? = null
    protected var clickListener: BaseViewHolderClickListener<V>? = null
    protected var longClickListener: BaseViewHolderLongClickListener<V>? = null
    private var model: List<V> = ArrayList()
    private var emptyObject: EmptyObject = EmptyObject(R.string.empty_list_message, R.mipmap.ic_launcher)

    constructor() {
        adapterListener = null
        clickListener = null
        longClickListener = null
    }

    constructor(adapterListener: BaseAdapterListener<V>) {
        this.adapterListener = adapterListener
    }

    constructor(clickListener: BaseViewHolderClickListener<V>) {
        this.clickListener = clickListener
    }

    constructor(longClickListener: BaseViewHolderLongClickListener<V>) {
        this.longClickListener = longClickListener
    }

    constructor(
        clickListener: BaseViewHolderClickListener<V>,
        longClickListener: BaseViewHolderLongClickListener<V>
    ) {
        this.clickListener = clickListener
        this.longClickListener = longClickListener
    }

    protected fun getModel(): List<V> {
        return model
    }

    protected fun setModel(model: List<V>) {
        this.model = model
        notifyDataSetChanged()
    }

    fun setEmptyObject(@NonNull emptyObject: EmptyObject) {
        this.emptyObject = emptyObject
    }

    abstract fun setList(list: List<V>)

    abstract fun holder(view: View): BaseViewHolder

    @LayoutRes
    abstract fun getLayoutItem(): Int

    override fun getItemCount(): Int {
        return if (model.isEmpty()) {
            MINIMUM_EMPTY_LIST
        } else model.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (model.isEmpty()) {
            VIEW_TYPE_EMPTY
        } else super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(getLayoutItem(), parent, false)

        if (VIEW_TYPE_EMPTY == viewType) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.empty_list_component, parent, false)
            return EmptyViewHolder(view, emptyObject)
        }

        return holder(view)
    }

    interface BaseAdapterListener<V> {
        fun notifyPositionItemChanged(v: V, position: Int)
    }

    interface BaseViewHolderClickListener<V> {
        fun onClickListener(v: V, view: View)
    }

    interface BaseViewHolderLongClickListener<V> {
        fun onLongClickListener(v: V, view: View)
    }

    companion object {
        private const val VIEW_TYPE_EMPTY = 1000
        private const val MINIMUM_EMPTY_LIST = 1
    }

}