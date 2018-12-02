package com.javatar.basemvp.proyectobase.interfaces.structures;


import com.javatar.basemvp.proyectobase.interfaces.listeners.OnClickListener;
import com.javatar.basemvp.proyectobase.models.data.DataSimple;

import java.util.ArrayList;

/**
 * Created by Tadeo Gonzalez on 24/02/2017.
 */

public interface IViewAlert {
    void showAlert(String title, String description, String detail, int numberButtons, String nameButtonPositive, String nameButtonNegative, OnClickListener onClickListener);
    void showAlert(String title, String description, String detail, int numberButtons, String nameButtonPositive, OnClickListener onClickListener);
    void showAlert(String title, String description, String detail, String nameButtonPositive, OnClickListener onClickListener);
    void showAlert(String title, String description, String detail, int numberButtons, OnClickListener onClickListener);
    void showAlert(String title, String description, String detail, OnClickListener onClickListener);
    void showAlert(String title, String description, int numberButtons, String nameButtonPositive, String nameButtonNegative, OnClickListener onClickListener);
    void showAlert(String title, String description, int numberButtons, String nameButtonPositive, OnClickListener onClickListener);
    void showAlert(String title, String description, int numberButtons, OnClickListener onClickListener);
    void showAlert(String title, String description, OnClickListener onClickListener);
    void showAlert(String title, String description, String detail);
    void showAlert(String title, String description);

    void showAlertList(String title, ArrayList<DataSimple> data, int numberButtons, String nameButtonPositive, String nameButtonNegative, OnClickListener onClickListener);
    void showAlertList(String title, ArrayList<DataSimple> data, int numberButtons, String nameButtonPositive, OnClickListener onClickListener);
    void showAlertList(String title, ArrayList<DataSimple> data, String nameButtonPositive, OnClickListener onClickListener);
    void showAlertList(String title, ArrayList<DataSimple> data, int numberButtons, OnClickListener onClickListener);
    void showAlertList(String title, ArrayList<DataSimple> data, OnClickListener onClickListener);
    void showAlertList(String title, ArrayList<DataSimple> data);
}
