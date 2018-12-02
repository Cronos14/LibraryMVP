package com.javatar.basemvp.proyectobase.common.fragments;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.javatar.basemvp.proyectobase.common.activitys.AbstractActivity;
import com.javatar.basemvp.proyectobase.interfaces.listeners.OnActionFragmentListener;
import com.javatar.basemvp.proyectobase.interfaces.listeners.OnClickListener;
import com.javatar.basemvp.proyectobase.interfaces.structures.IPresenter;
import com.javatar.basemvp.proyectobase.interfaces.structures.IView;
import com.javatar.basemvp.proyectobase.interfaces.structures.IViewActionFragment;
import com.javatar.basemvp.proyectobase.models.data.DataSimple;

import java.util.ArrayList;


/**
 * Created by Tadeo Gonzalez on 11/01/2017.
 */

public abstract class AbstractFragment extends Fragment implements IView,IViewActionFragment,View.OnClickListener{

    protected final String TAG = this.getClass().getSimpleName();

    public static final int PERMISSION_REQUEST_CODE_CALL_PHONE = 1;
    public static final int PERMISSION_REQUEST_CODE_FINE_LOCATION = 2;
    public static final int PERMISSION_REQUEST_CODE_SMS = 3;

    protected OnActionFragmentListener onActionFragmentListener;
    private String name;
    private int position;
    private boolean selected;
    private AbstractActivity abstractActivity;
    protected IPresenter presenter;

    public static AbstractFragment newFragment(AbstractFragment fragment, String name, OnActionFragmentListener onActionFragmentListener){
        fragment.setName(name);
        fragment.setOnActionFragmentListener(onActionFragmentListener);
        return fragment;
    }

    public static AbstractFragment newFragment(AbstractFragment fragment, String name){
        fragment.setName(name);
        return fragment;
    }

    @Override
    public void showAlert(String title, String description, String detail, int numberButtons, String nameButtonPositive, String nameButtonNegative, OnClickListener onClickListener) {
        if(getParentActivity()!=null)getParentActivity().showAlert(title,description,detail,numberButtons,nameButtonPositive,nameButtonNegative,onClickListener);
    }

    @Override
    public void showAlert(String title, String description, String detail, int numberButtons, String nameButtonPositive, OnClickListener onClickListener) {
        if(getParentActivity()!=null)getParentActivity().showAlert(title,description,detail,numberButtons,nameButtonPositive,onClickListener);
    }

    @Override
    public void showAlert(String title, String description, String detail, String nameButtonPositive, OnClickListener onClickListener) {
        if(getParentActivity()!=null)getParentActivity().showAlert(title,description,detail,1,nameButtonPositive,onClickListener);
    }

    @Override
    public void showAlert(String title, String description, String detail, int numberButtons, OnClickListener onClickListener) {
        if(getParentActivity()!=null)getParentActivity().showAlert(title,description,detail,numberButtons,onClickListener);
    }

    @Override
    public void showAlert(String title, String description, String detail, OnClickListener onClickListener) {
        if(getParentActivity()!=null)getParentActivity().showAlert(title,description,detail,onClickListener);
    }

    @Override
    public void showAlert(String title, String description, int numberButtons, String nameButtonPositive, String nameButtonNegative, OnClickListener onClickListener) {
        if(getParentActivity()!=null)getParentActivity().showAlert(title,description,"",numberButtons,nameButtonPositive,nameButtonNegative,onClickListener);
    }

    @Override
    public void showAlert(String title, String description, int numberButtons, String nameButtonPositive, OnClickListener onClickListener) {
        if(getParentActivity()!=null)getParentActivity().showAlert(title,description,"",numberButtons,nameButtonPositive,onClickListener);
    }

    @Override
    public void showAlert(String title, String description, int numberButtons, OnClickListener onClickListener) {
        if(getParentActivity()!=null)getParentActivity().showAlert(title,description,numberButtons,onClickListener);
    }

