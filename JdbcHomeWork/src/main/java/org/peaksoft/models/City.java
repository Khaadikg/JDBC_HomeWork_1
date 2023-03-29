package org.peaksoft.models;

public class City {
    private int id;
    private String name;
    private int countries_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountries_id() {
        return countries_id;
    }

    public void setCountries_id(int countries_id) {
        this.countries_id = countries_id;
    }

    @Override
    public String toString() {
        return "id = " + getId() + "; name = " + getName() + "; location_id = " + getCountries_id();
    }
}
