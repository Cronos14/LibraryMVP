package com.javatar.basemvp.proyectobase.common.fragments;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.view.animation.Animation;

import com.javatar.basemvp.proyectobase.common.activitys.AbstractActivity;
import com.javatar.basemvp.proyectobase.interfaces.listeners.OnActionFragmentListener;
import com.javatar.basemvp.proyectobase.interfaces.listeners.OnClickListener;
import com.javatar.basemvp.proyectobase.interfaces.structures.IView;
import com.javatar.basemvp.proyectobase.models.data.DataSimple;

import java.util.ArrayList;

/**
 * Created by Tadeo Gonzalez on 10/03/2017.
 */

public abstract class AbstractDialogFragment extends DialogFragment implements IView {
    protected OnActionFragmentListener onActionFragmentListener;
    protected Animation anim;
    private String name;
    private int position;
    private boolean selected;
    private AbstractActivity abstractActivity;


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
    public void showAlert(String title, String description, int numberButtons, OnClickListener onClickListener) {
        if(getParentActivity()!=null)getParentActivity().showAlert(title,description,numberButtons,onClickListener);
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
        if(getParentActivity()!=null)getParentActivity().showProgress();
    }

    @Override
    public void hideProgress() {
        if(getParentActivity()!=null)getParentActivity().hideProgress();
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
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void onClickView(String tag) {

    }
}