    @Override
    public void showAlert(String title, String description, OnClickListener onClickListener) {
        if(getParentActivity()!=null)getParentActivity().showAlert(title,description,onClickListener);
    }

    @Override
    public void showAlert(String title, String description, String detail) {
        if(getParentActivity()!=null)getParentActivity().showAlert(title,description,detail);
    }

    @Override
    public void showAlert(String title, String description) {
        if(getParentActivity()!=null)getParentActivity().showAlert(title,description);
    }

    public void showAlertList(String title, ArrayList<DataSimple> data, int numberButtons, String nameButtonPositive, String nameButtonNegative, OnClickListener onClickListener){
        if(getParentActivity()!=null)getParentActivity().showAlertList(title,data,numberButtons,nameButtonPositive,nameButtonNegative,onClickListener);
    }
    public void showAlertList(String title, ArrayList<DataSimple> data, int numberButtons, String nameButtonPositive, OnClickListener onClickListener){
        if(getParentActivity()!=null)getParentActivity().showAlertList(title,data,numberButtons,nameButtonPositive,onClickListener);
    }
    public void showAlertList(String title, ArrayList<DataSimple> data, String nameButtonPositive, OnClickListener onClickListener){
        if(getParentActivity()!=null)getParentActivity().showAlertList(title,data,nameButtonPositive,onClickListener);
    }
    public void showAlertList(String title, ArrayList<DataSimple> data, int numberButtons, OnClickListener onClickListener){
        if(getParentActivity()!=null)getParentActivity().showAlertList(title,data,numberButtons,onClickListener);
    }
    public void showAlertList(String title, ArrayList<DataSimple> data, OnClickListener onClickListener){
        if(getParentActivity()!=null)getParentActivity().showAlertList(title,data,onClickListener);
    }
    public void showAlertList(String title, ArrayList<DataSimple> data){
        if(getParentActivity()!=null)getParentActivity().showAlertList(title,data);
    }

    @Override
    public void showProgress() {

        if(getParentActivity()!=null && !getParentActivity().isFinishing())
            getParentActivity().showProgress();
    }

    @Override
    public void hideProgress() {
        if(getParentActivity()!=null)
            getParentActivity().hideProgress();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.abstractActivity = (AbstractActivity)activity;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onClickView(String tag) {

    }

    protected boolean validatePermissionFineLocation() {


        if (checkPermission(android.Manifest.permission.ACCESS_FINE_LOCATION, PERMISSION_REQUEST_CODE_FINE_LOCATION)) {
            return true;
        } else {
            requestPermission(android.Manifest.permission.ACCESS_FINE_LOCATION, PERMISSION_REQUEST_CODE_FINE_LOCATION);
            return false;
        }


    }

    protected boolean checkPermission(String permission, int requestCode) {
        if (getParentActivity() != null) {
            int result = ContextCompat.checkSelfPermission(getParentActivity(), permission);
            if (result == PackageManager.PERMISSION_GRANTED) {

                if (requestCode == PERMISSION_REQUEST_CODE_CALL_PHONE) {
                    //initCallPhone();
                } else if (requestCode == PERMISSION_REQUEST_CODE_FINE_LOCATION) {
                    updateLocation();
                } else if (requestCode == PERMISSION_REQUEST_CODE_SMS) {
                    //sendSms();
                }

                return true;
            } else {
                return false;
            }
        }

        return false;

    }

    protected void requestPermission(String permission, int requestCode) {
        if (ContextCompat.checkSelfPermission(getActivity(), permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{permission}, requestCode);
        }
    }

    protected void updateLocation(){

    }

    public OnActionFragmentListener getOnActionFragmentListener() {
        return onActionFragmentListener;
    }

    public void setOnActionFragmentListener(OnActionFragmentListener onActionFragmentListener) {
        this.onActionFragmentListener = onActionFragmentListener;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public AbstractActivity getParentActivity(){
        return abstractActivity;
    }

    public IPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(IPresenter presenter) {
        this.presenter = presenter;
    }
}
