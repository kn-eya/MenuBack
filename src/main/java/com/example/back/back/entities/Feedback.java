package com.example.back.back.entities;
import javax.persistence.*;


import java.util.List;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Feedbackid;
    private String message;
    private Boolean visible;
    @ManyToOne
    private Market marketfeedback;
    @OneToOne
    private Commande commande;

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Feedback() {
    }

    public Feedback(Long feedbackid, String message, Boolean visible, Market marketfeedback) {
        Feedbackid = feedbackid;
        this.message = message;
        this.visible = visible;
        this.marketfeedback = marketfeedback;
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

    public Market getMarketfeedback() {
        return marketfeedback;
    }

    public void setMarketfeedback(Market marketfeedback) {
        this.marketfeedback = marketfeedback;
    }
}
