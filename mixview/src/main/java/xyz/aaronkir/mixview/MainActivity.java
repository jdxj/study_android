package xyz.aaronkir.mixview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private int[] images = new int[]{R.drawable.img1, R.drawable.img2};
    private int currentImg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout main = findViewById(R.id.root);
        ImageView image = new ImageView(this);

        main.addView(image);

        image.setImageResource(images[0]);
        image.setOnClickListener(view -> {
            image.setImageResource(images[++currentImg % images.length]);
        });
    }
}