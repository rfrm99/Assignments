package Assignment2;
import java.util.*;

public class Specimen {
    private String name;
    private int cageNumber;
    private Species toa; // "Type Of Animal"
    private String markings = "None";
    private ArrayList<Specimen> animals = new ArrayList<Specimen>();

    public Specimen( String a, int c, Species s) {
        setName(a);
        setCage(c);
        setTOA(s);
    }

    public void setName(String a){
        name = a;
    }
    public void setCage(int c){
        cageNumber = c;
    }
    public void setTOA(Species s){
        toa = s;
    }

    public ArrayList<Specimen> getAnimals() {
        return animals;
    }
    public void addTail(Specimen sp) {
        this.animals.add(sp);
    }
    public void addHead(Specimen sp){
        this.animals.add(0, sp);
    }
    public Specimen getHead(){
        return this.animals.get(0);
    }
    public Specimen getTail(){
        return this.animals.get(animals.size()-1);
    }
    public void insert(Specimen sp){
        this.animals.add(sp);
    }
    public void delete(Specimen sp){
        int i = 0;
        while(i<animals.size()){
            if(animals.get(i) == sp){
                break;
            }
            i++;
        }
        animals.remove(i);
    }
    public ArrayList<Species> makeSpeciesList(ArrayList<Specimen> animals) {
        ArrayList<Species> species = new ArrayList<Species>();
        for (int i = 0; i < animals.size(); i++) {
            species.add(animals.get(i).getTOA());
        }
        return species;
    }

    public ArrayList<Species> makeSpeciesListUnique(ArrayList<Specimen> animals) {
        ArrayList<Species> species = new ArrayList<Species>();
        for (int i = 0; i < animals.size(); i++) {
            int flag = 0;
            if (species.size() == 0) {
                species.add(animals.get(i).getTOA());
            }
            for (int j = 0; j < species.size(); j++) {
                if (species.get(j) != animals.get(i).getTOA()) {
                    flag = 1;
                }else {
                    flag = 0;
                    break;
                }
            }if (flag == 1){
                species.add(animals.get(i).getTOA());
            }
        }
        return species;
    }

    public void countSpecimens(ArrayList<Specimen> animals, Species s ){
        int sum = 0;
        for(int i = 0; i < animals.size(); i++) {
            if (s == animals.get(i).getTOA()) {
                sum++;
            }
        }
        System.out.println(sum);
    }

    public LinkedList makeList( ArrayList<Specimen> animals ) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < animals.size(); i++) {
            list.addFirst(animals.get(i));
        }
        return list;
    }
    //Question set 3 c.
    //pseudocode for listSpecies(Specimen[] animals)
    //define a list for specimens and its length list = Specimen[10]
    //FOR each element in animals
        //FOR each element in list
            //if animals element by index i equals list element by index j then get to next index i
            //else animals element by index i not in index j append
    //print out list


    public void setMarkings(String markings) { //3a
        this.markings = markings;
    }

    public String getMarkings() {
        return markings;
    }

    public String getName(){
        return name;
    }
    public int getCage(){
        return cageNumber;
    }
    public Species getTOA(){
        return toa;
    }
    public String toString() {
        return name + " is a " + toa + " in cage " + cageNumber + " has a " + markings + "as a marking ";
    }
}

