package com.example.andresteran_i014213.projectofinal_sti.Models;

/**
 * Created by kenet on 27/05/2017.
 */

public class Bus {

    private long id;
    private String Route;
    private String neighborhood;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoute() {
        return Route;
    }

    public void setRoute(String route) {
        Route = route;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}


