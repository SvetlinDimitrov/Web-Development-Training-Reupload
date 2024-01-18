package org.example;

public class Match {
    private Integer totalPoints = 0;
    private final Integer limitPoints;

    public Match(Integer limitPoints) {

        this.limitPoints = limitPoints;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public Integer getLimitPoints() {
        return limitPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }
}
