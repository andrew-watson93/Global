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
class ShowDto {

    private String from;
    private String to;
    private String longName;
    private String synopsis;

    public ShowDto(TimedShow timedShow) {
        this.from = timedShow.getFrom().toString();
        this.to = timedShow.getTo().toString();
        this.longName = timedShow.getEpisode().getProgramme().getLongName();
        this.synopsis = timedShow.getEpisode().getProgramme().getSynopsis();
    }

}
