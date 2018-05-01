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
class Programme {

    private String longName;
    private String synopsis;

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

    public Programme(String longName, String synopsis) {
        this.longName = longName;
        this.synopsis = synopsis;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Programme) {
            Programme programmeObj = (Programme) o;
            if (this == o) {
                return true;
            } else {
                return this.longName.equals(programmeObj.getLongName())
                        && this.synopsis.equals(programmeObj.getSynopsis());
            }
        }
        return false;
    }

}
