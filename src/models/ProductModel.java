/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author s4_juskov_d
 */
public class ProductModel {
    private String Name;
    private String Comment;
    private int Id;

    public String getName() {
        return Name;
    }
    
    public int getId() {
        return Id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }
       
    
    public ProductModel(String name, String comment, int Id)
    {
        this.Name = name;
        this.Comment = comment;
        this.Id = Id;
    }
            
            
}
