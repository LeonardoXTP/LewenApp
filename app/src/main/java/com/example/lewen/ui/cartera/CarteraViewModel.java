package com.example.lewen.ui.cartera;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CarteraViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CarteraViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Mis tarjetas");
    }

    public LiveData<String> getText() {
        return mText;
    }
}