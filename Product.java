/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

public class Product {
    
    private int id;
    private int quantity;
    private String name;
    private String category;
    private double price;
    private byte[] picture;
    
    public Product(int pid, String pname,int pquantity, double pprice,String pcategory, byte[] pimg)
    {
        this.id = pid;
        this.name = pname;
        this.quantity = pquantity;
        this.price = pprice;
        this.category = pcategory;
        this.picture = pimg;
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
    
    public String getCategory()
    {
        return  category;
    }
    
    public byte[] getImage()
    {
        return picture;
    }
    
}

