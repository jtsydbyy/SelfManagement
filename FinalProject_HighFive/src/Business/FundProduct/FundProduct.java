/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.FundProduct;

import Business.Enterprise.Enterprise;

/**
 *
 * @author tuantuan
 */
public class FundProduct {
    private String name;
    private String description;
    private String purchaseDate;
    private String redemptionDate;
    private int id;
    private static int count = 1;
    private FundType fundType;
    private Enterprise enterprise;
    private double purchasePrice;
    private double redemptionPrice;
    private int quantity;
    private int sales = 0;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
      public FundProduct() {
        id = count;
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getRedemptionDate() {
        return redemptionDate;
    }

    public void setRedemptionDate(String redemptionDate) {
        this.redemptionDate = redemptionDate;
    }

   
   
      public int getId() {
        return id;
    }
    
    public enum FundType{
        StockFund("SF"),
        BondFund("BF"),
        MoneyMarketFund("MMF"),
        CommingledFund("CF");
        private String value;

        private FundType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
        
    }

    public FundType getFundType() {
        return fundType;
    }
    public void setFundType(FundType type){
      this.fundType = type;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getRedemptionPrice() {
        return redemptionPrice;
    }

    public void setRedemptionPrice(double redemptionPrice) {
        this.redemptionPrice = redemptionPrice;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
