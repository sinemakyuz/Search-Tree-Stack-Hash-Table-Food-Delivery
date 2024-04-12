public class SimpleDistrict {
    public String name;
    public int population;

    public SimpleDistrict(String name, int population){
        this.name = name;
        this.population = population;
    }

    public void display(){
        System.out.println("\nMahalle Adı: " + name + " Nüfusu: " + population);
    }
}
