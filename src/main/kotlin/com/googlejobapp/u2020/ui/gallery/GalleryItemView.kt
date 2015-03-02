package com.googlejobapp.u2020.ui.gallery

import android.widget.FrameLayout
import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import com.jakewharton.u2020.R
import com.googlejobapp.u2020.util.bindView
import android.widget.ImageView
import com.squareup.picasso.RequestCreator
import com.squareup.picasso.Picasso
import com.googlejobapp.u2020.data.api.model.Image
import android.view.View
import android.view.View.MeasureSpec

/**
 * Created by joeyt on 3/1/15.
 */
class GalleryItemView(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {
    val title: TextView by bindView(R.id.gallery_image_title)
    val image: ImageView by bindView(R.id.gallery_image_image)

    private var aspectRatio: Float = 1F
    private var request: RequestCreator? = null

    fun bindTo(item: Image, picasso: Picasso) {
        request = picasso.load(item.link)
        aspectRatio = 1F * item.width / item.height
        requestLayout()
        title.setText(item.title)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val mode = MeasureSpec.getMode(widthMeasureSpec)
        if (mode != MeasureSpec.EXACTLY) {
            throw IllegalStateException("layout_width must be match_parent")
        }
        val width = MeasureSpec.getSize(widthMeasureSpec)
        // Honor aspect ratio for height but no larger than 2x width.
        val height = Math.min((width/aspectRatio) as Int, width * 2)
        val heightMs = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY)
        super.onMeasure(widthMeasureSpec, heightMs)

        val currRequest = request
        if (currRequest != null) {
            currRequest.resize(width, height).centerCrop().into(image)
            request = null
        }
    }
}