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
class Episode {

    /**
     * @return the programme
     */
    public Programme getProgramme() {
        return programme;
    }

    /**
     * @param programme the programme to set
     */
    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    private Programme programme;

    public Episode(Programme programme) {
        this.programme = programme;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Episode) {
            Episode episodeObj = (Episode) o;
            if (this == episodeObj) {
                return true;
            } else {
                return this.programme.equals(episodeObj.getProgramme());
            }
        }
        return false;
    }

}
