package org.example;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Dogs implements Serializable {
    @Serial
    private static final long serialVersionUID = 1023021987L;

    private String name;
    private int age;
    private String foodLikes;
    private boolean isMicrochipped;

    public Dogs(String name, int age, String foodLikes, boolean isMicrochipped) {
        this.name = name;
        this.age = age;
        this.foodLikes = foodLikes;
        this.isMicrochipped = isMicrochipped;
    }

    public Dogs() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFoodLikes() {
        return foodLikes;
    }

    public void setFoodLikes(String foodLikes) {
        this.foodLikes = foodLikes;
    }

    public boolean isMicrochipped() {
        return isMicrochipped;
    }

    public void setMicrochipped(boolean microchipped) {
        isMicrochipped = microchipped;
    }

    @Override
    public String toString() {
        return "Dogs{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", foodLikes='" + foodLikes + '\'' +
                ", isMicrochipped=" + isMicrochipped +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dogs dogs = (Dogs) o;
        return age == dogs.age && isMicrochipped == dogs.isMicrochipped && Objects.equals(name, dogs.name) && Objects.equals(foodLikes, dogs.foodLikes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, foodLikes, isMicrochipped);
    }
}
