package com.example.consultant.former;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.consultant.R;

public class ViewCache {

    private View baseView;
    private TextView tv_title;
    private TextView tv_artist;
    private TextView tv_postcontent;
    private TextView iv_more;
    private ImageView imageView;

    public ViewCache(View baseView) {
        this.baseView = baseView;
    }

    public TextView gettv_title() {
        if (tv_title == null) {
            tv_title = (TextView) baseView.findViewById(R.id.tv_title);
        }
        return tv_title;
    }
    public TextView gettv_artist() {
        if (tv_artist == null) {
            tv_artist = (TextView) baseView.findViewById(R.id.tv_artist);
        }
        return tv_artist;
    }
    public TextView gettv_postcontent() {
        if (tv_postcontent == null) {
            tv_postcontent = (TextView) baseView.findViewById(R.id.tv_postcontent);
        }
        return tv_postcontent;
    }
    public TextView getiv_more() {
        if (iv_more == null) {
            iv_more = (TextView) baseView.findViewById(R.id.iv_more);
        }
        return iv_more;
    }
    public ImageView getImageView() {
        if (imageView == null) {
            imageView = (ImageView) baseView.findViewById(R.id.iv_cover);
        }
        return imageView;
    }

}