package com.swapnil.hiltdummyapp.model.repository;

import com.swapnil.hiltdummyapp.model.interfaces.RepositoryCallback;
import com.swapnil.hiltdummyapp.model.network.NetworkService;
import com.swapnil.hiltdummyapp.model.pojo.ApiResponse;
import com.swapnil.hiltdummyapp.model.pojo.ArtistData;
import com.swapnil.hiltdummyapp.model.pojo.ResultsItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ArtistRepository {

    @Inject
    NetworkService service;

    @Inject
    RepositoryCallback callback;

    CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    public ArtistRepository() {
    }

    public void getArtistData(String artistName){
        disposable.add(service.getResponseFromApi(artistName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<ApiResponse>() {
                    @Override
                    public void onSuccess(@NonNull ApiResponse expectedRes) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                })

        );
    }

    public void onErrorReceived(@NonNull Throwable e) {
        callback.onResponseFailure(e.getLocalizedMessage());
        disposable.dispose();
    }

    public void onResReceived(@NonNull ApiResponse expectedRes) {
        List<ArtistData> sendData = new ArrayList<>();
        for (ResultsItem resultsItem: expectedRes.getResults()) {
            sendData.add(
                    new ArtistData(resultsItem.getArtistName(),
                            resultsItem.getTrackName(),
                            resultsItem.getCollectionName()));
        }
        callback.onResponseSuccess(sendData);
        disposable.dispose();
    }
}
