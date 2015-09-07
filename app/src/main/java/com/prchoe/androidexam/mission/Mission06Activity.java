package com.prchoe.androidexam.mission;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.prchoe.androidexam.R;
import com.prchoe.androidexam.interfaces.Layout;

public class Mission06Activity extends AppCompatActivity implements Layout {

    private Button mToggleButton;
    private Button mSendButton;
    private LinearLayout mSearchBar;
    private EditText mHttpET;
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission06);

        initView();
        initListener();
    }


    @Override
    public void initView() {
        mToggleButton = (Button)findViewById(R.id.button_toggle);
        mSendButton = (Button)findViewById(R.id.button_send);
        mSearchBar = (LinearLayout)findViewById(R.id.layout);
        mHttpET = (EditText)findViewById(R.id.http_edit_text);
        mWebView = (WebView)findViewById(R.id.webView);
    }

    @Override
    public void initListener() {
        mToggleButton.setOnClickListener(this);
        mSendButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_send:

                break;
            case R.id.button_toggle:
                if(mSearchBar.getVisibility() == View.GONE) {
                    mToggleButton.setText("△");

                    mSearchBar.setVisibility(View.VISIBLE);
                } else {
                    mToggleButton.setText("▽");
                    mSearchBar.setVisibility(View.GONE);
                }
                break;
        }

    }
}
