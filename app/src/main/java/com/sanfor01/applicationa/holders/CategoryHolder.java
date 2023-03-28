package com.sanfor01.applicationa.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sanfor01.applicationa.R;

public class CategoryHolder extends RecyclerView.ViewHolder {

    public ImageView catrgoryImage;
    public TextView categoryText;

    public CategoryHolder(@NonNull View itemView) {
        super(itemView);

        catrgoryImage = itemView.findViewById(R.id.categoryImg);
        categoryText = itemView.findViewById(R.id.categoryText);
    }
}
