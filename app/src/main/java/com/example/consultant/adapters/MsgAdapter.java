package com.example.consultant.adapters;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.consultant.utils.AsyncImageLoader;
import com.example.consultant.utils.AsyncImageLoader.ImageCallback;
import com.example.consultant.former.PostMessage;
import com.example.consultant.R;
import com.example.consultant.former.ViewCache;

import java.util.List;
import android.app.Activity;
import android.widget.ListView;
//7161315508
public class MsgAdapter extends ArrayAdapter<PostMessage> {

    private ListView listView;
    private AsyncImageLoader asyncImageLoader;

    public MsgAdapter(Activity activity, List<PostMessage> imageAndTexts, ListView listView) {
        super(activity, 0, imageAndTexts);
        this.listView = listView;
        asyncImageLoader = new AsyncImageLoader();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Activity activity = (Activity) getContext();

        // Inflate the views from XML
        View rowView = convertView;
        ViewCache viewCache;
        if (rowView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            rowView = inflater.inflate(R.layout.msg_item, null);
            viewCache = new ViewCache(rowView);
            rowView.setTag(viewCache);
        } else {
            viewCache = (ViewCache) rowView.getTag();
        }
        PostMessage imageAndText = getItem(position);

        // Load the image and set it on the ImageView
        String imageUrl = imageAndText.getPath();
        ImageView imageView = viewCache.getImageView();
        imageView.setTag(imageUrl);
        Drawable cachedImage = asyncImageLoader.loadDrawable(imageUrl, new ImageCallback() {
            public void imageLoaded(Drawable imageDrawable, String imageUrl) {
                ImageView imageViewByTag = (ImageView) listView.findViewWithTag(imageUrl);
                if (imageViewByTag != null) {
                    imageViewByTag.setImageDrawable(imageDrawable);
                }
            }
        });
        if (cachedImage == null) {
            imageView.setImageResource(R.drawable.avatar);
        }else{
            imageView.setImageDrawable(cachedImage);
        }
        // Set the text on the TextView

        TextView tvtitle = viewCache.gettv_title();
        tvtitle.setText(imageAndText.getUserName());
        TextView tvartist = viewCache.gettv_artist();
        tvartist.setText(imageAndText.getTime());
        TextView txcontent = viewCache.gettv_postcontent();
        txcontent.setText(imageAndText.getContent());
        return rowView;
    }
}







