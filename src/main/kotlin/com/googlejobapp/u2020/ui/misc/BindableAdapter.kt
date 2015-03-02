package com.googlejobapp.u2020.ui.misc

import android.widget.BaseAdapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by joeyt on 3/1/15.
 */
abstract class BindableAdapter<T>(private val context: Context) : BaseAdapter() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override abstract fun getItem(position: Int): T

    abstract fun newView(inflater: LayoutInflater, position: Int, parent: ViewGroup?): View

    abstract fun bindView(item: T, position: Int, view: View)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: newView(inflater, position, parent)
        bindView(getItem(position), position, view)
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: newDropDownView(inflater, position, parent)
        bindDropDownView(getItem(position), position, view)
        return view
    }

    /** Create a new instance of a drop-down view for the specified position. */
    public fun newDropDownView(inflater: LayoutInflater, position: Int, parent: ViewGroup?): View {
        return newView(inflater, position, parent)
    }

    /** Bind the data for the specified {@code position} to the drop-down view. */
    public fun bindDropDownView(item: T, position: Int, view: View) {
        bindView(item, position, view)
    }
}