package com.emrekose.karchi.binding

import android.databinding.BindingAdapter
import com.emrekose.karchi.R
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

/**
 * Created by emrekose on 17.12.2017.
 */
object ImageBindingAdapter{

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(imageView: CircleImageView?, url: String?) {
        if (url != null && !url.equals("")) Picasso.with(imageView?.context).load(url).placeholder(R.mipmap.ic_launcher).into(imageView)
    }

}