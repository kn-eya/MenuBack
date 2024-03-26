package com.example.back.back.dtos;

public class Commandedtos {
    private Long Commandeid;
    private String reference;
    private int tablenumb;
    private String name;
    private String statuscommand;
    public Long Marketid;

    public Long getFeedbackid() {
        return Feedbackid;
    }

    public void setFeedbackid(Long feedbackid) {
        Feedbackid = feedbackid;
    }

    public Long Feedbackid;

    public Commandedtos() {
    }

    public Commandedtos(Long commandeid, String reference, int tablenumb, String name, String statuscommand) {
        Commandeid = commandeid;
        this.reference = reference;
        this.tablenumb = tablenumb;
        this.name = name;
        this.statuscommand = statuscommand;

    }


    public Long getCommandeid() {
        return Commandeid;
    }

    public void setCommandeid(Long commandeid) {
        Commandeid = commandeid;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getTablenumb() {
        return tablenumb;
    }

    public void setTablenumb(int tablenumb) {
        this.tablenumb = tablenumb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatuscommand() {
        return statuscommand;
    }

    public void setStatuscommand(String statuscommand) {
        this.statuscommand = statuscommand;
    }

    public Long getMarketid() {
        return Marketid;
    }

    public void setMarketid(Long marketid) {
        Marketid = marketid;
    }
}
