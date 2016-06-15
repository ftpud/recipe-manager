/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author s4_juskov_d
 */
public class RecipeModel {
    private int Id; 
    private String Name;
    private String Type;
    private String Recipe;
    private ArrayList<ProductModel> Products;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getRecipe() {
        return Recipe;
    }

    public void setRecipe(String Recipe) {
        this.Recipe = Recipe;
    }

    public ArrayList<ProductModel> getProducts() {
        return Products;
    }

    public void setProducts(ArrayList<ProductModel> Products) {
        this.Products = Products;
    }
////    
    
    public RecipeModel(String Name, String Type, String Recipe, int Id, ArrayList<ProductModel> Products )
    {
        this.Id = Id;
        this.Name = Name;
        this.Type = Type;
        this.Recipe = Recipe;
        this.Products = Products;
                
    }
    
}
