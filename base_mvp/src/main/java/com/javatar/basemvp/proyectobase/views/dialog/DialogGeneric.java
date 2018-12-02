package com.javatar.basemvp.proyectobase.views.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.javatar.basemvp.R;
import com.javatar.basemvp.proyectobase.helpers.Utils;
import com.javatar.basemvp.proyectobase.interfaces.listeners.OnClickListener;


/**
 * Created by raul.gonzalez on 28/12/2015.
 */
public class DialogGeneric extends DialogGeneral {


    private String description;
    private String detail;

    private TextView tvDescription;
    private ImageView fbDetail;
    private TextView tvDetail;
    private boolean showDetalle;

    public static DialogGeneric newInstance(String title, String description, String detail, int numBtn, String nameButtonPositive, String nameButtonNegative, final OnClickListener onClickListener) {

        Bundle args = new Bundle();

        args.putString("title",title);
        args.putString("description",description);
        args.putInt("numBtn",numBtn);
        args.putString("detail",detail);
        args.putString("nameButtonPositive",nameButtonPositive);
        args.putString("nameButtonNegative",nameButtonNegative);

        DialogGeneric fragment = new DialogGeneric();
        fragment.setOnClickListener(onClickListener);
        fragment.setArguments(args);
        return fragment;
    }


    public static DialogGeneric newInstance(String title, String description, String detail, int numBtn, final OnClickListener onClickListener) {
        return newInstance(title,description,detail,numBtn,null,null,onClickListener);
    }



    public static DialogGeneric newInstance(String title, String description, String detail, int numBtn, String nameButtonPositive, final OnClickListener onClickListener) {
        return newInstance(title,description,detail,numBtn,nameButtonPositive,null,onClickListener);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_generic_dialog,container,false);

        return view;
    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        super.onViewCreated(view,savedInstanceState);

        Bundle args = getArguments();

        description = args.getString("description");
        detail = args.getString("detail");


        tvDescription = (TextView)view.findViewById(R.id.tv_description);
        fbDetail = (ImageView)view.findViewById(R.id.fb_detail);
        tvDetail = (TextView)view.findViewById(R.id.tv_detail);

        tvDescription.setText(description);
        tvDetail.setVisibility(View.GONE);
        if(detail==null || detail.isEmpty()){
            fbDetail.setVisibility(View.GONE);
        }else {


            fbDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(showDetalle){
                        tvDetail.setVisibility(View.GONE);
                        Utils.spinView(fbDetail, 180f, 0f, R.drawable.plus);

                        showDetalle = false;
                    }else{
                        tvDetail.setVisibility(View.VISIBLE);
                        tvDetail.setText(detail);
                        Utils.spinView(fbDetail, 180f, 0f, R.drawable.minus);
                        showDetalle = true;
                    }
                }
            });
        }


    }

}
