package com.googlejobapp.u2020.ui.gallery

import com.googlejobapp.u2020.ui.misc.BindableAdapter
import com.googlejobapp.u2020.data.api.model.Image
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import com.squareup.picasso.Picasso
import com.jakewharton.u2020.R

/**
 * Created by joeyt on 3/1/15.
 */
class GalleryAdapter(context: Context, private val picasso: Picasso) : BindableAdapter<Image>(context) {
    private var images: List<Image> = listOf()

    fun replaceWith(images: List<Image>) {
        this.images = images
        notifyDataSetChanged()
    }

    override fun getCount(): Int = images.size()

    override fun getItem(position: Int): Image = images.get(position)

    override fun getItemId(position: Int): Long = position.toLong()

    override fun newView(inflater: LayoutInflater, position: Int, parent: ViewGroup?): View {
        return inflater.inflate(R.layout.gallery_view_image, parent, false)
    }

    override fun bindView(item: Image, position: Int, view: View) {
        (view as GalleryItemView).bindTo(item, picasso)
    }

}