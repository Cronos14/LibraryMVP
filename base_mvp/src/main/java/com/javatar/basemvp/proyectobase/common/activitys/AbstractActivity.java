package com.javatar.basemvp.proyectobase.common.activitys;

import android.support.v7.app.AppCompatActivity;

import com.javatar.basemvp.proyectobase.interfaces.listeners.OnClickListener;
import com.javatar.basemvp.proyectobase.interfaces.structures.IView;
import com.javatar.basemvp.proyectobase.models.data.DataSimple;
import com.javatar.basemvp.proyectobase.views.dialog.DialogGeneral;
import com.javatar.basemvp.proyectobase.views.dialog.DialogGeneric;
import com.javatar.basemvp.proyectobase.views.dialog.DialogGenericList;
import com.javatar.basemvp.proyectobase.views.loader.CustomLoader;

import java.util.ArrayList;


/**
 * Created by Tadeo Gonzalez on 23/02/2017.
 */

public abstract class AbstractActivity extends AppCompatActivity implements IView {

    protected final String TAG = this.getClass().getSimpleName();

    private static CustomLoader customLoader;
    private static int countLoader;

    @Override
    public void showProgress() {

        if(!isFinishing()){
            if(customLoader==null || !customLoader.isShowing()){
                customLoader = new CustomLoader(this);
                customLoader.show();
            }
            countLoader++;
        }


    }

    @Override
    public void hideProgress() {
        if(countLoader>0){
            countLoader--;
        }

        if (countLoader <= 0 && (customLoader != null && customLoader.isShowing())){
            customLoader.dismiss();
            countLoader = 0;
        }
    }

    private void showAlert(DialogGeneral dialogGeneral){
        try{
            dialogGeneral.show(getFragmentManager(),"");
        }catch (IllegalStateException e){
        }
    }

    @Override
    public void showAlert(String title, String description, String detail, int numberButtons, String nameButtonPositive, String nameButtonNegative, OnClickListener onClickListener) {


        if(!isFinishing()){
            DialogGeneric dialogGeneric = DialogGeneric.newInstance(title,description,detail,numberButtons,nameButtonPositive,nameButtonNegative,onClickListener);

            dialogGeneric.setCancelable(false);

            showAlert(dialogGeneric);
        }


    }



    @Override
    public void showAlert(String title, String description, String detail, int numberButtons, String nameButtonPositive, OnClickListener onClickListener) {

        if(!isFinishing()){
            DialogGeneric dialogGeneric = DialogGeneric.newInstance(title,description,detail,numberButtons,nameButtonPositive,onClickListener);

            dialogGeneric.setCancelable(false);

            showAlert(dialogGeneric);

        }

    }

    @Override
    public void showAlert(String title, String description, String detail, int numberButtons, OnClickListener onClickListener) {

        if(!isFinishing()){
            DialogGeneric dialogGeneric = DialogGeneric.newInstance(title,description,detail,numberButtons,onClickListener);

            dialogGeneric.setCancelable(false);

            showAlert(dialogGeneric);
        }

    }

    @Override
    public void showAlert(String title, String description, String detail, String nameButtonPositive, OnClickListener onClickListener) {
        showAlert(title,description,detail,1,nameButtonPositive,onClickListener);
    }
    @Override
    public void showAlert(String title, String description, String detail, OnClickListener onClickListener) {
        showAlert(title,description,detail,1,onClickListener);
    }

    @Override
    public void showAlert(String title, String description, int numberButtons, String nameButtonPositive, String nameButtonNegative, OnClickListener onClickListener) {
        showAlert(title,description,"",numberButtons,nameButtonPositive,nameButtonNegative,onClickListener);
    }

    @Override
    public void showAlert(String title, String description, int numberButtons, String nameButtonPositive, OnClickListener onClickListener) {
        showAlert(title,description,"",numberButtons,nameButtonPositive,onClickListener);
    }

    @Override
    public void showAlert(String title, String description, int numberButtons, OnClickListener onClickListener) {
        showAlert(title,description,"",numberButtons,onClickListener);
    }
    @Override
    public void showAlert(String title, String description, OnClickListener onClickListener){
        showAlert(title,description,1,onClickListener);
    }
    @Override
    public void showAlert(String title, String description, String detail) {
        showAlert(title,description,detail,null);
    }
    @Override
    public void showAlert(String title, String description) {
        showAlert(title,description,"");
    }

    @Override
    public void showAlertList(String title, ArrayList<DataSimple> data, int numberButtons, String nameButtonPositive, String nameButtonNegative, OnClickListener onClickListener) {

        if (!isFinishing()) {
            DialogGenericList dialog = DialogGenericList.newInstance(title, data, numberButtons, nameButtonPositive, nameButtonNegative, onClickListener);

            dialog.setCancelable(false);

            showAlert(dialog);
        }

    }

    @Override
    public void showAlertList(String title, ArrayList<DataSimple> data, int numberButtons, String nameButtonPositive, OnClickListener onClickListener) {

        if(!isFinishing()){
            DialogGenericList dialog = DialogGenericList.newInstance(title,data,numberButtons,nameButtonPositive,onClickListener);

            dialog.setCancelable(false);

            showAlert(dialog);
        }

    }

    @Override
    public void showAlertList(String title, ArrayList<DataSimple> data, int numberButtons, OnClickListener onClickListener) {

        if(!isFinishing()){
            DialogGenericList dialog = DialogGenericList.newInstance(title,data,numberButtons,onClickListener);

            dialog.setCancelable(false);

            showAlert(dialog);
        }

    }

    @Override
    public void showAlertList(String title, ArrayList<DataSimple> data, String nameButtonPositive, OnClickListener onClickListener) {
        showAlertList(title,data,1,nameButtonPositive,onClickListener);
    }

    @Override
    public void showAlertList(String title, ArrayList<DataSimple> data, OnClickListener onClickListener){
        showAlertList(title,data,1,onClickListener);
    }
    @Override
    public void showAlertList(String title, ArrayList<DataSimple> data) {
        showAlertList(title,data,null);
    }

    @Override
    public void onClickView(String tag) {

    }


}
