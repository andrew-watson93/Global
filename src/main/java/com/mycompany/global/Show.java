/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.global;

/**
 *
 * @author andre
 */
public class Show {

    public Show() {
    }

    /**
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * @return the episode
     */
    public Episode getEpisode() {
        return episode;
    }

    /**
     * @param episode the episode to set
     */
    public void setEpisode(Episode episode) {
        this.episode = episode;
    }

    private String from;
    private String to;
    private Episode episode;

    public Show(String from, String to, Episode episode) {
        this.from = from;
        this.to = to;
        this.episode = episode;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Show) {
            Show showObj = (Show) o;
            if (this == showObj) {
                return true;
            } else {
                return this.from.equals(showObj.getFrom())
                        && this.to.equals(showObj.getTo())
                        && this.episode.equals(showObj.episode);
            }
        }
        return false;
    }
}
