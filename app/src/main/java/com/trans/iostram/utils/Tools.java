package com.trans.iostram.utils;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * @author Tom灿
 * @description:
 * @date :2023/6/5 17:19
 */
public class Tools {
    private static double x_PI = 3.14159265358979324 * 3000.0 / 180.0;
    private static double PI = 3.1415926535897932384626;
    private static double a = 6378245.0;
    private static double ee = 0.00669342162296594323;

    /**
     * WGSGCJ02
     *
     * @param wgs_lon
     * @param wgs_lat
     * @return Double[lon, lat]
     */
    public static Double[] WGS84ToGCJ02(Double wgs_lon, Double wgs_lat) {
        if (outOfChina(wgs_lon, wgs_lat)) {
            return new Double[]{wgs_lon, wgs_lat};
        }
        double dlat = transformlat(wgs_lon - 105.0, wgs_lat - 35.0);
        double dlng = transformlng(wgs_lon - 105.0, wgs_lat - 35.0);
        double radlat = wgs_lat / 180.0 * PI;
        double magic = Math.sin(radlat);
        magic = 1 - ee * magic * magic;
        double sqrtmagic = Math.sqrt(magic);
        dlat = (dlat * 180.0) / ((a * (1 - ee)) / (magic * sqrtmagic) * PI);
        dlng = (dlng * 180.0) / (a / sqrtmagic * Math.cos(radlat) * PI);
        Double[] arr = new Double[2];
        arr[0] = wgs_lon + dlng;
        arr[1] = wgs_lat + dlat;
        return arr;
    }


    /**
     * GCJ02转WGS84
     * @param gcj_lon
     * @param gcj_lat
     * @return Double[lon,lat]
     */
    public static Double[] GCJ02ToWGS84(Double gcj_lon,Double gcj_lat){
        if(outOfChina(gcj_lon, gcj_lat)){
            return new Double[]{gcj_lon,gcj_lat};
        }
        double dlat = transformlat(gcj_lon - 105.0, gcj_lat - 35.0);
        double dlng = transformlng(gcj_lon - 105.0, gcj_lat - 35.0);
        double radlat = gcj_lat / 180.0 * PI;
        double magic = Math.sin(radlat);
        magic = 1 - ee * magic * magic;
        double sqrtmagic = Math.sqrt(magic);
        dlat = (dlat * 180.0) / ((a * (1 - ee)) / (magic * sqrtmagic) * PI);
        dlng = (dlng * 180.0) / (a / sqrtmagic * Math.cos(radlat) * PI);
        double mglat = gcj_lat + dlat;
        double mglng = gcj_lon + dlng;
        return new Double[]{gcj_lon * 2 - mglng, gcj_lat * 2 - mglat};
    }

    private static Double transformlat(double lng, double lat) {
        double ret = -100.0 + 2.0 * lng + 3.0 * lat + 0.2 * lat * lat + 0.1 * lng * lat + 0.2 * Math.sqrt(Math.abs(lng));
        ret += (20.0 * Math.sin(6.0 * lng * PI) + 20.0 * Math.sin(2.0 * lng * PI)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(lat * PI) + 40.0 * Math.sin(lat / 3.0 * PI)) * 2.0 / 3.0;
        ret += (160.0 * Math.sin(lat / 12.0 * PI) + 320 * Math.sin(lat * PI / 30.0)) * 2.0 / 3.0;
        return ret;
    }

    private static Double transformlng(double lng, double lat) {
        double ret = 300.0 + lng + 2.0 * lat + 0.1 * lng * lng + 0.1 * lng * lat + 0.1 * Math.sqrt(Math.abs(lng));
        ret += (20.0 * Math.sin(6.0 * lng * PI) + 20.0 * Math.sin(2.0 * lng * PI)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(lng * PI) + 40.0 * Math.sin(lng / 3.0 * PI)) * 2.0 / 3.0;
        ret += (150.0 * Math.sin(lng / 12.0 * PI) + 300.0 * Math.sin(lng / 30.0 * PI)) * 2.0 / 3.0;
        return ret;
    }


    /**
     * outOfChina
     *
     * @param lng
     * @param lat
     * @return {boolean}
     * @描述: 判断是否在国内，不在国内则不做偏移
     */
    private static boolean outOfChina(Double lng, Double lat) {
        return (lng < 72.004 || lng > 137.8347) || ((lat < 0.8293 || lat > 55.8271) || false);
    }


    /**
     * 设置沉浸式状态栏
     * 需要在activity的布局中留出状态栏的高度
     *
     * @param activity
     */
    public static void setTransparentStatusbar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //先将状态栏调整为透明
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        //设置布局留出状态栏高度
    }

    /**
     * 重启APP
     *
     * @param launchActivity
     */
    public static void restartApp(Activity launchActivity) {
        Intent intent = new Intent(launchActivity.getApplicationContext(), launchActivity.getClass());

//        intent.putExtra("REBOOT", "reboot");
//        PendingIntent restartIntent = PendingIntent.getActivity(launchActivity.getApplicationContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
//        AlarmManager mgr = (AlarmManager) launchActivity.getSystemService(launchActivity.ALARM_SERVICE);
//        mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 2000, restartIntent);
//        launchActivity.startActivity(intent);

        launchActivity.finish();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);


//        Intent ii = new Intent(launchActivity, RestartService.class);
//        ii.putExtra("restartIntent", intent);
//        launchActivity.startService(ii);


//        android.os.Process.killProcess(android.os.Process.myPid());
//        System.exit(0);

//        launchActivity.finish();
//        launchActivity.startActivity(intent);
//        launchActivity.overridePendingTransition(0, 0);

//        launchActivity.navigateUpTo(intent);
//        launchActivity.startActivity(intent);


    }


}
