package com.javatar.basemvp.proyectobase.common.presenters;

import com.javatar.basemvp.proyectobase.interfaces.listeners.OnClickListener;
import com.javatar.basemvp.proyectobase.interfaces.structures.IPresenter;
import com.javatar.basemvp.proyectobase.models.data.Response;
import com.javatar.basemvp.proyectobase.interfaces.structures.IView;

/**
 * Created by Tadeo Gonzalez on 24/02/2017.
 */

public abstract class AbstractPresenter<T extends IView> implements IPresenter {

    protected T view;

    public AbstractPresenter(T view) {
        this.view = view;
    }

    @Override
    public void create() {

    }

    public void onError(Object object, final OnClickListener onClickListener) {
        view.hideProgress();
        if(object!=null){

            if(object instanceof Response){
                Response response = (Response)object;

                if("EXCEPTION".equalsIgnoreCase(response.getCode())){
                    view.showAlert("Error","Error interno",response.getIdException()+": "+response.getDescripcion(), new OnClickListener() {
                        @Override
                        public void onClick(Object object) {
                            if(onClickListener!=null){
                                onClickListener.onClick(object);
                            }
                        }
                    });
                }else if("FAILURE".equalsIgnoreCase(response.getCode())){

                    view.showAlert("Error","No se logro obtener una respuesta del servidor",response.getDescripcion(), new OnClickListener() {
                        @Override
                        public void onClick(Object object) {
                            if(onClickListener!=null){
                                onClickListener.onClick(object);
                            }
                        }
                    });

                }else{
                    view.showAlert("Error",response.getDescripcion(), new OnClickListener() {
                        @Override
                        public void onClick(Object object) {
                            if(onClickListener!=null){
                                onClickListener.onClick(object);
                            }
                        }
                    });
                }


            }else{
                view.showAlert("Error",object.toString(), new OnClickListener() {
                    @Override
                    public void onClick(Object object) {
                        if(onClickListener!=null){
                            onClickListener.onClick(object);
                        }
                    }
                });
            }


        }else{
            view.showAlert("Error","Sin datos", new OnClickListener() {
                @Override
                public void onClick(Object object) {
                    if(onClickListener!=null){
                        onClickListener.onClick(object);
                    }
                }
            });
        }

    }

    @Override
    public void onError(Object object) {
        onError(object, null);
    }


    @Override
    public void showProgress() {
        view.showProgress();
    }

    @Override
    public void hideProgress() {
        view.hideProgress();
    }
}
