package com.dhl.textswicher;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class TextSwitcher_ExampleActivity extends Activity implements ViewFactory, OnClickListener {

	private TextSwitcher tvSwitcher = null;
	private Button btn_Count = null;
	private int mCounter = 0;

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    
        getBasicInfo();
	}
	
	private void getBasicInfo(){
		
		tvSwitcher = (TextSwitcher)findViewById(R.id.txt_swithcer);
		tvSwitcher.setFactory(this);
		
		btn_Count = (Button)findViewById(R.id.btn_count);
		btn_Count.setOnClickListener(this);
		
		Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        
        tvSwitcher.setInAnimation(in);
        tvSwitcher.setOutAnimation(out);
        
        updateCounter();
	}

	private void updateCounter() {
		tvSwitcher.setText(String.valueOf(mCounter));
    }

	@Override
	public void onClick(View v) {
		 mCounter++;
	     updateCounter();
	}

	@Override
	public View makeView() {
		TextView t = new TextView(this);
        t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
        t.setTextSize(36);
        return t;
	}
}