package fm.material.weather.materialweather.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import fm.material.weather.materialweather.MaterialWeatherApplication;
import fm.material.weather.materialweather.R;
import fm.material.weather.materialweather.base.BaseActivity;
import lecho.lib.hellocharts.listener.LineChartOnValueSelectListener;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.LineChartView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;

public class MainActivity extends BaseActivity {


    public final static String[] days = new String[]{"今天", "明天", "后天", "周二",
            "周三", "周四", "周五",};
    @Bind(R.id.image)
    ImageView image;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @Bind(R.id.layout_weather)
    AppBarLayout layoutWeather;
    @Bind(R.id.chart_max)
    LineChartView chartMax;
    @Bind(R.id.chart_min)
    LineChartView chartMin;
    @Bind(R.id.scroll)
    NestedScrollView scroll;
    @Bind(R.id.fab)
    FloatingActionButton fab;

    private LineChartData lineData;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        chartMax.setZoomEnabled(false);
        chartMin.setZoomEnabled(false);
        chartMax.setInteractive(true);
        chartMin.setInteractive(true);
        chartMax.setViewportCalculationEnabled(false);
        chartMin.setViewportCalculationEnabled(false);
        Viewport v = new Viewport(0, 110, 6, 0);
        chartMax.setMaximumViewport(v);
        chartMax.setCurrentViewport(v);
        chartMin.setMaximumViewport(v);
        chartMin.setCurrentViewport(v);



        List<PointValue> values = new ArrayList();
        values.add(new PointValue(0, 12));
        values.add(new PointValue(1, 4));
        values.add(new PointValue(2, 23));
        values.add(new PointValue(3, 0));
        values.add(new PointValue(4, 17));
        values.add(new PointValue(5, 3));
        values.add(new PointValue(6, 11));

        List<PointValue> values1 = new ArrayList();
        values1.add(new PointValue(0, 13));
        values1.add(new PointValue(1, 1));
        values1.add(new PointValue(2, 12));
        values1.add(new PointValue(3, 15));
        values1.add(new PointValue(4, 1));
        values1.add(new PointValue(5, 13));
        values1.add(new PointValue(6, 0));

        //In most cased you can call data model methods in builder-pattern-like manner.
        Line line = new Line(values).setColor(ChartUtils.COLOR_ORANGE).setCubic(true);
        List<Line> lines = new ArrayList();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        //In most cased you can call data model methods in builder-pattern-like manner.
        Line line1 = new Line(values1).setColor(ChartUtils.COLOR_BLUE).setCubic(true);
        List<Line> lines1 = new ArrayList();
        lines1.add(line1);

        LineChartData data1 = new LineChartData();
        data1.setLines(lines1);

        chartMax.setLineChartData(data);
        chartMin.setLineChartData(data1);
        chartMin.setOnValueTouchListener(new LineChartOnValueSelectListener() {
            @Override
            public void onValueSelected(int i, int i1, PointValue pointValue) {
                Toast.makeText(MainActivity.this, String.valueOf(pointValue.getY()), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onValueDeselected() {

            }
        });

        ((MaterialWeatherApplication)getApplication()).
                getApi().getWeatherByName("wuhan",
                new MyCallBack());
    }

    class MyCallBack implements Callback {
        @Override
        public void success(Object o, Response response) {
            if(response != null){
                try {
                    String tt = new String(((TypedByteArray) response.getBody()).getBytes(), "UTF-8");
                    JSONObject data = new JSONObject(tt);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (JSONException e){

                }

            }
        }

        @Override
        public void failure(RetrofitError error) {
            if(error != null){

            }
        }
    }


}
