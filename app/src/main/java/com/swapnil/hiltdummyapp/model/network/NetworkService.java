package com.swapnil.hiltdummyapp.model.network;

import com.swapnil.hiltdummyapp.model.interfaces.NetworkServiceApi;
import com.swapnil.hiltdummyapp.model.pojo.ApiResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class NetworkService {

    @Inject
    NetworkServiceApi networkServiceApi;

    @Inject
    public NetworkService() {
    }

    public Single<ApiResponse> getResponseFromApi(String artist){
        return networkServiceApi.getArtistData(artist);
    }
}
