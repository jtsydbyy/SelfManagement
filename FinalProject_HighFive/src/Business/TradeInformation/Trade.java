/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.TradeInformation;

import Business.UserAccount.UserAccount;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author yangyun
 */
public abstract class Trade {
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private TradeType tradeType;
    private String tradeID;
    
    public enum TradeType{
        
        Deposit("Deposit"), Purchase("Purchase"), Analysis("Analysis"), UpdateFund("UpdateFund");
        
        private String value;
        private TradeType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public Trade(TradeType tt){
        requestDate = new Date();
        tradeID = DatetoString(requestDate);
        this.tradeType = tt;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }
    
    public TradeType getTradeType() {
        return tradeType;
    }

    public void setTradeType(TradeType tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradeID() {
        return tradeID;
    }

    public void setTradeID(String tradeID) {
        this.tradeID = tradeID;
    }
    
    public static String DatetoString(java.util.Date savedDate){
        SimpleDateFormat dateformula = new SimpleDateFormat("MMddHHmmss");
        String DateString = new String();
        if(savedDate != null){
            DateString = dateformula.format(savedDate);
        }
        return DateString;
    }
    
    @Override
    public String toString(){
        return tradeID;
    }
}
