package fm.material.weather.materialweather.http;


import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.PATCH;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by fm on 16/3/1.
 */
public interface BaseApi {

    //和风天气接口
    String SERVER_IP = "https://api.heweather.com/x3";
    String WEATHER_KEY = "f547c3f4dd7940ebbd26eb6d05384fe8";
    String WEATHER = "/weather";

    @GET(WEATHER)
    void getWeatherByName(@Query("city") String cityName, @Query("key") String key,Callback<Response> response);

//    @GET(CITY_ID + "{city_id}" + WEATHER_KEY)
//    void getWeatherByID(@Path("city_id") String cityID, Callback<Response> response);
//
//    @GET(CITY_IP + "{city_ip}" + WEATHER_KEY)
//    void getWeatherByIDIP(@Path("city_ip") String cityIP, Callback<Response> response);




}
