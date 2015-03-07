package com.googlejobapp.u2020.data.api.model

/**
 * Created by joeyt on 3/7/15.
 */
data class Gallery(status: Int, success: Boolean, val data: List<Image>) : ImgurResponse(status, success)