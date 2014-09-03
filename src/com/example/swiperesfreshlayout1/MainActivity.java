package com.example.swiperesfreshlayout1;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends ActionBarActivity {
 
 SwipeRefreshLayout swipeRefreshLayout;
 TextView textInfo;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);
  
  textInfo = (TextView)findViewById(R.id.info);
  
  swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipelayout);
  swipeRefreshLayout.setOnRefreshListener(onRefreshListener);
 }
 
 OnRefreshListener onRefreshListener = new OnRefreshListener(){

  @Override
  public void onRefresh() {
   textInfo.setText("WAIT: doing something");
   
   //simulate doing something
   new Handler().postDelayed(new Runnable() {

    @Override
    public void run() {
     swipeRefreshLayout.setRefreshing(false);
     textInfo.setText("DONE");
    }

   }, 2000);
  }};
}