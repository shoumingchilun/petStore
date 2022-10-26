package com.chilun.petStore.pojo;

/**
 * @auther 齿轮
 * @create 2022-10-26-15:16
 * 宠物类
 */
public class Pet {
    private int petID;
    private int species;
    private String Name;
    private String description;
    private String picture;
    private float prices;
    private int amount;//可购买数量

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Pet(int petID, int species, String name, String description, String picture, float prices, int amount) {
        this.petID = petID;
        this.species = species;
        Name = name;
        this.description = description;
        this.picture = picture;
        this.prices = prices;
        this.amount = amount;
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public int getSpecies() {
        return species;
    }

    public void setSpecies(int species) {
        this.species = species;
    }

    public float getPrices() {
        return prices;
    }

    public void setPrices(float prices) {
        this.prices = prices;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
