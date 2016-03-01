package fm.material.weather.materialweather;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import fm.material.weather.materialweather.http.BaseApi;
import fm.material.weather.materialweather.http.ServeApi;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by fm on 16/3/1.
 */
public class MaterialWeatherApplication extends Application {

    private BaseApi baseApi;
    private ServeApi serveApi;

    @Override
    public void onCreate() {
        super.onCreate();

        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(null)
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(BaseApi.SERVER_IP)
                .build();
        baseApi = restAdapter.create(BaseApi.class);
        serveApi = new ServeApi(baseApi);

    }

    public ServeApi getApi(){
        return serveApi;
    }

}
