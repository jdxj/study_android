package xyz.aaronkir.recyclerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ImgAdapter extends RecyclerView.Adapter<ImgViewHolder> {
    List<String> data;

    public ImgAdapter() {
        data = new ArrayList<String>();
        data.add("0");
    }

    @Override
    public ImgViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.img_item, parent, false);
        ImgViewHolder vh = new ImgViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ImgViewHolder holder, int position) {
        holder.title.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void AddData(String d) {
        data.add(d);
    }
}

class ImgViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    public ImgViewHolder(View view) {
        super(view);

        title = view.findViewById(R.id.title);
    }
}

class ImgsScrollListener extends RecyclerView.OnScrollListener {
    private static final String TAG = "ImgsScrollListener";
    private int position = 1;
    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        if (!recyclerView.canScrollVertically(-1)) {
            ImgAdapter adapter = (ImgAdapter) recyclerView.getAdapter();
            adapter.AddData(""+position);
            adapter.notifyItemInserted(position);
            ++position;
            Log.d(TAG, "onScrolled: add data");
        }
    }
}