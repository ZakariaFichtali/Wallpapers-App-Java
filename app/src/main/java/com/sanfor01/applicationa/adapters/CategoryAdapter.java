package com.sanfor01.applicationa.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sanfor01.applicationa.R;
import com.sanfor01.applicationa.holders.CategoryHolder;
import com.sanfor01.applicationa.model.CategoryModel;
import com.sanfor01.applicationa.utils.Constants;

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    public CategoryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_model, parent, false);
        return new CategoryHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CategoryModel categoryModel = Constants.categoryModelList.get(0);

        CategoryHolder categoryHolder = (CategoryHolder) holder;
        categoryHolder.categoryText.setText(categoryModel.getName());

        Glide.with(context).load(categoryModel.getImage())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(categoryHolder.catrgoryImage);
    }

    @Override
    public int getItemCount() {
        return Constants.categoryModelList.size();
    }
}
