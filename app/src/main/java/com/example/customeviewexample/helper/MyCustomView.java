package com.example.customeviewexample.helper;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.customeviewexample.R;

public class MyCustomView extends LinearLayout {

    TextView textView;
    ImageView imageView;
    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        inflate(context, R.layout.my_custom_view, this);

        imageView = findViewById(R.id.image_view);
        textView = findViewById(R.id.text_view);

       TypedArray attribute =  context.obtainStyledAttributes(attrs , R.styleable.MyCustomView);

       imageView.setImageDrawable(attribute.getDrawable(R.styleable.MyCustomView_image));
       textView.setText(attribute.getString(R.styleable.MyCustomView_text));
       attribute.recycle();

    }
}
