package com.example.chadi.androideatitserver.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;

import com.example.chadi.androideatitserver.Interface.ItemClickListener;
import com.example.chadi.androideatitserver.R;

public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnCreateContextMenuListener{

    public TextView txtOrderId,txtOrderStatus,txtOrderPhone,txtOrderAddress;
    private ItemClickListener itemClickListener;


   public OrderViewHolder(View itemView){
       super(itemView);
       txtOrderId=itemView.findViewById(R.id.order_id);
       txtOrderStatus=itemView.findViewById(R.id.order_status);
       txtOrderPhone=itemView.findViewById(R.id.order_phone);
       txtOrderAddress=itemView.findViewById(R.id.order_address);
       itemView.setOnClickListener(this);
       itemView.setOnCreateContextMenuListener(this);
   }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
       itemClickListener.onClick(v , getAdapterPosition(),false);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
       menu.setHeaderTitle("Select the Action");

       menu.add(0 , 0 ,getAdapterPosition(),"Delete");
       menu.add(0,1, getAdapterPosition(),"Update");

    }
}
