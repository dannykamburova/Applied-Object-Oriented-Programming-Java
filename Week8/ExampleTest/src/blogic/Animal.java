package blogic;

public class Animal {
    private String name;
    private AnimalType animalType;
    private boolean predator;
    private String region;
    private boolean endangered;

    public static final String[] REGIONS =
            new String[]{"Africa", "Asia", "Australia", "Europe", "America"};

    public Animal(String name, AnimalType animalType, boolean predator, String region, boolean endangered) {
        setName(name);
        setAnimalType(animalType);
        setPredator(predator);
        setRegion(region);
        setEndangered(endangered);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
       if(name != null && !name.equals(" ")) {
           this.name = name;
       } else {
          this.name = "Unknown";
       }
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        if(animalType != null) {
            this.animalType = animalType;
        } else {
            this.animalType = AnimalType.FISH;
        }
    }

    public boolean isPredator() {
        return predator;
    }

    public void setPredator(boolean predator) {
        this.predator = predator;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        if(region != null) {
            for(int i = 0; i < REGIONS.length; i++) {
                if(region.equals(REGIONS[i])) {
                    this.region = REGIONS[i];
                    return;
                }
            }
        } else {
            this.region = "Unknown";
        }
    }

    public boolean isEndangered() {
        return endangered;
    }

    public void setEndangered(boolean endangered) {
        this.endangered = endangered;
    }


    @Override
    public String toString() {
        String isPredator = isPredator() ? "Да" : "Не";
        String isEndangered = isPredator() ? "Да" : "Не";
        return String.format("Животно{ $s, тип = %s, хищник = %s, " +
                "регион = %sр застрашен = %s}", name, animalType,
                isPredator, region, isEndangered);
    }
}
