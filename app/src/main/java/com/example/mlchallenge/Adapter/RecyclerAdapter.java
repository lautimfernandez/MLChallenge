package com.example.mlchallenge.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mlchallenge.Model.Product;
import com.example.mlchallenge.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ResultsViewHolder> {

    final private ItemCLick onClickListener;
    private List<Product> listItems;


    public RecyclerAdapter(List<Product> items, ItemCLick listener) {
        listItems = items;
        onClickListener = listener;
    }

    public void setData(List<Product> products) {
        listItems = products;
    }

    @NonNull
    @Override
    public ResultsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final Context mContext = parent.getContext();
        int layoutIdItem = R.layout.product_row;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        boolean attach = false;
        View view = inflater.inflate(layoutIdItem, parent, attach);
        ResultsViewHolder viewHolder = new ResultsViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResultsViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    /**
     * This interface was created to get the product on item click of the recycler view
     */
    public interface ItemCLick {
        void onItemClick(Product product);
    }

    class ResultsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView nameResult;
        TextView priceResult;
        ImageView imageResult;

        public ResultsViewHolder(@NonNull View itemView) {
            super(itemView);
            nameResult = itemView.findViewById(R.id.nameResult);
            priceResult = itemView.findViewById(R.id.priceResult);
            imageResult = itemView.findViewById(R.id.imageProduct);


            itemView.setOnClickListener(this);

        }

        void bind(int listIndex) {
            Product product = listItems.get(listIndex);
            nameResult.setText(product.getTitle());
            priceResult.setText("$" + product.getPriceFormated());
            Glide.with(itemView.getContext())
                    .load(product.getThumbnail())
                    .into(imageResult);
        }

        @Override
        public void onClick(View v) {
            int clickedItem = getAdapterPosition();
            onClickListener.onItemClick(listItems.get(clickedItem));
        }
    }

}
