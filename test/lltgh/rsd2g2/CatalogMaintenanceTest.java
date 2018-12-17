// /*
//  * To change this license header, choose License Headers in Project Properties.
//  * To change this template file, choose Tools | Templates
//  * and open the template in the editor.
//  */
// package lltgh.rsd2g2;

// import Customized.List;
// import Customized.ListInterface;
// import java.util.ArrayList;
// import org.junit.AfterClass;
// import org.junit.Before;
// import org.junit.Test;
// import static org.junit.Assert.*;

// /**
//  *
//  * @author Desmond
//  */
// public class CatalogMaintenanceTest {

//     public CatalogMaintenanceTest() {
//     }

//     @AfterClass
//     public static void tearDownClass() {
//     }

//     @Before
//     public void setUp() {
//     }

//     /**
//      * Test of displayEdit method, of class CatalogMaintenance.
//      */
//     @Test
//     public void testDisplayEdit() {
//         System.out.println("displayEdit");
//         String PID = "p0001";
//         String PName = "Red Rose";
//         String PType = "Fresh Flower";
//         String PDetail = "";
//         String PPrice = "";
//         String Pstock = "";
//         String PAvailable = "";
//         CatalogMaintenance instance = new CatalogMaintenance();
//         instance.displayEdit(PID, PName, PType, PDetail, PPrice, Pstock, PAvailable);

//     }

//     /**
//      * Test of generateID method, of class CatalogMaintenance.
//      */
//     @Test
//     public void testGenerateID() {
//         System.out.println("generateID");
//         ListInterface<Product> prodList = new List<>();
//         Product prod = new Product();
//         prod.setProdID("p0001");
//         prod.setprodDetail("Rose in Red Color");
//         prod.setprodName("Red Rose");
//         prod.setprodPrice(2);
//         prod.setprodStatus("Available");
//         prod.setprodStock(30);
//         prod.setprodType("Fresh Flower");
//         prodList.add(prod);

//         CatalogMaintenance instance = new CatalogMaintenance();
//         String expResult = "p0002";
//         String result = instance.generateID(prodList);
//         assertEquals(expResult, result);

//     }

//     /**
//      * Test of viewAll method, of class CatalogMaintenance.
//      */
//     @Test
//     public void testViewAll() {
//         System.out.println("viewAll");
//         ListInterface<Product> prodList = null;
//         CatalogMaintenance instance = new CatalogMaintenance();
//         instance.viewAll(prodList);

//     }

//     /**
//      * Test of isDouble method, of class CatalogMaintenance.
//      */
//     @Test
//     public void testIsDouble() {
//         System.out.println("isDouble");
//         String userInput = "";
//         CatalogMaintenance instance = new CatalogMaintenance();
//         boolean expResult = false;
//         boolean result = instance.isDouble(userInput);
//         assertEquals(expResult, result);

//     }

//     /**
//      * Test of isInteger method, of class CatalogMaintenance.
//      */
//     @Test
//     public void testIsInteger() {
//         System.out.println("isInteger");
//         String userInput = "";
//         CatalogMaintenance instance = new CatalogMaintenance();
//         boolean expResult = false;
//         boolean result = instance.isInteger(userInput);
//         assertEquals(expResult, result);

//     }

//     /**
//      * Test of readProdDatList method, of class CatalogMaintenance.
//      */
//     @Test
//     public void testReadProdDatList() {
//         System.out.println("readProdDatList");
//         CatalogMaintenance instance = new CatalogMaintenance();
//         ListInterface<Product> expResult = new List<>();
//         expResult.add(new Product("p0001", "Red Rose", "Fresh Flower", "Rose in Red Color", 2.0, 20, "Available"));

//         ListInterface<Product> result = instance.readProdDatList();
//         assertEquals(expResult.get(0).getProdID(), result.get(0).getProdID());

//     }

