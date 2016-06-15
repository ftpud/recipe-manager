/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipemanager;

import gui.MainWindow;
import java.util.ArrayList;
import webgui.GuiServer;

/**
 *
 * @author s4_juskov_d
 */
public class RecipeManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MainWindow win = new MainWindow();
        win.setVisible(true);
        
        RecipeProvider.DatebaseConnect();
        
        // RecipeProvider.DropTables();
        // RecipeProvider.CreateTables();
        
        
        /*ArrayList<ProductModel> v = RecipeProvider.GetProductList();
        for(ProductModel p : v)
        {
            System.out.println(p.getName());
        }*/
        
        
        GuiServer.RunServer(8080);
        
        
       // RecipeProvider.DatebaseCloseConnection();
    }
    
}
