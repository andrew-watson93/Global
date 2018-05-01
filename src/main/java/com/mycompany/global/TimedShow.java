/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.global;

import java.time.ZonedDateTime;

/**
 *
 * @author andre
 */
public class TimedShow {

    private ZonedDateTime from;
    private ZonedDateTime to;
    private Episode episode;

    private static final String REGEX = "\\.\\d{3}";

    public TimedShow(Show show) {
        this.episode = show.getEpisode();
        String[] fromArr = show.getFrom().split(REGEX);
        String[] toArr = show.getTo().split(REGEX);
        this.from = ZonedDateTime.parse(fromArr[0] + fromArr[1] + "[Europe/London]");
        this.to = ZonedDateTime.parse(toArr[0] + toArr[1] + "[Europe/London]");

    }

    /**
     * @return the from
     */
    public ZonedDateTime getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(ZonedDateTime from) {
        this.from = from;
    }

    /**
     * @return the to
     */
    public ZonedDateTime getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(ZonedDateTime to) {
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
        if (o instanceof TimedShow) {
            TimedShow timedShowObj = (TimedShow) o;
            if (this == timedShowObj) {
                return true;
            } else {
                return this.from.equals(timedShowObj.getFrom())
                        && this.to.equals(timedShowObj.getTo())
                        && this.episode.equals(timedShowObj.getEpisode());
            }
        }
        return false;
    }

}
