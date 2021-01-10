package com.swapnil.hiltdummyapp.model.pojo;

import com.google.gson.annotations.SerializedName;

public class ArtistData {

    @SerializedName("artistName")
    private String artistName;
    @SerializedName("trackName")
    private String artistTrack;
    @SerializedName("collectionName")
    private String artistCollection;

    public ArtistData(String artistName, String artistTrack, String artistCollection) {
        this.artistName = artistName;
        this.artistTrack = artistTrack;
        this.artistCollection = artistCollection;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistTrack() {
        return artistTrack;
    }

    public void setArtistTrack(String artistTrack) {
        this.artistTrack = artistTrack;
    }

    public String getArtistCollection() {
        return artistCollection;
    }

    public void setArtistCollection(String artistCollection) {
        this.artistCollection = artistCollection;
    }
}
