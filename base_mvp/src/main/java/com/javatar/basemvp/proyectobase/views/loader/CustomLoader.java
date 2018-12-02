package com.javatar.basemvp.proyectobase.views.loader;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.javatar.basemvp.R;


/**
 * Created by davidcordova on 12/01/16.
 */
public class CustomLoader extends ProgressDialog {

    private AnimationDrawable animation;

    public CustomLoader(Context context) {
        super(context);
    }

    public CustomLoader(Context context, int theme) {
        super(context, theme);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_loader);

        ImageView ivAnimation = (ImageView) findViewById(R.id.iv_animation);
        ivAnimation.setBackgroundResource(R.drawable.animation_list_filling_applex);
        animation = ((AnimationDrawable) ivAnimation.getBackground());


        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setCancelable(false);
        setCanceledOnTouchOutside(false);

    }

    @Override
    public void show() {
        super.show();

        animation.start();
    }

    @Override
    public void dismiss() {
        super.dismiss();
        animation.stop();
    }
}