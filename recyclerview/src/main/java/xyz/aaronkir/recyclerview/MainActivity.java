package xyz.aaronkir.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imgs);

        List<String> fruitList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            fruitList.add(""+i);
        }

        RecyclerView recyclerView = findViewById(R.id.rv);
        if (recyclerView == null) {
            Log.d(TAG, "onCreate: abc");
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ImgAdapter adapter = new ImgAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new ImgsScrollListener());
    }
}