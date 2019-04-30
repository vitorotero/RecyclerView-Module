package br.com.vitorotero.module.recyclerview.shared.model

import android.content.res.Resources
import br.com.vitorotero.module.recyclerview.R
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import java.io.Serializable


class Person(
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String
) : Serializable {

    companion object {
        fun getList(resources: Resources): List<Person> {
            val types = object : TypeToken<List<Person>>() {}.type

            val jsonString = resources.openRawResource(R.raw.examplelist).bufferedReader().use { it.readText() }

            return Gson().fromJson(jsonString, types)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }


}