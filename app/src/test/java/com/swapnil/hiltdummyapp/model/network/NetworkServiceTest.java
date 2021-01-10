package com.swapnil.hiltdummyapp.model.network;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.swapnil.hiltdummyapp.model.interfaces.NetworkServiceApi;
import com.swapnil.hiltdummyapp.model.pojo.ApiResponse;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;

import io.reactivex.Single;

public class NetworkServiceTest {

    @InjectMocks
    NetworkService service;

    @Mock
    NetworkServiceApi api;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        MockitoAnnotations.openMocks(this).close();
    }

    @Test
    public void getResponseFromApi() {
        Single<ApiResponse> responseSingle = Single.just(getJsonResponse("/Users/swapnilkadam/Desktop/Android_Projects/HiltDummyApp/app/src/main/assets/expectedResponse.json"));
        Mockito.when(api.getArtistData("alanwalker")).thenReturn(responseSingle);
        Single<ApiResponse> fromApi = service.getResponseFromApi("alanwalker");
        Assert.assertEquals(3,fromApi.blockingGet().getResults().size());
    }

    private ApiResponse getJsonResponse(String filePath) {
        File dir = new File(filePath);
        Type REVIEW_TYPE = new TypeToken<ApiResponse>() {
        }.getType();
        Gson gson = new Gson();
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(dir));
            ApiResponse data = gson.fromJson(reader, REVIEW_TYPE); // contains the whole reviews list
            return data; // prints to screen some values
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}