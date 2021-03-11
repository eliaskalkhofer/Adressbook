package model;
/**
 * @author Elias Kalkhofer
 * @date 8.03.2021
 */
public class Input implements Comparable<Input>
{
    private String name;
    private String address;
    private String phone;
    public Input(String name, String address, String phone)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    @Override
    public int compareTo(Input o)
    {
        int result;
        if ((result = this.name.compareTo(o.getName())) == 0){
            if ((result = this.phone.compareTo(o.getPhone())) == 0)
                return this.address.compareTo(o.getAddress());
        }
        return result;
    }
    public String getName()
    {
        return name;
    }
    public String getAddress()
    {
        return address;
    }
    public String getPhone()
    {
        return phone;
    }
}