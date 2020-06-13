package com.jasjotsingh.multiplespannabletextviews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SpannableString ss;
    TextView tvSpan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvSpan = findViewById(R.id.tvSpan);

        ss = new SpannableString("By continuing you agree to Terms of Service and Privacy Policy");

        ss.setSpan(new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Toast.makeText(MainActivity.this,"You clicked Terms of Service",Toast.LENGTH_SHORT).show();
            }
        },26,43, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        ss.setSpan(new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Toast.makeText(MainActivity.this,"You clicked Privacy Policy",Toast.LENGTH_SHORT).show();
            }
        },47,62,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tvSpan.setText(ss);
        tvSpan.setMovementMethod(LinkMovementMethod.getInstance());
    }
}