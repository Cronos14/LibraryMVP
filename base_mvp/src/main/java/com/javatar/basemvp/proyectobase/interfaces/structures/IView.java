package com.javatar.basemvp.proyectobase.interfaces.structures;

/**
 * Created by Tadeo Gonzalez on 24/02/2017.
 */

public interface IView extends IViewProgress,IViewAlert {
    void onClickView(String tag);
}
