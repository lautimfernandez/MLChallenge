package com.example.mlchallenge.Base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class  BaseActivity <Presenter extends BasePresenter> extends AppCompatActivity {
   protected Presenter mPresenter;

    @NonNull
    protected abstract Presenter createPresenter(@NonNull final Context context);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mPresenter= createPresenter(this);
        mPresenter.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState){
        super.onSaveInstanceState(outState,outPersistentState);
        mPresenter.onSaveInstanceState(outState);
    }

    @Override
    public void onPause(){
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    public void onResume(){
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        mPresenter.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        mPresenter.onRequestPermissionsResult(requestCode,permissions,grantResults);
    }


}
