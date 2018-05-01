/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.global;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author andre
 */
public class Show {

    private Date from;
    private Date to;
    private Episode episode;

    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    public Show(String from, String to, Episode episode) throws ParseException {
        this.from = DATE_FORMAT.parse(from);
        this.to = DATE_FORMAT.parse(to);
        this.episode = episode;
    }

    public Show() {
    }

    /**
     * @return the from
     */
    public Date getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(Date from) {
        this.from = from;
    }

    /**
     * @return the to
     */
    public Date getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(Date to) {
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
