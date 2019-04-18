package br.com.vitorotero.module.recyclerview.ui.components.emptylist

import android.view.View
import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.Nullable

class EmptyObject {

    companion object {
        const val ICON_RESOURCE_ZERO = 0
    }

    @IntegerRes
    var message: Int? = null
    var icon: Int = 0
    var buttonText: String? = null
    var listener: View.OnClickListener? = null
    var layoutListener: View.OnClickListener? = null

    constructor(message: Int, @DrawableRes icon: Int) {
        this.message = message
        this.icon = icon
    }

    constructor(message: Int, @DrawableRes icon: Int, @Nullable layoutListener: View.OnClickListener) {
        this.message = message
        this.icon = icon
        this.layoutListener = layoutListener
    }

    constructor(
        @IntegerRes message: Int, @DrawableRes icon: Int, @Nullable layoutListener: View.OnClickListener,
        @Nullable buttonText: String, @Nullable listener: View.OnClickListener
    ) {
        this.message = message
        this.icon = icon
        this.buttonText = buttonText
        this.listener = listener
        this.layoutListener = layoutListener
    }

    constructor(@Nullable buttonText: String, @Nullable listener: View.OnClickListener) {
        this.buttonText = buttonText
        this.listener = listener
    }

}