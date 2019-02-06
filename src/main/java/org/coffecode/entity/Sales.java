package org.coffecode.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;


@Entity
@Table(name = "sales")
public class Sales {

    @Id
    @GeneratedValue
    private int id;

   /* private String region;*/
    private String country;
    private String itemType;
   /* private String salesChannel;*/
    private String orderPriority;
   /* private Timestamp orderDate;*/
   /* private String orderId;*/
   /* private Timestamp shipDate;*/
    private int unitsSold;
    private double unitsPrice;
    /*private double unitsCost;
    private double totalRevenue;*/
    private double totalCost;
   /* private double totalProfit;*/

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", itemType='" + itemType + '\'' +
                ", orderPriority='" + orderPriority + '\'' +
                ", unitsSold=" + unitsSold +
                ", unitsPrice=" + unitsPrice +
                ", totalCost=" + totalCost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sales sales = (Sales) o;
        return id == sales.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getOrderPriority() {
        return orderPriority;
    }

    public void setOrderPriority(String orderPriority) {
        this.orderPriority = orderPriority;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(int unitsSold) {
        this.unitsSold = unitsSold;
    }

    public double getUnitsPrice() {
        return unitsPrice;
    }

    public void setUnitsPrice(double unitsPrice) {
        this.unitsPrice = unitsPrice;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
