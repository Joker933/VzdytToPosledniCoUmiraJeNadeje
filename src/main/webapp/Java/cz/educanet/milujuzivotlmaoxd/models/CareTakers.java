package cz.educanet.milujuzivotlmaoxd.models;

public class CareTakers {
    private String name;
    private String lastName;
    private Integer age;

    public String getName(){
        return name;
    }

    public String getLastName(){
        return lastName;
    }

    public Integer getAge(){
        return age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setAge(Integer age){
        this.age = age;
    }
}
