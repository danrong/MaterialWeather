package fm.material.weather.materialweather.ui;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import fm.material.weather.materialweather.R;
import fm.material.weather.materialweather.base.BaseActivity;
import fm.material.weather.materialweather.ui.adapter.RecyclerViewAdapter;
import fm.material.weather.materialweather.ui.widget.GridRecyclerView;
import fm.material.weather.materialweather.utils.DeviceModelUtil;

/**
 * Created by fm on 2016/2/25.
 */
public class RecyclerActivity extends BaseActivity {

    @Bind(R.id.recycler_view)
    GridRecyclerView recyclerView;

    private List<String> items;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_recycler;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        initRecyclerView();
        if (DeviceModelUtil.isLessThanAndroidL()) {
            setRecyclerAdapter(recyclerView);
        }
    }


    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        setRecyclerAdapter(recyclerView);
        recyclerView.scheduleLayoutAnimation();
    }

    private void initRecyclerView() {
        items = new ArrayList();
        items.add("aaa1");
        items.add("aaa2");
        items.add("aaa3");
        items.add("aaa4");
        items.add("aaa5");
        items.add("aaa6");
        items.add("aaa7");
        items.add("aaa8");
        items.add("aaa9");
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
    }

    private void setRecyclerAdapter(RecyclerView recyclerView) {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(items);
//        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);
    }

}
