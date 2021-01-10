package com.swapnil.hiltdummyapp.model.interfaces;


import com.swapnil.hiltdummyapp.model.pojo.ArtistData;

import java.util.List;

public interface RepositoryCallback {

    void onResponseSuccess(List<ArtistData> artistData);

    void onResponseFailure(String errorReason);
}
