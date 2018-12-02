package com.javatar.basemvp.proyectobase.common.interactors;

import com.javatar.basemvp.proyectobase.interfaces.callbacks.DataCallback;
import com.javatar.basemvp.proyectobase.interfaces.structures.IInteractor;

/**
 * Created by Tadeo-developer on 11/07/18.
 */

public abstract class AbstractInteractor<T extends DataCallback> implements IInteractor<T>{

    protected T callback;
    protected Object[] args;

    @Override
    public void send(T callback, Object... args){
        this.callback = callback;
        this.args = args;
    }


}
