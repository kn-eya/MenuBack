package com.example.back.back.dtos;

public class MarketLanguedtos {
    private int MarketLangueid;
    public Long Marketid;
    public Long Langueid;
    public String Traduction;
    public String getTraduction() {
        return Traduction;
    }

    public void setTraduction(String traduction) {
        Traduction = traduction;
    }


    public MarketLanguedtos() {
    }

    public MarketLanguedtos(int marketLangueid, Long marketid, Long langueid,String traduction) {
        MarketLangueid = marketLangueid;
        Marketid = marketid;
        Langueid = langueid;
        Traduction=traduction;
    }

    public int getMarketLangueid() {
        return MarketLangueid;
    }

    public void setMarketLangueid(int marketLangueid) {
        MarketLangueid = marketLangueid;
    }

    public Long getMarketid() {
        return Marketid;
    }

    public void setMarketid(Long marketid) {
        Marketid = marketid;
    }

    public Long getLangueid() {
        return Langueid;
    }

    public void setLangueid(Long langueid) {
        Langueid = langueid;
    }
}