//     /**
//      * Test of readPromoDatList method, of class CatalogMaintenance.
//      */
//     @Test
//     public void testReadPromoDatList() {
//         System.out.println("readPromoDatList");
//         CatalogMaintenance instance = new CatalogMaintenance();
//         ListInterface<Promotion> expResult = new List<>();
//         Promotion newEntry = new Promotion(1, "P0001", 5);
//         expResult.add(newEntry);
//         ListInterface<Promotion> result = instance.readPromoDatList();
//         assertEquals(expResult.get(0).getProdID(), result.get(0).getProdID());

//     }

//     /**
//      * Test of viewPromotions method, of class CatalogMaintenance.
//      */
//     @Test
//     public void testViewPromotions() {
//         System.out.println("viewPromotions");
//         CatalogMaintenance instance = new CatalogMaintenance();
//         instance.viewPromotions();
//     }

//     /**
//      * Test of viewFlowerList method, of class CatalogMaintenance.
//      */
//     @Test
//     public void testViewFlowerList() {
//         System.out.println("viewFlowerList");
//         ListInterface<Product> prodList = new List<>();

//         Product prod = new Product("p0001", "Red Rose", "Fresh Flower", "Rose in Red Color", 2, 30, "Available");
//         prodList.add(prod);
//         String option = "1";
//         CatalogMaintenance instance = new CatalogMaintenance();
//         instance.viewFlowerList(prodList, option);
//     }

//     /**
//      * Test of viewFlower method, of class CatalogMaintenance.
//      */
//     @Test
//     public void testViewFlower() {
//         System.out.println("viewFlower");
//         ArrayList<Product> al = new ArrayList<Product>();
//         al.add(new Product("p0001", "Red Rose", "Fresh Flower", "Rose in Red Color", 2, 30, "Available"));
//         String option = "1";
//         CatalogMaintenance instance = new CatalogMaintenance();
//         instance.viewFlower(al, option);
//     }

//     /**
//      * Test of getProductList method, of class CatalogMaintenance.
//      */
//     @Test
//     public void testGetProductList() {
//         System.out.println("getProductList");
//         ArrayList<Product> al = new ArrayList<Product>();
//         al.add(new Product("p0001", "Red Rose", "Fresh Flower", "Rose in Red Color", 2, 30, "Available"));

//         int i = 0;
//         CatalogMaintenance.getProductList(al, i);
//     }

//     /**
//      * Test of getProductListFromDat method, of class CatalogMaintenance.
//      */
//     @Test
//     public void testGetProductListFromDat() {
//         System.out.println("getProductListFromDat");
//         ListInterface<Product> prodList = new List<>();

//         Product prod = new Product("p0001", "Red Rose", "Fresh Flower", "Rose in Red Color", 2, 30, "Available");
//         prodList.add(prod);
//         int i = 0;
//         CatalogMaintenance instance = new CatalogMaintenance();
//         instance.getProductListFromDat(prodList, i);
//     }

//    /**
//     * Test of writeProdDatList method, of class CatalogMaintenance.
//     */
//    @Test
//    public void testWriteProdDatList() {
//        System.out.println("writeProdDatList");
//        ListInterface<Product> prodList = new List<>();
//        Product newEntry = new Product("p0001", "Red Roses", "Fresh Flower", "Rose in red color", 2, 10, "Available");
//        prodList.add(newEntry);
//        CatalogMaintenance instance = new CatalogMaintenance();
//        instance.writeProdDatList(prodList);
//    }
//
//    /**
//     * Test of writePromoDatList method, of class CatalogMaintenance.
//     */
//    @Test
//    public void testWritePromoDatList() {
//        System.out.println("writePromoDatList");
//        ListInterface<Promotion> promo = new List<>();
//        Promotion newEntry = new Promotion(1, "p0001", 5);
//        promo.add(newEntry);
//        CatalogMaintenance instance = new CatalogMaintenance();
//        instance.writePromoDatList(promo);
//    }
// }
