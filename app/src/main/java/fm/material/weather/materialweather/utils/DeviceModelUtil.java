package fm.material.weather.materialweather.utils;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;

/**
 * Created by fm on 2016/2/22.
 */
public class DeviceModelUtil {

    public static boolean isLessThanAndroidL() {
        int SDK;
        try {
            SDK = Integer.valueOf(Build.VERSION.SDK);
        } catch (NumberFormatException e) {
            SDK = 0;
        }
        if (SDK < 21) {
            return true;
        }
        return false;
    }

    public static String getDeviceName() {
        return Build.MODEL;
    }

    public static String getDeviceToken(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

}
