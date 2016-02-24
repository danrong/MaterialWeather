package fm.material.weather.materialweather.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by fm on 2016/2/24.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int getLayoutId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        } else {
            throw new IllegalArgumentException("You must return a right contentView layout resource Id");
        }
    }

    public void goToActivity(Class clazz){
        startActivity(new Intent(this, clazz));
    }
}
