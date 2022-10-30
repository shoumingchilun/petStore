package com.chilun.petStore.pojo;

import java.math.BigDecimal;

/**
 * @auther 齿轮
 * @create 2022-10-26-15:16
 * 宠物类
 */
public class Pet {
    private long petID;
    private long species;
    private String name;
    private String description;
    private String picture;
    private BigDecimal prices;
    private long amount;//可购买数量


    public Pet() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
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

    public Pet(long petID, long species, String name, String description, String picture, BigDecimal prices, long amount) {
        this.petID = petID;
        this.species = species;
        this.name = name;
        this.description = description;
        this.picture = picture;
        this.prices = prices;
        this.amount = amount;
    }

    public long getPetID() {
        return petID;
    }

    public void setPetID(long petID) {
        this.petID = petID;
    }

    public long getSpecies() {
        return species;
    }

    public void setSpecies(long species) {
        this.species = species;
    }

    public BigDecimal getPrices() {
        return prices;
    }

    public void setPrices(BigDecimal prices) {
        this.prices = prices;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petID=" + petID +
                ", species=" + species +
                ", Name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", picture='" + picture + '\'' +
                ", prices=" + prices +
                ", amount=" + amount +
                '}';
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
