/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

public class Bill {
    
    private int Billid;
    private int id;
    private int quantity;
    private String name;
    private double total;
    private double price;
    private byte[] picture;
    private int empID;
    
    public Bill(int pBillid, int pid, String pname,int pquantity, double pprice,int pempID)
    {
        this.Billid = pBillid;
        this.id = pid;
        this.name = pname;
        this.quantity = pquantity;
        this.price = pprice;
        this.empID = pempID;
        
    }
    
    public void setTotal(double ptotal)
    {
        this.total = ptotal;
    }
    public int getBillId()
    {
        return Billid;
    }
    public int getEmpId()
    {
        return empID;
    }
    
    public int getId()
    {
        return id;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public String getName()
    {
        return name;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public double getTotal()
    {
        return  total;
    }
    
    public byte[] getImage()
    {
        return picture;
    }
    
}
