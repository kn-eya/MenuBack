package com.example.back.back.dtos;

public class Feedbackdtos {
    private Long Feedbackid;
    private String message;
    private Boolean visible;
    private Long commandeId;
    private Long Marketid;

    public Feedbackdtos() {
    }

    public Feedbackdtos(Long feedbackid, String message, Boolean visible, Long commandeId, Long marketid) {
        Feedbackid = feedbackid;
        this.message = message;
        this.visible = visible;
        this.commandeId = commandeId;
        Marketid = marketid;
    }

    public Long getFeedbackid() {
        return Feedbackid;
    }

    public void setFeedbackid(Long feedbackid) {
        Feedbackid = feedbackid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Long getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(Long commandeId) {
        this.commandeId = commandeId;
    }

    public Long getMarketid() {
        return Marketid;
    }

    public void setMarketid(Long marketid) {
        Marketid = marketid;
    }
}
