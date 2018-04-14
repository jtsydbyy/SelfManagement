/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.FundProduct;

import java.util.ArrayList;

/**
 *
 * @author tuantuan
 */
public class FundProductDirectory {
    private ArrayList<FundProduct> fundProductsCatalog;

    public FundProductDirectory() {
        fundProductsCatalog = new ArrayList<>();
    }

    public ArrayList<FundProduct> getFundProductDirectory() {
        return fundProductsCatalog;
    }
    
    public FundProduct addFundProduct() {
        FundProduct fp = new FundProduct();
        fundProductsCatalog.add(fp);
        return fp;
    }
    
    public void plusFundProduct(FundProduct fp){
        fundProductsCatalog.add(fp);
    }
    
    public void deleteFundProduct(FundProduct fp){
    fundProductsCatalog.remove(fp);
    }
}
