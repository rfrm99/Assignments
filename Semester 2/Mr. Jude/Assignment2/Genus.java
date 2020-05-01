package Assignment2;

public class Genus
{
    private String genusName;

    public Genus(String g){
        this.genusName = g;
    }
    public String getGenusName(){
        return genusName;
    }
    public void setGenusName(String g){
        this.genusName = g;
    }
    @Override
    public String toString(){
        return "Genus: " + genusName;
    }
}
