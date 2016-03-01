package fm.material.weather.materialweather.http;

import retrofit.Callback;
import retrofit.client.Response;

/**
 * Created by fm on 16/3/1.
 */
public class ServeApi {

    BaseApi baseApi;
    String KEY = BaseApi.WEATHER_KEY;

    public ServeApi(BaseApi api) {
        baseApi = api;
    }

    public void getWeatherByName(String cityName, Callback<Response> response) {
        baseApi.getWeatherByName(cityName, KEY, response);
    }

}
