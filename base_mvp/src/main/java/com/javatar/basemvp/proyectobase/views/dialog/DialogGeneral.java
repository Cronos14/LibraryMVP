package com.javatar.basemvp.proyectobase.views.dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.javatar.basemvp.R;
import com.javatar.basemvp.proyectobase.interfaces.listeners.OnClickListener;

/**
 * Created by raul.gonzalez on 28/12/2015.
 */
public abstract class DialogGeneral extends DialogFragment implements View.OnClickListener{


    private OnClickListener onClickListener;


    private String title;
    private int numBtn;
    private String nameButtonPositive;
    private String nameButtonNegative;

    private TextView tvTitle;
    private Button btnCancel;
    private Button btnAccept;

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


        Bundle args = getArguments();

        title = args.getString("title");

        numBtn = args.getInt("numBtn");

        nameButtonPositive = args.getString("nameButtonPositive");
        nameButtonNegative = args.getString("nameButtonNegative");

        tvTitle = (TextView)view.findViewById(R.id.tv_title);

        btnAccept = (Button)view.findViewById(R.id.btn_accept);
        btnCancel = (Button)view.findViewById(R.id.btn_cancel);

        if(nameButtonPositive!=null && !nameButtonPositive.isEmpty()){
            btnAccept.setText(nameButtonPositive);
        }

        if(nameButtonNegative!=null && !nameButtonNegative.isEmpty()){
            btnCancel.setText(nameButtonNegative);
        }



        tvTitle.setText(title);


        btnAccept.setOnClickListener(this);

        if(numBtn>1){
            btnCancel.setOnClickListener(this);
        }else {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            btnAccept.setLayoutParams(layoutParams);
            btnCancel.setVisibility(View.GONE);
        }

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

    }

    @Override
    public void onResume() {
        super.onResume();

        getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    public void setOnClickListener(OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    @Override
    public final void onClick(View view) {
        if(view.getId()==R.id.btn_accept){
            onClickAccept(true);
        }

        if(view.getId()==R.id.btn_cancel){
            onClickCancel(false);
        }
    }

    protected void onClickAccept(Object object){
        if(onClickListener!=null){
            onClickListener.onClick(object);
        }

        dismiss();
    }

    protected void onClickCancel(Object object){
        if(onClickListener!=null){
            onClickListener.onClick(object);
        }

        dismiss();
    }


}
