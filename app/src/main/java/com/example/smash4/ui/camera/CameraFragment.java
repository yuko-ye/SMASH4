package com.example.smash4.ui.camera;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.smash4.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class CameraFragment extends Fragment  {

    private CameraViewModel homeViewModel;


    //3/31paste
@Override
    public View onCreateView( LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_camera, container, false);
//3/29.31paste
        Button cameraButton = (Button)v. findViewById (R.id.cameraButton);
        cameraButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //コピペした　3/25
                IntentIntegrator integrator= IntentIntegrator.forSupportFragment(CameraFragment.this);
                integrator.initiateScan();

            }
        });
        homeViewModel =
                new ViewModelProvider(this).get(CameraViewModel.class);
        View root = inflater.inflate(R.layout.fragment_camera, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;

    }





    //コピペした 3/25
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            Log.d("readQR", result.getContents());
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}

