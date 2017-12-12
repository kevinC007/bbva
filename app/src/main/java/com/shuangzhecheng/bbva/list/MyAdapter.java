package com.shuangzhecheng.bbva.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.shuangzhecheng.bbva.R;
import com.shuangzhecheng.bbva.data.ResultsItem;

import java.util.ArrayList;

/**
 * Created by Jinming on 12/11/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context mContext;
    ArrayList<ResultsItem> resultsItemsArrayList;

    public MyAdapter(Context context, ArrayList<ResultsItem> list) {
        this.mContext = context;
        this.resultsItemsArrayList = list;
    }
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_location, parent, false);
        MyAdapter.MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ResultsItem resultsItem = resultsItemsArrayList.get(position);
        holder.mID.setText(resultsItem.getId());
        holder.mName.setText(resultsItem.getName());
        holder.mAddress.setText(resultsItem.getFormattedAddress());

        /*holder.mDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("pos", position);
                DetailsFragment detailsFragment = new DetailsFragment();
                detailsFragment.setArguments(bundle);
                ((AppCompatActivity)mContext)
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.container, new DetailsFragment()).commit();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return resultsItemsArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mID, mName, mAddress;
        Button mDetails;


        public MyViewHolder(View itemView) {
            super(itemView);
            mID = (TextView) itemView.findViewById(R.id.id);
            mName = (TextView) itemView.findViewById(R.id.name);
            mAddress = (TextView) itemView.findViewById(R.id.address);
            mDetails = (Button) itemView.findViewById(R.id.details);
        }
    }
}
