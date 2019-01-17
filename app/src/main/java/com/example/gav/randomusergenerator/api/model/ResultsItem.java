package com.example.gav.randomusergenerator.api.model;

import com.google.gson.annotations.SerializedName;

public class ResultsItem{

	@SerializedName("nat")
	private String nat;

	@SerializedName("gender")
	private String gender;

	@SerializedName("phone")
	private String phone;

	@SerializedName("dob")
	private Dob dob;

	@SerializedName("name")
	private Name name;

	@SerializedName("location")
	private Location location;

	@SerializedName("id")
	private Id id;

	@SerializedName("cell")
	private String cell;

	@SerializedName("email")
	private String email;

	@SerializedName("picture")
	private Picture picture;

	public void setNat(String nat){
		this.nat = nat;
	}

	public String getNat(){
		return nat;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setDob(Dob dob){
		this.dob = dob;
	}

	public Dob getDob(){
		return dob;
	}

	public void setName(Name name){
		this.name = name;
	}

	public Name getName(){
		return name;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setId(Id id){
		this.id = id;
	}

	public Id getId(){
		return id;
	}

	public void setCell(String cell){
		this.cell = cell;
	}

	public String getCell(){
		return cell;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setPicture(Picture picture){
		this.picture = picture;
	}

	public Picture getPicture(){
		return picture;
	}

	@Override
 	public String toString(){
		return 
			"ResultsItem{" + 
			"nat = '" + nat + '\'' + 
			",gender = '" + gender + '\'' + 
			",phone = '" + phone + '\'' + 
			",dob = '" + dob + '\'' + 
			",name = '" + name + '\'' +
			",location = '" + location + '\'' + 
			",id = '" + id + '\'' +
			",cell = '" + cell + '\'' + 
			",email = '" + email + '\'' + 
			",picture = '" + picture + '\'' + 
			"}";
		}
}