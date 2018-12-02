package com.javatar.basemvp.proyectobase.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Tadeo-developer on 18/01/16.
 */
public abstract class AdapterGeneral<T> extends RecyclerView.Adapter<AdapterGeneral.ViewHolder> implements View.OnClickListener {

        public static int HEADER = 1;
        private View.OnClickListener listener;
        protected ArrayList<T> objects;
        private int layout;


        public AdapterGeneral(ArrayList<T> objects, int layout){

                this.objects = objects;
                this.layout = layout;

        }

        @Override
        public abstract ViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

                holder.bind(objects.get(position));

        }

        @Override
        public int getItemCount() {
                return objects.size();
        }

        public void setOnClickListener(View.OnClickListener onClickListener){
                listener = onClickListener;
        }

        @Override
        public void onClick(View view) {
                if(listener!=null)
                        listener.onClick(view);
        }

        public int getLayout(){
                return this.layout;
        }

        public View getViewInflater(ViewGroup parent){
                return LayoutInflater.from(parent.getContext()).inflate(getLayout(),parent,false);
        }

        public static abstract class ViewHolder<T> extends RecyclerView.ViewHolder {

                public ViewHolder(View itemView) {
                        super(itemView);
                }


                public abstract void bind(T obj);
        }
}
