package com.javatar.basemvp.proyectobase.views.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.javatar.basemvp.R;
import com.javatar.basemvp.proyectobase.adapters.SimpleListAdapter;
import com.javatar.basemvp.proyectobase.interfaces.listeners.OnClickListener;
import com.javatar.basemvp.proyectobase.models.data.DataSimple;

import java.util.ArrayList;


/**
 * Created by raul.gonzalez on 28/12/2015.
 */
public class DialogGenericList extends DialogGeneral {


    private ArrayList<DataSimple> data;
    private RecyclerView recycler;
    private SimpleListAdapter<DataSimple> adapter;


    public static DialogGenericList newInstance(String title, ArrayList<DataSimple> data, int numBtn, String nameButtonPositive, String nameButtonNegative, final OnClickListener onClickListener) {

        Bundle args = new Bundle();

        args.putString("title",title);
        args.putSerializable("data",data);
        args.putInt("numBtn",numBtn);
        args.putString("nameButtonPositive",nameButtonPositive);
        args.putString("nameButtonNegative",nameButtonNegative);

        DialogGenericList fragment = new DialogGenericList();
        fragment.setOnClickListener(onClickListener);
        fragment.setArguments(args);
        return fragment;
    }


    public static DialogGenericList newInstance(String title, ArrayList<DataSimple> data, int numBtn, final OnClickListener onClickListener) {
        return newInstance(title,data,numBtn,null,null,onClickListener);
    }



    public static DialogGenericList newInstance(String title, ArrayList<DataSimple> data, int numBtn, String nameButtonPositive, final OnClickListener onClickListener) {
        return newInstance(title,data,numBtn,nameButtonPositive,null,onClickListener);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_generic_list_dialog,container,false);

        return view;
    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {


        super.onViewCreated(view,savedInstanceState);

        Bundle args = getArguments();

        data = (ArrayList<DataSimple>) args.getSerializable("data");

        recycler = (RecyclerView)view.findViewById(R.id.recycler);

        recycler.setHasFixedSize(true);

        adapter = new SimpleListAdapter<>(data);

        recycler.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);

        DividerItemDecoration dividerItemDecorationMenu = new DividerItemDecoration(recycler.getContext(),
                manager.getOrientation());
        //recycler.addItemDecoration(dividerItemDecorationMenu);

        recycler.setItemAnimator(new DefaultItemAnimator());

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

}
