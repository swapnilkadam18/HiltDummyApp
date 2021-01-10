package com.swapnil.hiltdummyapp.di;

import com.swapnil.hiltdummyapp.model.interfaces.NetworkServiceApi;
import com.swapnil.hiltdummyapp.model.utility.Utils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@InstallIn(ApplicationComponent.class)
@Module
public class NetworkModule {

    @Provides
    @Singleton
    Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(Utils.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    NetworkServiceApi provideNetworkServiceApi(Retrofit retrofit){
        return retrofit.create(NetworkServiceApi.class);
    }
}
