package com.googlejobapp.u2020.data.api.model

/**
 * Created by joeyt on 3/1/15.
 */
public data class Image(val id: String,
                        val link: String,
                        val title: String,
                        val width: Int,
                        val height: Int,
                        val datetime: Long,
                        val views: Int,
                        val isAlbum: Boolean)