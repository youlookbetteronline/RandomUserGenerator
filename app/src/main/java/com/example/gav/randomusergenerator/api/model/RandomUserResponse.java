package com.example.gav.randomusergenerator.api.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RandomUserResponse{

	@SerializedName("results")
	private List<ResultsItem> results;

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	@Override
 	public String toString(){
		return 
			"RandomUserResponse{" + 
			"results = '" + results + '\'' +
			"}";
		}
}