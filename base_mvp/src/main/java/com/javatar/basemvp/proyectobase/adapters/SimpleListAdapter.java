package com.javatar.basemvp.proyectobase.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.javatar.basemvp.R;
import com.javatar.basemvp.proyectobase.models.data.DataSimple;

import java.util.ArrayList;

/**
 * Created by Tadeo-developer on 03/08/16.
 */
public class SimpleListAdapter<T> extends AdapterGeneral {
    public SimpleListAdapter(ArrayList objects){super(objects, R.layout.row_simple_card_view);}
    public SimpleListAdapter(ArrayList objects, int layout){super(objects,layout);}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        ViewHolder viewHolder;
        if(viewType==HEADER){
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_header_simple,parent,false);
            viewHolder = new HeaderViewHolder(itemView);
        }else{
            itemView = getViewInflater(parent);
            viewHolder = new SimpleListViewHolder(itemView);
        }

        itemView.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        if(objects.get(position) instanceof DataSimple){
            DataSimple data = (DataSimple)objects.get(position);
            return data.getType();
        }
        return super.getItemViewType(position);
    }

    public class HeaderViewHolder extends ViewHolder {

        private TextView tvTitleHeader;

        public HeaderViewHolder(View itemView) {
            super(itemView);

            tvTitleHeader = (TextView)itemView.findViewById(R.id.tv_title_header);

        }

        @Override
        public void bind(Object obj) {

            if(obj instanceof DataSimple){
                DataSimple objAux = (DataSimple)obj;
                tvTitleHeader.setText(objAux.getLabel());
            }

        }


    }

    public static class SimpleListViewHolder extends ViewHolder {

        private TextView tvEtiqueta;
        private TextView tvValor;

        public SimpleListViewHolder(View itemView) {
            super(itemView);

            tvEtiqueta = (TextView)itemView.findViewById(R.id.tv_etiqueta);
            tvValor = (TextView)itemView.findViewById(R.id.tv_valor);

        }

        @Override
        public void bind(Object obj) {

            if(obj instanceof DataSimple){
                DataSimple objAux = (DataSimple)obj;
                tvEtiqueta.setText(objAux.getLabel());
                if(objAux.getText()==null || objAux.getText().equalsIgnoreCase("null")){
                    tvValor.setText("");
                }else {
                    tvValor.setText(objAux.getText());
                }


            }

        }


    }

}
