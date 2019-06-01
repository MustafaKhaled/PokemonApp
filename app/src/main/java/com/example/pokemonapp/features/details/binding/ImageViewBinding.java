package com.example.pokemonapp.features.details.binding;

import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public class ImageViewBinding {
    @BindingAdapter("android:imgsrc")
    public static void imageResource(ImageView imageView, String url) {
        if (url != null) {
            imageView.setVisibility(View.VISIBLE);
            Picasso.with(imageView.getContext()).load(url).into(imageView);
        } else
            imageView.setVisibility(View.GONE);
    }
}
