/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webgui;

import com.sun.net.httpserver.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import models.ProductModel;
import models.RecipeModel;
import recipemanager.RecipeProvider;


/**
 *
 * @author Dmitrijs Juškovs
 */
public class GuiServer {
    public static void RunServer(int port)
    {
        try {
            HttpServer server = HttpServer.create();
            server.bind(new InetSocketAddress(port), 0);
            server.createContext("/",  new RootHandler() );
            server.createContext("/api/getProductList",  new getProductListHandler() );
            server.createContext("/api/getGroupList",  new getGroupListHandler() );
            server.createContext("/api/getRecipeByGroup",  new getRecipeListByGroupHandler());
            server.createContext("/api/getRecipeByProductId",  new getRecipeListByProductIdHandler());
            server.start();
                    
        } catch (IOException ex) {
            Logger.getLogger(GuiServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    static class RootHandler implements HttpHandler {
        
    
       static String htmlPage = null;
        
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            StringBuilder builder = new StringBuilder();
              
           // if(htmlPage == null)
           // {
                InputStream in = getClass().getResourceAsStream("/webgui/root.html");
                BufferedReader fr = new BufferedReader( new InputStreamReader(in, "utf-8") );
                String line;
                while((line = fr.readLine()) != null)
                {
                    builder.append(line);
                }
                htmlPage = builder.toString();
           /* } 
            else
            {
                builder.append(htmlPage);
            }*/
            
            byte[] bytes = builder.toString().getBytes();
            exchange.sendResponseHeaders(200, bytes.length);

            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
        }
    }
    
     static class getProductListHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            StringBuilder builder = new StringBuilder();
           
            ArrayList<ProductModel> products = RecipeProvider.GetProductList();
            JSONObject obj = new JSONObject();
            JSONArray list = new JSONArray();
            for(ProductModel p:products)
            {
                JSONObject pObj = new JSONObject();
                pObj.put("name", p.getName());
                pObj.put("id", p.getId());
                list.add(pObj);
            }
            obj.put("products", list);
            
            builder.append(obj.toJSONString());

            byte[] bytes = builder.toString().getBytes();
            exchange.sendResponseHeaders(200, bytes.length);

            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
        }
    }
     
     
      static class getGroupListHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            StringBuilder builder = new StringBuilder();
           
            ArrayList<String> groups = RecipeProvider.GetGroupList();
            JSONObject obj = new JSONObject();
            JSONArray list = new JSONArray();
            for(String s:groups)
                list.add(s);
            
            obj.put("groups", list);            
            builder.append(obj.toJSONString());

            byte[] bytes = builder.toString().getBytes();
            exchange.sendResponseHeaders(200, bytes.length);

            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
        }
    }
      
      
    static class getRecipeListByGroupHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            StringBuilder builder = new StringBuilder();           
            String group = exchange.getRequestURI().getQuery();                        
            ArrayList<RecipeModel> recipes = RecipeProvider.GetRecipeList(group,"%");                                    
            JSONObject obj = new JSONObject();
            JSONArray list = new JSONArray();
            for(RecipeModel r:recipes)
            {
                JSONObject pObj = new JSONObject();
                pObj.put("name", r.getName());                
                pObj.put("recipe", r.getRecipe());                
                
            
                JSONArray product_list = new JSONArray();
                for(ProductModel p:r.getProducts())
                {
                    JSONObject prodObj = new JSONObject();
                    prodObj.put("name", p.getName());                
                    prodObj.put("comment", p.getComment());                
                    product_list.add(prodObj);
                }
                
                pObj.put("products", product_list);
                list.add(pObj);
            }
            obj.put("recipes", list);
            
            builder.append(obj.toJSONString());

            byte[] bytes = builder.toString().getBytes();
            exchange.sendResponseHeaders(200, bytes.length);

            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
        }
    }
    
    static class getRecipeListByProductIdHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            StringBuilder builder = new StringBuilder();           
            String group = exchange.getRequestURI().getQuery();                        
            ArrayList<RecipeModel> recipes = RecipeProvider.GetRecipeListByProductId(Integer.parseInt(group));
            JSONObject obj = new JSONObject();
            JSONArray list = new JSONArray();
            for(RecipeModel r:recipes)
            {
                JSONObject pObj = new JSONObject();
                pObj.put("name", r.getName());                
                pObj.put("recipe", r.getRecipe());                
                
            
                JSONArray product_list = new JSONArray();
                for(ProductModel p:r.getProducts())
                {
                    JSONObject prodObj = new JSONObject();
                    prodObj.put("name", p.getName());                
                    prodObj.put("comment", p.getComment());                
                    product_list.add(prodObj);
                }
                
                pObj.put("products", product_list);
                list.add(pObj);
            }
            obj.put("recipes", list);
            
            builder.append(obj.toJSONString());

            byte[] bytes = builder.toString().getBytes();
            exchange.sendResponseHeaders(200, bytes.length);

            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
        }
    }
}
