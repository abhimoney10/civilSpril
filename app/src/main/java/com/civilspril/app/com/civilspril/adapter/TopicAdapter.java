package com.civilspril.app.com.civilspril.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.civilspril.app.R;
import com.civilspril.app.com.civilspril.activities.BaseActivity;
import com.civilspril.app.com.civilspril.activities.CategoryDetails;
import com.civilspril.app.com.civilspril.beans.Categories;
import com.civilspril.app.com.civilspril.beans.CategoryList;
import com.civilspril.app.com.civilspril.fragments.TodaySpiralDetailFragment;
import com.civilspril.app.com.civilspril.fragments.TodaySpiralFragment;

import java.util.ArrayList;

public class TopicAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private String[] topic = {"Political","Social","Enviroment","IR","Science","Culture","Economy","History","Others"};
    private int[] image = {R.drawable.ic_political,R.drawable.ic_social,R.drawable.ic_enviroment,R.drawable.ic_ir,R.drawable.ic_science,R.drawable.ic_culture,R.drawable.ic_economy,R.drawable.ic_history,R.drawable.ic_others};
    private Context context;
    private ArrayList<Categories> mCategoryList;
    public TopicAdapter(Context context, ArrayList<Categories> mCategoryList){
        this.context = context;
        this.mCategoryList = mCategoryList;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_icon, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        ((MyViewHolder)viewHolder).txtview.setText(mCategoryList.get(i).getName());
        ((MyViewHolder)viewHolder).imageView.setBackgroundResource(image[i]);

    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView txtview;
        public MyViewHolder(View view) {
            super(view);
            imageView=(ImageView) view.findViewById(R.id.imageView);
            txtview=(TextView) view.findViewById(R.id.textView);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                            Intent intent = new Intent(context,CategoryDetails.class);
                            intent.putExtra(CategoryDetails.NAME, txtview.getText());
                    context.startActivity(intent);
//                    TodaySpiralDetailFragment fragment = new TodaySpiralDetailFragment();
//                    fragment.setTitle(txtview.getText().toString());
//                    ((BaseActivity)context).addFragment(fragment,"todaySpiral" );
                }
            });
        }
    }
}
