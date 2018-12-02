package com.javatar.basemvp.proyectobase.interfaces.structures;

import com.javatar.basemvp.proyectobase.interfaces.callbacks.DataCallback;

public interface IInteractor<T extends DataCallback>{
    void send(T callback, Object... args);
}