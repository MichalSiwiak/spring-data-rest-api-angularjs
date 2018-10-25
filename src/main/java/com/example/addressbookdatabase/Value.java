package com.example.addressbookdatabase;

public class Value {

    private String name;
    private String lastPrice;
    private String changeInNumber;
    private String changeInPercent;
    private String numberOfTransactions;
    private String turnover;
    private String time;
    private String sector;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getChangeInNumber() {
        return changeInNumber;
    }

    public void setChangeInNumber(String changeInNumber) {
        this.changeInNumber = changeInNumber;
    }

    public String getChangeInPercent() {
        return changeInPercent;
    }

    public void setChangeInPercent(String changeInPercent) {
        this.changeInPercent = changeInPercent;
    }

    public String getNumberOfTransactions() {
        return numberOfTransactions;
    }

    public void setNumberOfTransactions(String numberOfTransactions) {
        this.numberOfTransactions = numberOfTransactions;
    }

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Override
    public String toString() {
        return "Value{" +
                "name='" + name + '\'' +
                ", lastPrice='" + lastPrice + '\'' +
                ", changeInNumber='" + changeInNumber + '\'' +
                ", changeInPercent='" + changeInPercent + '\'' +
                ", numberOfTransactions='" + numberOfTransactions + '\'' +
                ", turnover='" + turnover + '\'' +
                ", time='" + time + '\'' +
                ", sector='" + sector + '\'' +
                '}';
    }
}
