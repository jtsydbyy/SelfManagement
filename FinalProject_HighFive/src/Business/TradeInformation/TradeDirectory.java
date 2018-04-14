/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.TradeInformation;

import Business.Organization.BankSavingsOrganization;
import Business.Organization.BankTradeOrganization;
import Business.Organization.Organization;
import java.util.ArrayList;

/**
 *
 * @author yangyun
 */
public class TradeDirectory {
    private ArrayList<Trade> tradeList;
    
    public TradeDirectory(){
        tradeList = new ArrayList<>();
    }

    public ArrayList<Trade> getTradeList() {
        return tradeList;
    }
    
    public void deleteTrade(Trade t){
        tradeList.remove(t);
    }
    
//    public Trade createTrade(Trade.TradeType type){
//        Trade tt = null;
//        if (type.getValue().equals(Trade.TradeType.Deposit.getValue())){
//            tt = new PaymentTrade(Trade.TradeType.Deposit);
//            tradeList.add(tt);
//        }
//        return tt;
//    }
}
