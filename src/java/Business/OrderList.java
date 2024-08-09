package Business;

import java.util.ArrayList;
/**
 * Advance System Project
 * Constantaras / Blaine
 */

/*
 * Edited by Elijah A. 
 */
public class OrderList {
    
//    public Order[] oArry = new Order[10];
//    public int count = oArray.size();
    ArrayList<Order> oArry = new ArrayList<Order>();
    
//    public void addOrder(Order o) {
//        oArray.add(o);
//        count++;
//    }
    
    public void displayList() {
        
        for(int x=0; x < oArry.size(); x++) {
            oArry.get(x).display();
            System.out.println();
        }
    }
}

/*
 * Coded by: Elijah A
 * Description: Collects the product info as order(s) are being collected
 */
//class ProductInfoCollector {
//	
//	// Properties
//	public Products prodInfo[] = new Products[20];
//	public int count = prodInfo.size();
//	ArrayList<Products> prodInfo = new ArrayList<>();
//	
//	// Collects production
//	public void addProducts(Products prod) {
//		prodInfo.add(prod);
//	}
//
//	public void displayList() {
//		for (int x = 0; x < prodInfo.size(); x++) {
//			prodInfo.get(x).display();
//			System.out.println();
//		}
//	}
//}
