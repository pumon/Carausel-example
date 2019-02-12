package com.example.android.carouselex;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

/**
 * Created by AizeuBran on 3/6/2018.
 */

public class ItemPageAdapter extends PagerAdapter {
    String url[]={"https://images.pexels.com/photos/33109/fall-autumn-red-season.jpg?h=350&auto=compress&cs=tinysrgb"
    ,"https://images.pexels.com/photos/33045/lion-wild-africa-african.jpg?h=350&auto=compress&cs=tinysrgb"
    ,"https://images.pexels.com/photos/7919/pexels-photo.jpg?h=350&auto=compress&cs=tinysrgb"
    ,"https://images.pexels.com/photos/7653/pexels-photo.jpeg?h=350&auto=compress&cs=tinysrgb"
    ,"https://img.etimg.com/thumb/msid-62595091,width-300,imgsize-60639,resizemode-4/untitled-8.jpg"
    ,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQNOI-iQEhcOJ5QQbjAnpt0qUWJYnJfWdtHMAKmxfMntw_9h-Q_jw"};
    private Context context;
    @Override
    public int getCount() {
        return url.length;
    }

    public ItemPageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(ConstraintLayout)object);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.display_item,container,false);
        LinearLayout linearLayout=(LinearLayout)view.findViewById(R.id.linearLayout);
        ImageView imageView=(ImageView) linearLayout.findViewById(R.id.imageview);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        Picasso.with(context).load(url[position]).into(imageView);
        linearLayout.setBackgroundColor(R.color.colorPrimary);
        linearLayout.setGravity(Gravity.CENTER);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(linearLayout.getLayoutParams());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
