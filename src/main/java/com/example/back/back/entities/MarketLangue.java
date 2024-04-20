package com.example.back.back.entities;
import javax.persistence.*;


@Entity
public class MarketLangue
{@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MarketLangueid;
    public String traduction;
    @ManyToOne
    @JoinColumn  ( name ="Marketid")
    private Market market;
    @ManyToOne
    @JoinColumn( name="Langueid")
    private Langue langue;

    public MarketLangue(int marketLangueid, String traduction, Market market, Langue langue) {
        MarketLangueid = marketLangueid;
        this.traduction = traduction;
        this.market = market;
        this.langue = langue;
    }

    public MarketLangue() {
    }

    public int getMarketLangueid() {
        return MarketLangueid;
    }

    public void setMarketLangueid(int marketLangueid) {
        MarketLangueid = marketLangueid;
    }

    public String getTraduction() {
        return traduction;
    }

    public void setTraduction(String traduction) {
        this.traduction = traduction;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public Langue getLangue() {
        return langue;
    }

    public void setLangue(Langue langue) {
        this.langue = langue;
    }
}
