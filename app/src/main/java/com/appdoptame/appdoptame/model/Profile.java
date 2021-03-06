package com.appdoptame.appdoptame.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jufarangoma on 19/09/17.
 */


public  class Profile implements Serializable{

    private String user;

    @SerializedName("description")
    @Expose
    private String description;

    private String genre;

    @SerializedName("age")
    @Expose
    private String age;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("url")
    @Expose
    private String photoUrl;

    @SerializedName("location")
    @Expose
    private String location;

    @SerializedName("breed")
    @Expose
    private String breed;


    @SerializedName("photos")
    @Expose
    private List<String> photos;

    @SerializedName("Sterilization")
    @Expose
    private String sterilization;

    @Override
    public String toString() {
        return "Profile{" +
                "User='" + user + '\'' +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", age='" + age + '\'' +
                ", name='" + name + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", location='" + location + '\'' +
                ", breed='" + breed + '\'' +
                ", photos=" + photos +
                ", Sterilization=" + sterilization +
                '}';
    }

    public Profile(){
    }

    public Profile(String user, String description, String genre, String age, String name, String photoUrl, String location, String breed, List<String> photos, String sterilization) {
        this.user = user;
        this.description = description;
        this.genre = genre;
        this.age = age;
        this.name = name;
        this.photoUrl = photoUrl;
        this.location = location;
        this.breed = breed;
        this.photos = photos;
        this.sterilization = sterilization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getPhotos() {return photos;}

    public void setPhotos(List<String> photos) {this.photos = photos;}

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSterilization() {
        return sterilization;
    }

    public void setSterilization(String sterilization) {
        this.sterilization = sterilization;
    }

}
