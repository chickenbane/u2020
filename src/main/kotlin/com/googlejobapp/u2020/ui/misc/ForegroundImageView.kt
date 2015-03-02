package com.googlejobapp.u2020.ui.misc

import android.widget.ImageView
import android.util.AttributeSet
import android.content.Context
import com.jakewharton.u2020.R
import android.graphics.drawable.Drawable
import android.graphics.Canvas

/**
 * Created by joeyt on 3/1/15.
 */
class ForegroundImageView(context: Context, attrs: AttributeSet? = null) : ImageView(context, attrs) {
    private var foreground: Drawable? = null
        set(drawable: Drawable?) {
            val curr = foreground
            if (curr == drawable) {
                return
            }
            if (curr != null) {
                curr.setCallback(null)
                unscheduleDrawable(curr)
            }
            $foreground = drawable
            if (drawable != null) {
                drawable.setCallback(this)
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState())
                }
            }
            requestLayout()
            invalidate()
        }

    {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ForegroundImageView)
        val fg = typedArray.getDrawable(R.styleable.ForegroundImageView_android_foreground)
        if (fg != null) {
            foreground = fg
        }
        typedArray.recycle()
    }

    fun setForeground(drawableResId: Int): Unit {
        foreground = getContext().getResources().getDrawable(drawableResId)
    }

    override fun verifyDrawable(who: Drawable?): Boolean {
        return super.verifyDrawable(who) || foreground == who
    }

    override fun jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState()
        foreground?.jumpToCurrentState()
    }

    override fun drawableStateChanged() {
        super.drawableStateChanged()
        val currFg = foreground
        if (currFg != null && currFg.isStateful()) {
            currFg.setState(getDrawableState())
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val currFg = foreground
        if (currFg != null) {
            currFg.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight())
            invalidate()
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        val currFg = foreground
        if (currFg != null) {
            currFg.setBounds(0, 0, w, h)
            invalidate()
        }
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        foreground?.draw(canvas)
    }
}