package com.swapnil.hiltdummyapp.model.interfaces;

import com.swapnil.hiltdummyapp.model.pojo.ApiResponse;
import com.swapnil.hiltdummyapp.model.utility.Utils;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkServiceApi {

    @GET(Utils.BASE_URL)
    Single<ApiResponse> getArtistData(@Query(value = "term",encoded = true) String artistName);
}
