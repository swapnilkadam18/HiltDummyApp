package com.swapnil.hiltdummyapp.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class ApiResponse {

	@SerializedName("resultCount")
	private Integer resultCount;

	@SerializedName("results")
	private List<ResultsItem> results;

	public void setResultCount(Integer resultCount){
		this.resultCount = resultCount;
	}

	public Integer getResultCount(){
		return resultCount;
	}

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	@Override
	public int hashCode() {
		return Objects.hash(resultCount, results);
	}

}