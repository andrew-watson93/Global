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
public class SimpleTimedShow {

    private String from;
    private String to;
    private String longName;
    private String synopsis;

    public SimpleTimedShow(TimedShow timedShow) {
        this.from = timedShow.getFrom().toString();
        this.to = timedShow.getTo().toString();
        this.longName = timedShow.getEpisode().getProgramme().getLongName();
        this.synopsis = timedShow.getEpisode().getProgramme().getSynopsis();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof SimpleTimedShow) {
            SimpleTimedShow simpleTimedShow = (SimpleTimedShow) o;
            if (this == simpleTimedShow) {
                return true;
            } else {
                return this.from.equals(simpleTimedShow.getFrom())
                        && this.to.equals(simpleTimedShow.getTo())
                        && this.longName.equals(simpleTimedShow.getLongName())
                        && this.synopsis.equals(simpleTimedShow.getSynopsis());

            }
        }
        return false;
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
     * @return the longName
     */
    public String getLongName() {
        return longName;
    }

    /**
     * @param longName the longName to set
     */
    public void setLongName(String longName) {
        this.longName = longName;
    }

    /**
     * @return the synopsis
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * @param synopsis the synopsis to set
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

}
