package com.example.lewen.ui.masinfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MasInfoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MasInfoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Más información");
    }

    public LiveData<String> getText() {
        return mText;
    }
}