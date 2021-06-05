package xyz.aaronkir.study_android.crazy.chapter02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import xyz.aaronkir.study_android.R;

public class Activity2_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        setContentView(layout);

        TextView show = new TextView(this);

        Button btn = new Button(this);

        btn.setText(R.string.ok);
        btn.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        layout.addView(show);
        layout.addView(btn);

        btn.setOnClickListener((view) -> {
            show.setText("hello, android, " + new java.util.Date());
        });
    }
}