package com.javatar.basemvp.proyectobase.interfaces.structures;

import com.javatar.basemvp.proyectobase.interfaces.callbacks.DataCallback;

/**
 * Created by Tadeo-developer on 27/09/17.
 */

public interface IRepository<TCallback extends DataCallback> {
    void send(TCallback dataCallBack, Object... args);
}
