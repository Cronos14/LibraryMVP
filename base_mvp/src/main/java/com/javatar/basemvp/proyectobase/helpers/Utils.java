package com.javatar.basemvp.proyectobase.helpers;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * Created by Tadeo Gonzalez on 22/02/2017.
 */

public class Utils {

    public static final int PORCENT_GENERAL = 60;

    public static boolean verifiyConnection(Context context) {
        boolean flag = true;

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();


        if(networkInfo!=null){
            if(networkInfo.getType() == ConnectivityManager.TYPE_WIFI){
                if ((networkInfo == null || !networkInfo.isConnected() || !networkInfo.isAvailable())) {
                    flag = false;
                }
            }else if(networkInfo.getType() == ConnectivityManager.TYPE_MOBILE){
                if ((networkInfo == null || !networkInfo.isConnected() || !networkInfo.isAvailable())) {
                    flag = false;
                }
            }else{
                if ((networkInfo == null || !networkInfo.isConnected() || !networkInfo.isAvailable())) {
                    flag = false;
                }
            }
        }else{
            flag = false;
        }

        return flag;
    }

    /**
     * Use this method to hide a view in your layout with a fade effect
     *
     * @param from     start value of the fade animation
     * @param to       final value of the fade animation
     * @param duration duration of the animation
     * @param delay    delay of the animation, if any
     * @param view     the view to be faded
     */
    public static void hideFadeView(float from, float to, long duration, long delay, final View view) {
        ObjectAnimator fade = ObjectAnimator.ofFloat(view, "alpha", from, to);

        AnimatorSet animSet = new AnimatorSet();
        animSet.playTogether(fade);
        animSet.setDuration(duration);
        animSet.setStartDelay(delay);
        animSet.setInterpolator(new LinearInterpolator());
        animSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationStart(animation);
                view.setVisibility(View.GONE);
            }
        });
        animSet.start();
    }

    /**
     * Use this method to show a view in your layout with a fade effect
     *
     * @param from     start value of the fade animation
     * @param to       final value of the fade animation
     * @param duration duration of the animation
     * @param delay    delay of the animation, if any
     * @param view     the view to be faded
     */
    public static void showFadeView(float from, float to, long duration, long delay, final View view) {
        ObjectAnimator fade = ObjectAnimator.ofFloat(view, "alpha", from, to);

        AnimatorSet animSet = new AnimatorSet();
        animSet.playTogether(fade);
        animSet.setDuration(duration);
        animSet.setStartDelay(delay);
        animSet.setInterpolator(new LinearInterpolator());
        animSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                view.setVisibility(View.VISIBLE);
            }
        });
        animSet.start();
    }

    /**
     * Use this method to spin a view in his own axis
     *
     * @param view       the view to be spinned
     * @param from       the angle to start the animation
     * @param to         the angle to end the animation
     * @param drawableId a drawable id to show at the end of the spin animation
     */
    public static void spinView(final View view, float from, float to, final int drawableId) {
        ObjectAnimator animSpin = ObjectAnimator.ofFloat(view, "rotation", from, to);
        animSpin.setDuration(300);
        animSpin.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                ((ImageView) view).setImageResource(drawableId);
            }
        });
        animSpin.start();
    }

    public static String getMacAddr() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    res1.append(String.format("%02X:",b));
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex) {
        }
        return "02:00:00:00:00:00";
    }

    public static String getIPAddress(boolean useIPv4) {
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
                for (InetAddress addr : addrs) {
                    if (!addr.isLoopbackAddress()) {
                        String sAddr = addr.getHostAddress();
                        //boolean isIPv4 = InetAddressUtils.isIPv4Address(sAddr);
                        boolean isIPv4 = sAddr.indexOf(':')<0;

                        if (useIPv4) {
                            if (isIPv4)
                                return sAddr;
                        } else {
                            if (!isIPv4) {
                                int delim = sAddr.indexOf('%'); // drop ip6 zone suffix
                                return delim<0 ? sAddr.toUpperCase() : sAddr.substring(0, delim).toUpperCase();
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) { } // for now eat exceptions
        return "";
    }

    public static String toSha256(String input){
        MessageDigest mDigest;
        try {
            mDigest = MessageDigest.getInstance("SHA-256");
            byte[] result = mDigest.digest(input.getBytes());
            return bytesToHexSha256(result);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String bytesToHexSha256(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static boolean validateCode(String code){

        try{
            int codeNumber = Integer.parseInt(code);

            if(codeNumber==0){
                return true;
            }else{
                return false;
            }

        }catch (NumberFormatException e){
            if(code.equalsIgnoreCase("0") || code.equalsIgnoreCase("00") || code.equalsIgnoreCase("000")){
                return true;
            }else{
                return false;
            }
        }


    }



    public static String getMonth(int month){
        switch (month){
            case 1: return "ENERO";
            case 2: return "FEBRERO";
            case 3: return "MARZO";
            case 4: return "ABRIL";
            case 5: return "MAYO";
            case 6: return "JUNIO";
            case 7: return "JULIO";
            case 8: return "ABRIL";
            case 9: return "AGOSTO";
            case 10: return "SEPTIEMBRE";
            case 11: return "NOVIEMBRE";
            case 12: return "DICIEMBRE";
            default: return "NO IDENTIFICADO";
        }
    }

    public static int getYear() {

        Calendar calendario = Calendar.getInstance();
        calendario.setTimeInMillis(System.currentTimeMillis());
        return calendario.get(Calendar.YEAR);
    }

    public static String getHour() {

        Calendar calendario = Calendar.getInstance();
        calendario.setTimeInMillis(System.currentTimeMillis());
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minuto = calendario.get(Calendar.MINUTE);
        int segundo = calendario.get(Calendar.SECOND);

        String horaText = "";
        String minutoText = "";
        String segundoText = "";

        if(hora<10)
            horaText = "0"+hora;
        else
            horaText = hora+"";


        if(minuto<10)
            minutoText = "0"+minuto;
        else
            minutoText = minuto+"";

        if(segundo<10)
            segundoText = "0"+segundo;
        else
            segundoText = segundo+"";

        return horaText+":"+minutoText+":"+segundoText;
    }

    public static String getDate() {

        Calendar calendario = Calendar.getInstance();
        calendario.setTimeInMillis(System.currentTimeMillis());
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH);
        int anio = calendario.get(Calendar.YEAR);


        return dia + " / " + (mes + 1) + " / " + anio;
    }
}
