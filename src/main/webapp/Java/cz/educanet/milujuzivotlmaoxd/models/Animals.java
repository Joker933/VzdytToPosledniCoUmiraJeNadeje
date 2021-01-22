package cz.educanet.milujuzivotlmaoxd.models;

public class Animals {

    public String jmeno;
    public int vek;
    public double vaha;
    public int id;
    public String pohlavi;

    public Animals(String jmeno, int vek, double vaha, String pohlavi){
        this.jmeno = jmeno;
        this.vek = vek;
        this.vaha = vaha;
        this.pohlavi = pohlavi;
    }

    public int getId(){
        return id;
    }

    public String getjmeno(){
        return jmeno;
    }

    public int getvek(){
        return vek;
    }

    public double getvaha(){
        return vaha;
    }

    public String getpohlavi(){
        return pohlavi;
    }

    public void setjmeno(String jmeno){
        this.jmeno = jmeno;
    }

    public void setvek(int vek){
        this.vek = vek;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setvaha(double vaha){
        this.vaha = vaha;
    }

    public void setpohlavi(String pohlavi){
        this.pohlavi= pohlavi;
    }

}
