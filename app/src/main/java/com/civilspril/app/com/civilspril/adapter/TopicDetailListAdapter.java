package com.civilspril.app.com.civilspril.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.civilspril.app.R;
import com.civilspril.app.com.civilspril.activities.BaseActivity;
import com.civilspril.app.com.civilspril.fragments.TodaySpiralDetailFragment;

public class TopicDetailListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private String[] topic = {"Political","Social","Enviroment","IR","Science","Culture","Economy","History","Others"};
    private int[] image = {R.drawable.ic_political,R.drawable.ic_social,R.drawable.ic_enviroment,R.drawable.ic_ir,R.drawable.ic_science,R.drawable.ic_culture,R.drawable.ic_economy,R.drawable.ic_history,R.drawable.ic_others};
    private Context context;
    private  View itemView;
    private String data ="\"<p><title>Tenetur est rem provident porro.</title></p><form action=\\\"example.org\\\" method=\\\"POST\\\"><label for=\\\"username\\\">eaque</label><input type=\\\"text\\\" id=\\\"username\\\"><label for=\\\"password\\\">ad</label><input type=\\\"password\\\" id=\\\"password\\\"></form><table><thead><tr><th>Quasi.</th><th>Vitae ea.</th><th>Id et veniam velit est.</th><th>Aliquid autem consequatur qui.</th></tr></thead><tbody><tr><td>Modi autem natus repellat similique aut quia aut.</td><td>Ut ipsam voluptatum iste sapiente eos tempora quia.</td><td>Id cupiditate non sed odit enim necessitatibus.</td><td>Molestias illo magnam.</td></tr><tr><td>Quasi deserunt aut sit ratione aliquid.</td><td>Unde dolor ea deleniti voluptatem eos ipsam ut libero deserunt.</td><td>Aut beatae incidunt occaecati eos ut aut.</td><td>Qui quisquam expedita sed est in quam magnam eos.</td></tr><tr><td>Excepturi minima aut mollitia sed eum ea aut autem vel quod quia.</td><td>Officiis vitae aperiam ducimus odio facilis et mollitia provident ut.</td><td>Qui harum voluptatem dolores nihil repudiandae voluptatibus veniam dignissimos.</td><td>Minus et delectus eos magni eius repellendus quae voluptatem non iure consequuntur.</td></tr><tr><td>Dolorem nemo quia sed nisi facilis eveniet quasi.</td><td>Nesciunt fugit molestias autem et ut nostrum est modi sit.</td><td>Doloribus culpa sit sint nobis et.</td><td>Quo eius ut eligendi et aperiam.</td></tr><tr><td>Saepe reprehenderit aut aperiam nulla ut numquam earum dolores repellat iure repudiandae totam.</td><td>Necessitatibus facere est.</td><td>Et non mollitia sunt mollitia ex ea enim quasi fuga qui quibusdam.</td><td>Molestiae ab nam qui distinctio odio inventore voluptas sint sit ut commodi.</td></tr><tr><td>Dolorem placeat et voluptas consequuntur sed minus et eaque quis.</td><td>Amet provident voluptatem omnis fugit sed quaerat veniam.</td><td>Iure omnis blanditiis hic ullam.</td><td>Sit maiores itaque.</td></tr><tr><td>Rerum in sequi aspernatur.</td><td>Placeat eum quia autem voluptas nihil quae molestiae eum.</td><td>Suscipit ut corporis repellat ipsa asperiores quod debitis.</td><td>Ea natus in.</td></tr><tr><td>Ullam mollitia.</td><td>Enim impedit veritatis error voluptatem deserunt neque perferendis nostrum.</td><td>Quia repudiandae qui et facere accusantium.</td><td>Voluptatum hic qui dolor impedit qui.</td></tr><tr><td>In omnis voluptas est aut et veritatis libero.</td><td>Voluptas quia quisquam aut.</td><td>Iure ut eum numquam culpa aspernatur temporibus.</td><td>Delectus laudantium vero quia.</td></tr></tbody></table>Sunt quasi ea quibusdam error ea praesentium libero voluptatibus sint dignissimos eaque.\"";
    public TopicDetailListAdapter(Context context){
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
         itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.topiv_detail_list_items, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((MyViewHolder)viewHolder).txtview.setText(Html.fromHtml(data));
//        ((MyViewHolder)viewHolder).imageView.setBackgroundResource(image[i]);

    }

    @Override
    public int getItemCount() {
        return topic.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout ll_comment,ll_share;
        TextView txtview;
        public MyViewHolder(View view) {
            super(view);
//            imageView=(ImageView) view.findViewById(R.id.imageView);
            txtview= view.findViewById(R.id.tv_body);
            ll_comment = view.findViewById(R.id.ll_comment);
            ll_share = view.findViewById(R.id.ll_share);
            ll_comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showCustomDialog(context);
                }
            });
            ll_share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String shareBody = "Here is the share content body";
                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                    context.startActivity(Intent.createChooser(sharingIntent, "test"));
                }
            });
        }
    }

    private void showCustomDialog(Context context) {
        //before inflating the custom alert dialog layout, we will get the current activity viewgroup
        ViewGroup viewGroup = itemView.findViewById(android.R.id.content);

        //then we will inflate the custom alert dialog xml that we created
        final View dialogView = LayoutInflater.from(context).inflate(R.layout.comment_box, viewGroup, false);


        //Now we need an AlertDialog.Builder object
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        //setting the view of the builder to our custom view that we already inflated
        builder.setView(dialogView);
       final AlertDialog alertDialog = builder.create();
        Button btn = dialogView.findViewById(R.id.btn_submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        //finally creating the alert dialog and displaying it

        alertDialog.show();
    }
}
