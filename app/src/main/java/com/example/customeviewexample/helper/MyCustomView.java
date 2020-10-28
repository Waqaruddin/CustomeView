package com.example.customeviewexample.helper;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.customeviewexample.R;

public class MyCustomView extends LinearLayout {

    TextView textView;
    ImageView imageView;
    EditText editText;
    CheckBox checkBox;

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        inflate(context, R.layout.my_custom_view, this);

//        imageView = findViewById(R.id.image_view);
//        textView = findViewById(R.id.text_view);

        editText = findViewById(R.id.edit_text_password);
        checkBox = findViewById(R.id.check_box);

        TypedArray attribute = context.obtainStyledAttributes(attrs, R.styleable.MyCustomView);

       // imageView.setImageDrawable(attribute.getDrawable(R.styleable.MyCustomView_image));
       // textView.setText(attribute.getString(R.styleable.MyCustomView_text));
        editText.setText(attribute.getString(R.styleable.MyCustomView_password));
        checkBox.setText(attribute.getString(R.styleable.MyCustomView_checkBox));
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        attribute.recycle();

    }
}
