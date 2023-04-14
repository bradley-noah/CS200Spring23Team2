package spring23team2;

/**
 * The Provider class ...
 * 
 * @author Jahanvi Kathiriya
 * @version 1.0
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

    
}