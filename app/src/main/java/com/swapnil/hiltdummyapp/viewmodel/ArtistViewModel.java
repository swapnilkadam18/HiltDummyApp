package com.swapnil.hiltdummyapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.swapnil.hiltdummyapp.model.interfaces.RepositoryCallback;
import com.swapnil.hiltdummyapp.model.pojo.ArtistData;
import com.swapnil.hiltdummyapp.model.repository.ArtistRepository;

import java.util.List;

import javax.inject.Inject;

public class ArtistViewModel extends ViewModel implements RepositoryCallback {

    @Inject
    ArtistRepository repository;

    public MutableLiveData<List<ArtistData>> apiData = new MutableLiveData<>();
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    public MutableLiveData<Boolean> isError = new MutableLiveData<>();

    @Inject
    public ArtistViewModel() {

    }

    public void getDataFromApi(String artistName){
        isLoading.setValue(true);
        repository.getArtistData(artistName);
    }

    @Override
    public void onResponseSuccess(List<ArtistData> artistData) {
        apiData.setValue(artistData);
        isLoading.setValue(false);
    }

    @Override
    public void onResponseFailure(String errorReason) {
        isError.setValue(true);
        isLoading.setValue(false);
    }
}
