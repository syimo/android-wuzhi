package zs.com.wuzhi.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import zs.com.wuzhi.MainTab;
import zs.com.wuzhi.R;

/**
 * Created by zhangshuqing on 16/7/26.
 */
public class MainActivity extends BaseToolBarActivity{


    @BindView(R.id.tabHost)
    FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public boolean isBackHomeVisible() {
        return false;
    }

    @Override
    public String getToolBarTitle() {
        return getResources().getString(R.string.app_name);
    }

    @Override
    public BaseToolBarActivity.OnBackHomeClicklistener getOnBackHomeListener() {
        return null;
    }


    private void initView() {
        mTabHost.setup(this,getSupportFragmentManager(),R.id.tab_content);
        initTabs();
        mTabHost.setCurrentTab(0);
    }

    private void initTabs() {
        MainTab[] tabs= MainTab.values();
        for (int i=0;i<tabs.length;i++){
            MainTab tab= tabs[i];
            TabHost.TabSpec spec=mTabHost.newTabSpec(tab.getTag());
            View indicator= LayoutInflater.from(this).inflate(R.layout.tab_indicator,null);
            ImageView icon_iv= (ImageView) indicator.findViewById(R.id.iv_icon);
            icon_iv.setImageResource(tab.getResId());
            TextView tab_title= (TextView) indicator.findViewById(R.id.tab_title);
            tab_title.setText(tab.getTag());
            spec.setIndicator(indicator);
            mTabHost.addTab(spec,tab.getClazz(),null);
        }

    }
}
