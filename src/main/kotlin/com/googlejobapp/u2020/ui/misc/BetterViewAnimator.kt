package com.googlejobapp.u2020.ui.misc

import android.widget.ViewAnimator
import android.util.AttributeSet
import android.content.Context

/**
 * Created by joeyt on 3/1/15.
 */
open class BetterViewAnimator(context: Context, attrs: AttributeSet) : ViewAnimator(context, attrs) {
    var displayedChildId: Int
        get() = getChildAt(getDisplayedChild()).getId()
        set(id) {
            if (displayedChildId == id) {
                return
            }
            val count = getChildCount()
            for (i in 0..count-1) {
                if (getChildAt(i).getId() == id) {
                    setDisplayedChild(i)
                    return
                }
            }
            throw IllegalArgumentException("No view with ID $id")
        }
}