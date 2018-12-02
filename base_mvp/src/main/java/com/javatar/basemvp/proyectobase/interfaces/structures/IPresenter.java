package com.javatar.basemvp.proyectobase.interfaces.structures;

import com.javatar.basemvp.proyectobase.interfaces.callbacks.DataCallback;

/**
 * Created by Tadeo-developer on 26/04/17.
 */

public interface IPresenter extends IViewProgress, DataCallback {
    void create();
}
