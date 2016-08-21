package com.example.administrator.ios;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Administrator on 2016/8/20.
 */
public class tab1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

          View go = inflater.inflate(R.layout.tab1,container,false);
        Button bu= (Button) go.findViewById(R.id.tab1);


        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"tab1",Snackbar.LENGTH_LONG).show();
            }
        });
        return go;
    }
}
