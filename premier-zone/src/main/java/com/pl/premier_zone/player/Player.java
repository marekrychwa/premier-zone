package com.pl.premier_zone.player;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "player_statistic")
public class Player {

    @Id
    private String playerName;    // w bazie: player_name
    private String nation;
    private String position;
    private String age;           // String (np. "25-100")
    private Double matchesPlayed; // w bazie: matches_played
    private Double starts;
    private String minutesPlayed; // w bazie: minutes_played
    private Double goals;
    private Double assists;
    private Double penaltiesScored; // w bazie: penalties_scored
    private Double yellowCards;     // w bazie: yellow_cards
    private Double redCards;        // w bazie: red_cards
    private Double expectedGoals;   // w bazie: expected_goals
    private Double expectedAssists; // w bazie: expected_assists
    private String teamName;        // w bazie: team_name

    public Player() {
    }

    public Player(String playerName, String nation, String position, String age, Double matchesPlayed, Double starts, String minutesPlayed, Double goals, Double assists, Double penaltiesScored, Double yellowCards, Double redCards, Double expectedGoals, Double expectedAssists, String teamName) {
        this.playerName = playerName;
        this.nation = nation;
        this.position = position;
        this.age = age;
        this.matchesPlayed = matchesPlayed;
        this.starts = starts;
        this.minutesPlayed = minutesPlayed;
        this.goals = goals;
        this.assists = assists;
        this.penaltiesScored = penaltiesScored;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.expectedGoals = expectedGoals;
        this.expectedAssists = expectedAssists;
        this.teamName = teamName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Double getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(Double matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public Double getStarts() {
        return starts;
    }

    public void setStarts(Double starts) {
        this.starts = starts;
    }

    public String getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(String minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    public Double getGoals() {
        return goals;
    }

    public void setGoals(Double goals) {
        this.goals = goals;
    }

    public Double getAssists() {
        return assists;
    }

    public void setAssists(Double assists) {
        this.assists = assists;
    }

    public Double getPenaltiesScored() {
        return penaltiesScored;
    }

    public void setPenaltiesScored(Double penaltiesScored) {
        this.penaltiesScored = penaltiesScored;
    }

    public Double getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(Double yellowCards) {
        this.yellowCards = yellowCards;
    }

    public Double getRedCards() {
        return redCards;
    }

    public void setRedCards(Double redCards) {
        this.redCards = redCards;
    }

    public Double getExpectedGoals() {
        return expectedGoals;
    }

    public void setExpectedGoals(Double expectedGoals) {
        this.expectedGoals = expectedGoals;
    }

    public Double getExpectedAssists() {
        return expectedAssists;
    }

    public void setExpectedAssists(Double expectedAssists) {
        this.expectedAssists = expectedAssists;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}