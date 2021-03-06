package com.example.administrator.nothing_kotlin.utils.glide_utils

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import okhttp3.OkHttpClient
import java.io.InputStream

@GlideModule
class MyGlideModule : com.bumptech.glide.module.GlideModule {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
    }

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        var builder = OkHttpClient.Builder()
        builder.addInterceptor(ProgressInterceptor())
        val build = builder.build()
        registry.replace(GlideUrl::class.java , InputStream::class.java , OkHttpUrlLoader.Factory(build))
    }
}