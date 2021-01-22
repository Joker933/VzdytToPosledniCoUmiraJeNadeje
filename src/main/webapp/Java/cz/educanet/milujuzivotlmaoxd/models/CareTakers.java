package cz.educanet.milujuzivotlmaoxd.models;

public class CareTakers {
    private String jmeno;
    private String prijmeni;
    private String pohlavi;
    private int id;

    public CareTakers( String jmeno, String prijmeni, String pohlavi){
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.pohlavi = pohlavi;

    }

    public int getId(){
        return id;
    }

    public String getjmeno(){
        return jmeno;
    }

    public String getprijmeni(){
        return prijmeni;
    }

    public String getpohlavi(){
        return pohlavi;
    }

    public void setjmeno(String jmeno){
        this.jmeno = jmeno;
    }

    public void setprijmeni(String prijmeni){
        this.prijmeni = prijmeni;
    }

    public void setpohlavi(String pohlavi){
        this.pohlavi = pohlavi;
    }

    public void setId(int id){
        this.id = id;
    }

}
