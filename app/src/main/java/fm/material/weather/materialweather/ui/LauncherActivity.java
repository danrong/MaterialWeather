package fm.material.weather.materialweather.ui;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;
import fm.material.weather.materialweather.R;
import fm.material.weather.materialweather.base.BaseActivity;
import fm.material.weather.materialweather.utils.AnimationUtil;

/**
 * Created by fm on 2016/2/24.
 */
public class LauncherActivity extends BaseActivity {

    @Bind(R.id.layout_logo)
    LinearLayout layoutLogo;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_logo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        AnimationUtil.fall(layoutLogo, 2000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                goToActivity(MainActivity.class);
                finish();
            }
        }, 2000);
    }
}
