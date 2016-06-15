package recipemanager;

import models.RecipeModel;
import models.ProductModel;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author s4_juskov_d
 */
public class RecipeProvider 
{
    
    public static ArrayList<RecipeModel> GetRecipeList(String type, String filter)
    {     
        ArrayList<RecipeModel> outList = new ArrayList<>();
        RecipeModel m = null;
        try{            
            pstmt = c.prepareStatement("select * from RECIPES where NAME like ? and TYPE like ?");
            pstmt.setString(1, filter);
            pstmt.setString(2, type);
            
            ResultSet r = pstmt.executeQuery();
            while(r.next())
            {
            
            int id = r.getInt("ID");
            ArrayList<ProductModel> Products = new ArrayList<>();
            
            /**/
            pstmt = c.prepareStatement("SELECT "
                    + "PRODUCTS.\"NAME\" as \"NAME\", "
                    + "PRODUCTS.\"ID\" as \"ID\", "
                    + "PRODUCTS_IN_RECIPE.COMMENT as COMMENT "
                    + "FROM PRODUCTS_IN_RECIPE JOIN PRODUCTS "
                    + "ON PRODUCTS_IN_RECIPE.PRODUCT_ID = PRODUCTS.ID "
                    + "WHERE PRODUCTS_IN_RECIPE.RECIPE_ID=?;");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                Products.add(new ProductModel(rs.getString("NAME"), rs.getString("COMMENT"), rs.getInt("ID")));
            }
            /**/
            
            m = new RecipeModel(
                    r.getString("NAME"),
                    r.getString("TYPE"),
                    r.getString("RECIPE"), 
                    id, 
                    Products);
     
            outList.add(m);
            }
            
          }catch(Exception e){
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );                
        }
        
        return outList;
    }
    
    
     public static ArrayList<RecipeModel> GetRecipeListByProductId(int pid)
    {     
        ArrayList<RecipeModel> outList = new ArrayList<>();
        RecipeModel m = null;
        try{            
            
            
            
            pstmt = c.prepareStatement("select * from RECIPES where ID in (select RECIPE_ID from PRODUCTS_IN_RECIPE where PRODUCT_ID = ?)");
            pstmt.setInt(1, pid);
            
            ResultSet r = pstmt.executeQuery();
            while(r.next())
            {
            
            int id = r.getInt("ID");
            ArrayList<ProductModel> Products = new ArrayList<>();
            
            /**/
            pstmt = c.prepareStatement("SELECT "
                    + "PRODUCTS.\"NAME\" as \"NAME\", "
                    + "PRODUCTS.\"ID\" as \"ID\", "
                    + "PRODUCTS_IN_RECIPE.COMMENT as COMMENT "
                    + "FROM PRODUCTS_IN_RECIPE JOIN PRODUCTS "
                    + "ON PRODUCTS_IN_RECIPE.PRODUCT_ID = PRODUCTS.ID "
                    + "WHERE PRODUCTS_IN_RECIPE.RECIPE_ID=?;");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                Products.add(new ProductModel(rs.getString("NAME"), rs.getString("COMMENT"), rs.getInt("ID")));
            }
            /**/
            
            m = new RecipeModel(
                    r.getString("NAME"),
                    r.getString("TYPE"),
                    r.getString("RECIPE"), 
                    id, 
                    Products);
     
            outList.add(m);
            }
            
          }catch(Exception e){
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );                
        }
        
        return outList;
    }
    
    public static ProductModel GetProductByName(String name)
    {        
       try{             
        pstmt = c.prepareStatement("select * from PRODUCTS where NAME like ?");
        pstmt.setString(1, name);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next())
        {
            return new ProductModel(rs.getString("NAME"), rs.getString("COMMENT"), rs.getInt("ID"));
        }                        
        }catch(Exception e){
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );                
        }
       return null;
    }
            
    
    public static void AddProduct(String product_name, String comment)
    {
        try{
            pstmt = c.prepareStatement("INSERT INTO PRODUCTS VALUES(NULL, ?, ?)");
            pstmt.setString(1, product_name);
            pstmt.setString(2, comment);
            pstmt.executeUpdate();                    
        }catch(Exception e){
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );                
        }
    }
    
    public static ArrayList<ProductModel> GetProductList()
    {
        ArrayList<ProductModel> pm = new ArrayList<>();
        try{
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("select * from PRODUCTS");
        while(rs.next())
        {
            pm.add(new ProductModel(
                    rs.getString("NAME"),
                    rs.getString("COMMENT"),
                    rs.getInt("ID")
            ));
                    
        }
        }catch(Exception e)
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );                
        }
        
        return pm;
    }
    
    public static ArrayList<String> GetGroupList()
    {
        ArrayList<String> pm = new ArrayList<>();
        try{
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("select TYPE from RECIPES group by TYPE");
        while(rs.next())
        {
            pm.add(
                    rs.getString("TYPE")
            );
                    
        }
        }catch(Exception e)
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );                
        }
        
        return pm;
    }
    
    
    public static void AddRecipe(String Name, String Type, ArrayList<ProductModel> Products, String Recipe)
    {
        try{
            pstmt = c.prepareStatement("INSERT INTO RECIPES VALUES(NULL, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, Name);
            pstmt.setString(2, Type);
            pstmt.setString(3, Recipe);
            pstmt.executeUpdate();
           
            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            int r_id = rs.getInt(1);
            
            for(ProductModel p : Products)
            {
             pstmt = c.prepareStatement("INSERT INTO PRODUCTS_IN_RECIPE VALUES(NULL, ?, ?, ?)");
             pstmt.setInt(1, r_id);
             pstmt.setInt(2, p.getId());
             pstmt.setString(3, p.getComment());                     
             pstmt.executeUpdate();
            }
                    
            
        }catch(Exception e){
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );                
        }
    
    }
    
    public static void DeleteProduct(int id)
    {
        try{
            pstmt = c.prepareStatement("DELETE FROM PRODUCTS WHERE ID=?");
            pstmt.setInt(1, id);            
            pstmt.executeUpdate();                   
        }catch(Exception e){
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );                
        }
    
    }
    
    public static void DeleteRecipe(int id)
    {
        try{
            pstmt = c.prepareStatement("DELETE FROM RECIPES WHERE ID=?");
            pstmt.setInt(1, id);            
            pstmt.executeUpdate();                   
            
            pstmt = c.prepareStatement("DELETE FROM PRODUCTS_IN_RECIPE WHERE RECIPE_ID=?");
            pstmt.setInt(1, id);            
            pstmt.executeUpdate(); 
        }catch(Exception e){
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );                
        }
    
    }
        
    
    /****/
            
    static Connection c = null;
    static Statement stmt = null;    
    static PreparedStatement pstmt = null;   
    
    public static void DatebaseConnect()
    {        
        try {
          Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:recipes.db");
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
    
    public static void DatebaseCloseConnection()
    {
        try {

                System.out.println("Closing connection.");
                c.close();
            } catch (Exception ex) {
                //Logger.getLogger(SQLiteTest.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
                System.out.println("I guess trying to close a connection that is not open yet");
                System.out.println(" - uncomment method makeConnection();");
            }
    }
    
    public static void CreateTables()
    {
      try
      {
      c.setAutoCommit(false);
      stmt = c.createStatement();
      String sql = "CREATE TABLE PRODUCTS " +
                   "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                   " NAME           TEXT    NOT NULL, " +                   
                   " COMMENT        varchar(50))"; 
      stmt.executeUpdate(sql);
      
      sql = "CREATE TABLE RECIPES " +
                   "(ID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                   " NAME           TEXT    NOT NULL, " +                   
                   " TYPE           TEXT    NOT NULL, " +                                 
                   " RECIPE        varchar(5000))"; 
      stmt.executeUpdate(sql);
      
      sql = "CREATE TABLE PRODUCTS_IN_RECIPE " +
                   "(ID INTEGER PRIMARY KEY  AUTOINCREMENT ," +
                   " RECIPE_ID            integer    NOT NULL, " +                   
                   " PRODUCT_ID           integer    NOT NULL, " +                                 
                   " COMMENT              varchar(50))"; 
      stmt.executeUpdate(sql);
      
      stmt.close();
      c.commit();
    
      }catch(Exception e)
      {
          System.out.println(e.getMessage());
      }
    }
    
    public static void DropTables()
      {
        try
        {
        c.setAutoCommit(false);
        stmt = c.createStatement();
        String sql = "DROP TABLE PRODUCTS";
        stmt.executeUpdate(sql);      
        sql = "DROP TABLE PRODUCTS_IN_RECIPE";
        stmt.executeUpdate(sql);      
        sql = "DROP TABLE RECIPES";
        stmt.executeUpdate(sql);      
        stmt.close();
        c.commit();

        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
          
    
    }
       
        
            
    
    
}
