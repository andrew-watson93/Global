/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.global;

import java.util.List;

/**
 *
 * @author andre
 */
class ShowsByDay {

    private String dateString;
    private List<ShowDto> shows;

    /**
     * @return the dateString
     */
    public String getDateString() {
        return dateString;
    }

    /**
     * @param dateString the dateString to set
     */
    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    /**
     * @return the shows
     */
    public List<ShowDto> getShows() {
        return shows;
    }

    /**
     * @param shows the shows to set
     */
    public void setShows(List<ShowDto> shows) {
        this.shows = shows;
    }

}
