package com.pages;

import com.utils.Base;
import com.utils.Library;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.*;

public class TestScriptPage extends Base{
    /**
     * The Wishlist.
     */
    //String [] wishlist = {"Black trousers","Hard top","Single Shirt","Bikini"};
    /**
     * The Lowfare.
     */
    String lowfare =null;
    /**
     * The Pricelist.
     */
    List<Float> pricelist = new ArrayList<>();
    Library lib = new Library();
    /**
     * The Item added to cart.
     */
    String itemAddedToCart = null;

    public TestScriptPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@title='Shop']")
    public WebElement shop;

    @CacheLookup
    @FindBy(xpath = "(//div[@class='header-wishlist']/a[@title='Wishlist'])[1]")
        public WebElement wishList1;

    @CacheLookup
    @FindBy(xpath="//h2[text()='My wishlist']")
        public WebElement myWishList;

    /**
     * Add different products to wish list.
     * @author: Hari
     * @throws InterruptedException the interrupted exception
     */
    public void addDifferentProductsToWishList(List<String> wishlist)  {
        shop.click();
        //Asserting if we are in shop page
        Assert.assertTrue(shop.isDisplayed());
        for(String wishes:wishlist){
            driver.findElement(By.xpath("//*[contains(text(),'"+wishes+"')]/following::a[@data-title='Add to wishlist'][1]")).click();
            lib.expectedWait(By.xpath("//*[contains(text(),'"+wishes+"')]/following::span[@class='feedback'][1]"),10);
          }
    }

    /**
     * View my wish list table.
     *  @author: Hari
     */
    public void viewMyWishListTable(){
        wishList1.click();
        new Library().expectedWait(myWishList,10);
        Assert.assertTrue(myWishList.isDisplayed());
    }

    /**
     * Total items in wish list.
     * @author: Hari
     */
    public void totalItemsInWishList(List<String> wishlist){
        List<WebElement> elements = driver.findElements(By.xpath("//table[@class='shop_table cart wishlist_table wishlist_view traditional responsive   ']/tbody[1]/tr"));
        System.out.println("Number of Items in the Wish List are : "+ elements.size());
        for(String wishes: wishlist){
            Assert.assertTrue(driver.findElement(By.xpath("//td/*[contains(text(),'"+wishes+"')]")).getText().trim().equalsIgnoreCase(wishes));
        }
    }

    /**
     * Find lowest farefrom table.
     * @author: Hari
     */
    public void findLowestFarefromTable(){
        List<String> fares = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//table[@class='shop_table cart wishlist_table wishlist_view traditional responsive   ']/tbody[1]/tr"));
        for(int wish=1;wish<=elements.size();wish++){
            String temp=null;
            try {
                temp = driver.findElement(By.xpath("//table[@class='shop_table cart wishlist_table wishlist_view traditional responsive   ']/tbody[1]/tr["+wish+"]/td[4]/ins/span[@class='woocommerce-Price-amount amount']")).getText().trim();
                fares.add(temp.replace("£",""));
            }
            catch (Exception|Error e){
                temp = driver.findElement(By.xpath("//table[@class='shop_table cart wishlist_table wishlist_view traditional responsive   ']/tbody[1]/tr["+wish+"]/td[4]/span[@class='woocommerce-Price-amount amount']")).getText().trim();
                fares.add(temp.replace("£",""));
            }
        }
        for (int i = 0; i < fares.size(); i++) {
            pricelist.add(Float.valueOf(fares.get(i)));
        }
        Collections.sort(pricelist);
        System.out.println(pricelist);
        System.out.println("Minimum price from the list : "+pricelist.get(0));
    }

    /**
     * Add lowest item to cart.
     * @author: Hari
     */
    public void addLowestItemToCart(){
        lowfare=pricelist.get(0).toString();
        driver.findElement(By.xpath("//*[contains(text(),'"+lowfare+"')]/following::a[@class='product_type_simple add_to_cart_button ajax_add_to_cart add_to_cart alt'][1]")).click();
        itemAddedToCart=driver.findElement(By.xpath("(//*[contains(text(),'"+lowfare+"')]/preceding::td[@class='product-name']/a)[1]")).getText().trim();
    }

    /**
     * Verify item in the cart.
     * @author: Hari
     */
    public void verifyItemIntheCart(){
        By cartBtn = By.xpath("(//a[@class='cart-contents' and @title='Cart' and @data-tooltip='Cart'])[1]");
        retryingFindClick(cartBtn);
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Cart']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//td[@class='product-name']/a[contains(text(),'"+itemAddedToCart+"')]")).isDisplayed());
    }

    /**
     * Retrying find click boolean.
     *
     * @param by the by
     * @return the boolean
     * @author: Hari
     */
    public boolean retryingFindClick(By by) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                driver.findElement(by).click();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }
}
