package spring23team2;

/**
 * The Provider class ...
 * 
 * @author Jahanvi Kathiriya
 * @version 1.1  add get function for use in ProviderDirectory class
 */
public class Provider{
    String name;
    int providerNumber;
    String address;
    String city;
    String state;
    int zip;

    public Provider(String name,int providerNumber,String address,String city,String state,int zip){
        this.name = name;
        this.providerNumber = providerNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
    
    /**
     * The getName function gets the name of the provider
     * @return name of provider
     */
    public String getName(){
        return name;
    }
    /**
     * The getAccountNumber function gets the account number of the provider
     * @return account number of provider
     */
    public int getProviderNumber(){
        return providerNumber;
    }
    /**
     * The getAddress function gets the name of the provider
     * @return address of provider
     */
    public String getAddress(){
        return address;
    }
    /**
     * The getCity function gets the city of the provider
     * @return city of provider
     */
    public String getCity(){
        return city;
    }
    /**
     * The getState function gets the state of the provider
     * @return state of provider
     */
    public String getState(){
        return state;
    }
    /**
     * The getZipCode function gets the zip code of the provider
     * @return zipCode of provider
     */
    public int getZip(){
        return zip;
    }
    
}