package com.javatar.basemvp.proyectobase.models.data;

import java.io.Serializable;

/**
 * Created by Tadeo-developer on 18/03/17.
 */

public class DataSimple implements Serializable {
    private String label;
    private String text;
    private int type;

    public DataSimple(String label, String text){
        this.label = label;
        this.text = text;
    }

    public DataSimple(String label, int type){
        this.label = label;
        this.type = type;
    }

    public void DataSimple(){

    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
