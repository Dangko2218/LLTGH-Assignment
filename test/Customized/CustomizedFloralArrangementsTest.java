/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customized;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class CustomizedFloralArrangementsTest {
    
    public CustomizedFloralArrangementsTest() {
        
    
    }
    
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() throws Exception {
    }
    
//SPRINT 2
//    /**
//     * Test of checkModifyStatus method, of class CustomizedFloralArrangements.
//     */
      
    @Test
    public void testPrintItemizedBill() {
        //Record customized details
        ListInterface<CustomizedEntity> custList = new List<>(); 
        CustomizedEntity cust = new CustomizedEntity("ON001", "2018/12/16 00:04:24", "2018/12/21", "C0001", "Traditional or Western", "Small(3.5” X 3.5”)", "Red Rose", "-", "-", "Floral Tape", "-", "-", 2, 73, 1);
        custList.add(cust);
        
        System.out.println("printItemizedBill");
        
        //Expected result
        String orderNo = "ON001"; //parameter(user input)
        String dateTime = "2018/12/16 00:04:24";
        String collectionDate = "2018/12/21";
        String custID = "C0001";
        String style = "Traditional or Western";
        String size = "Small(3.5” X 3.5”)";
        String ty1 = "Red Rose";
        String ty2 = "-";
        String ty3 = "-";
        String ac1 = "Floral Tape";
        String ac2 = "-";
        String ac3 = "-";
        int prior = 2;
        int price = 73;
        int status = 1;
        
        //Compare expected result with actual 
        CustomizedFloralArrangements instance = new CustomizedFloralArrangements();
        instance.printItemizedBill(orderNo);
        assertEquals(orderNo, custList.get(0).getOrderNo());
        assertEquals(dateTime, custList.get(0).getDateTime());
        assertEquals(collectionDate, custList.get(0).getCollectionDate());
        assertEquals(custID, custList.get(0).getCustID());
        assertEquals(style, custList.get(0).getStyle());
        assertEquals(size, custList.get(0).getSize());
        assertEquals(ty1, custList.get(0).getType1());
        assertEquals(ty2, custList.get(0).getType2());
        assertEquals(ty3, custList.get(0).getType3());
        assertEquals(ac1, custList.get(0).getAcc1());
        assertEquals(ac2, custList.get(0).getAcc2());
        assertEquals(ac3, custList.get(0).getAcc3());
        assertEquals(prior, custList.get(0).getPrior());
        assertEquals(price, custList.get(0).getPrice());
        assertEquals(status, custList.get(0).getStatus());
    }
//    public void testCheckModifyStatus() {
//        System.out.println("checkModifyStatus");
//        String input = "1";
//        String orderNo = "ON008";
//        CustomizedFloralArrangements instance = new CustomizedFloralArrangements();
//        Boolean expResult = false;
//        Boolean result = instance.checkModifyStatus(input, orderNo);
//        assertEquals(expResult, result);
//        ListInterface<CustomizedEntity> list = new List<>();
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
    
    //
//    /**
//     * Test of modifyOrder method, of class CustomizedFloralArrangements.
//     */
//    @Test
//    public void testModifyOrder() throws Exception {
//        System.out.println("modifyOrder");
//        int item = 3;
//        CustomizedFloralArrangements instance = new CustomizedFloralArrangements();
//        boolean expResult = false;
//        boolean result = instance.modifyOrder(item);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
 
//SPRINT 3
//    /**
//     * Test of checkValidOrderNo method, of class CustomizedFloralArrangements.
//     */
//    @Test
//    public void testCheckValidOrderNo() {
//        System.out.println("checkValidOrderNo");
//        String input = "";
//        CustomizedFloralArrangements instance = new CustomizedFloralArrangements();
//        Boolean expResult = false;
//        Boolean result = instance.checkValidOrderNo(input);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
////
////    /**
////     * Test of checkCodeInput method, of class CustomizedFloralArrangements.
////     */
//  
//        @Test
//    public void testCheckCodeInput() {
//        System.out.println("checkCodeInput");
//        String codeInput = "p0001";
//        String item = "TY";
//        CustomizedFloralArrangements instance = new CustomizedFloralArrangements();
//        Boolean expResult = true;
//        Boolean result = instance.checkCodeInput(codeInput, item);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//    
////    /**
////     * Test of checkPrior method, of class CustomizedFloralArrangements.
////     */
//    @Test
//    public void testCheckPrior() {
//        System.out.println("checkPrior");
//        String custInput = "1";
//        CustomizedFloralArrangements instance = new CustomizedFloralArrangements();
//        Boolean expResult = true;
//        Boolean result = instance.checkPrior(custInput);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
////
////    /**
////     * Test of checkNext method, of class CustomizedFloralArrangements.
////     */
//    @Test
//    public void testCheckNext() {
//        System.out.println("checkNext");
//        String input = "qwe";
//        CustomizedFloralArrangements instance = new CustomizedFloralArrangements();
//        Boolean expResult = false;
//        Boolean result = instance.checkNext(input);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
////
////    /**
////     * Test of calcTotal method, of class CustomizedFloralArrangements.
////     */
//    @Test
//    public void testCalcTotal() {
//        System.out.println("calcTotal");
//        String style = "ST001";
//        String size = "SZ001";
//        String type1 = "p0001";
//        String type2 = "p0006";
//        String type3 = "p0007";
//        String acc1 = "p0013";
//        String acc2 = "p0014";
//        String acc3 = "-";
//        String prior = "1";
//        CustomizedFloralArrangements instance = new CustomizedFloralArrangements();
//        int expResult = 88;
//        int result = instance.calcTotal(style, size, type1, type2, type3, acc1, acc2, acc3, prior);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
////    /**
////     * Test of dateValidation method, of class CustomizedFloralArrangements.
////     */
//    @Test
//    public void testDateValidation() throws Exception {
//        System.out.println("dateValidation");
//        String inputDate = "2018/13/11";
//        CustomizedFloralArrangements instance = new CustomizedFloralArrangements();
//        boolean expResult = false;
//        boolean result = instance.dateValidation(inputDate);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//    //
//
//
////
////
////    /**
////     * Test of checkUpdate method, of class CustomizedFloralArrangements.
////     */
//    @Test
//    public void testCheckUpdate() {
//        System.out.println("checkUpdate");
//        String input = "";
//        CustomizedFloralArrangements instance = new CustomizedFloralArrangements();
//        Boolean expResult = false;
//        Boolean result = instance.checkUpdate(input);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    
//        /**
//     * Test of readCustDat method, of class CustomizedFloralArrangements.
//     */
//    @Test
//    public void testReadCustDat() {
//        System.out.println("readCustDat");
//        CustomizedFloralArrangements instance = new CustomizedFloralArrangements();
//        CustomizedEntity cust = new CustomizedEntity("ON010", "2018/12/16 00:04:24", "2018/12/21", "C0001", "Traditional or Western", "Small(3.5” X 3.5”)", "Red Rose", "-", "-", "Floral Tape", "-", "-", 2, 73, 1);
//        QueueInterface<CustomizedEntity> expResult = new Queue<>();
//        expResult.enqueue(cust);
//        QueueInterface<CustomizedEntity> result = instance.readCustDat();
//        assertEquals(expResult.dequeue().getItemCode(), result.dequeue().getItemCode());
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
////
////    /**
////     * Test of readDataList method, of class CustomizedFloralArrangements.
////     */
//    @Test
//    public void testReadDataList() {
//        System.out.println("readDataList");
//        String item = "SZ";
//        CustomizedFloralArrangements instance = new CustomizedFloralArrangements();
//        CustomizedEntity cust = new CustomizedEntity("SZ001", "Small(3.5” X 3.5", 30, "Available");
//        ListInterface<CustomizedEntity> expResult = new List<>();
//        expResult.add(cust);
//        ListInterface<CustomizedEntity> result = instance.readDataList(item);
//        assertEquals(expResult.get(0).getItemCode(), result.get(0).getItemCode());
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
////
////    /**
////     * Test of writeDataList method, of class CustomizedFloralArrangements.
////     */
//    @Test
//    public void testWriteDataList() {
//        System.out.println("writeDataList");
//        ListInterface<CustomizedEntity> list = new List<>();
//        String item = "SZ";
//        CustomizedEntity cust = new CustomizedEntity("SZ001", "Small(3.5” X 3.5", 30, "Available");
//        CustomizedFloralArrangements instance = new CustomizedFloralArrangements();
//        list.add(cust);
//        instance.writeDataList(list, item);
//        
//        
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//    
////    /**
////     * Test of printTest method, of class CustomizedFloralArrangements.
////     */
//    @Test
//    public void testPrintTest() throws Exception {
//        System.out.println("printTest");
//        //CustomizedFloralArrangements instance = new CustomizedFloralArrangements();
//        //instance.printTest();
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
////
////    /**
////     * Test of alertMsg method, of class CustomizedFloralArrangements.
////     */
//    @Test
//    public void testAlertMsg() throws Exception {
//        System.out.println("alertMsg");
//        CustomizedFloralArrangements instance = new CustomizedFloralArrangements();
//        instance.alertMsg();
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
////
////    /**
////     * Test of displayCustMenu method, of class CustomizedFloralArrangements.
////     */
//    @Test
//    public void testDisplayCustMenu() throws Exception {
//        System.out.println("displayCustMenu");
////        CustomizedFloralArrangements instance = new CustomizedFloralArrangements();
////        boolean expResult = false;
////        boolean result = instance.displayCustMenu();
////        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
////
////    /**
////     * Test of printItemMenu method, of class CustomizedFloralArrangements.
////     */
//    @Test
//    public void testPrintItemMenu() {
//        System.out.println("printItemMenu");
////        String item = "PR";
////        CustomizedFloralArrangements instance = new CustomizedFloralArrangements();
////        String expResult = "1";
////        String result = instance.printItemMenu(item);
////        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//
////
////    /**
////     * Test of printItemizedBill method, of class CustomizedFloralArrangements.
////     */
//
////
////    /**
////     * Test of displayOrderMenu method, of class CustomizedFloralArrangements.
////     */
//    @Test
//    public void testDisplayOrderMenu() throws Exception {
//        System.out.println("displayOrderMenu");
////        CustomizedFloralArrangements instance = new CustomizedFloralArrangements();
////        instance.displayOrderMenu();
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
////
////    /**
////     * Test of displayListForItemizedBill method, of class CustomizedFloralArrangements.
////     */
//    @Test
//    public void testDisplayListForItemizedBill() {
//        System.out.println("displayListForItemizedBill");
////        CustomizedFloralArrangements instance = new CustomizedFloralArrangements();
////        boolean expResult = false;
////        boolean result = instance.displayListForItemizedBill();
////        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
////
////    /**
////     * Test of displayViewOrderMenu method, of class CustomizedFloralArrangements.
////     */
//    @Test
//    public void testDisplayViewOrderMenu() {
//        System.out.println("displayViewOrderMenu");
////        CustomizedFloralArrangements instance = new CustomizedFloralArrangements();
////        instance.displayViewOrderMenu();
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
////
////    /**
////     * Test of viewOrder method, of class CustomizedFloralArrangements.
////     */
//    @Test
//    public void testViewOrder() {
//        System.out.println("viewOrder");
////        String status = "Pending";
////        CustomizedFloralArrangements instance = new CustomizedFloralArrangements();
////        instance.viewOrder(status);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
////
//
////
////    /**
////     * Test of displayManageMenu method, of class CustomizedFloralArrangements.
////     */
//    @Test
//    public void testDisplayManageMenu() {
//        System.out.println("displayManageMenu");
////        CustomizedFloralArrangements instance = new CustomizedFloralArrangements();
////        boolean expResult = false;
////        boolean result = instance.displayManageMenu();
////        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
////
////    /**
////     * Test of displayItemMenu method, of class CustomizedFloralArrangements.
////     */
//    @Test
//    public void testDisplayItemMenu() {
//        System.out.println("displayItemMenu");
////        String item = "SZ";
////        CustomizedFloralArrangements instance = new CustomizedFloralArrangements();
////        boolean expResult = false;
////        boolean result = instance.displayItemMenu(item);
////        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
////
////    /**
////     * Test of addItem method, of class CustomizedFloralArrangements.
////     */
//    @Test
//    public void testAddItem() {
//        System.out.println("addItem");
////        String item = "SZ";
////        CustomizedFloralArrangements instance = new CustomizedFloralArrangements();
////        boolean expResult = false;
////        boolean result = instance.addItem(item);
////        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
////
////    /**
////     * Test of updateItem method, of class CustomizedFloralArrangements.
////     */
//    @Test
//    public void testUpdateItem() {
//        System.out.println("updateItem");
////        String item = "";
////        CustomizedFloralArrangements instance = new CustomizedFloralArrangements();
////        boolean expResult = false;
////        boolean result = instance.updateItem(item);
////        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }

    
}
