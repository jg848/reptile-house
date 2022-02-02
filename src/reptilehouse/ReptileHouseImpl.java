package reptilehouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Implementation class for the ReptileHouse interface which contains the
 * implementations of the functionalities listed. Represents a reptile house
 * which can create a habitat inside it, add an animal into a habitat, report
 * the natural features of the habitats inside it, lookup habitats of a
 * particular species type, print the details of the given habitat, print a map
 * of all the habitats and print an index of all the species in the reptile
 * house.
 * 
 * @author Jaswin Gumpella
 *
 */
public class ReptileHouseImpl implements ReptileHouse {

  private int maximumNumberOfHabitats = 0;
  private int totalReptileHouseArea = 0;
  private int availableReptileHouseArea = 0;
  private List<Habitat> habitatList;
  private List<NaturalFeatures> naturalFeaturesList;
  private StringBuilder sb;

  /**
   * Constructor for the ReptileHouse implementation class which takes the input
   * of area of the reptile house and the maximum number of habitats it can have.
   * 
   * @param reptileHouseArea which represents the total area of the reptile house.
   * @param noOfHabitats     which represents the maximum number of habitats the
   *                         reptile house can have.
   */
  public ReptileHouseImpl(int reptileHouseArea, int noOfHabitats) {
    if (reptileHouseArea > 0) {
      this.totalReptileHouseArea = reptileHouseArea;
      this.availableReptileHouseArea = totalReptileHouseArea;
    } else {
      throw new IllegalArgumentException("Area of the Reptile House cannot be negative.");
    }
    if (noOfHabitats > 0) {
      this.maximumNumberOfHabitats = noOfHabitats;
    } else {
      throw new IllegalArgumentException(
          "The maximum number of Habitats in a Reptile House has to be greater than 0");
    }
    this.habitatList = new ArrayList<>();
    this.naturalFeaturesList = new ArrayList<>();
  }

  @Override
  public boolean createHabitat(String habitatName, int habitatSize,
      List<NaturalFeatures> naturalFeatures, String location, int minTemperature,
      int maxTemperature) {
    boolean habitatCreated = false;
    if (this.habitatList.size() < this.maximumNumberOfHabitats) {
      if (habitatSize <= availableReptileHouseArea) {
        Habitat habitat = new HabitatImpl(habitatName, habitatSize, naturalFeatures, location,
            minTemperature, maxTemperature);
        this.availableReptileHouseArea -= habitatSize;
        this.habitatList.add(habitat);
        habitatCreated = true;
      } else {
        throw new IllegalArgumentException(
            "Habitat size cannot be greater than available area of reptile house.");
      }
    } else {
      throw new IllegalArgumentException(
          "Maximum number of habitats in Reptile House reached. Cannot create another habitat.");
    }
    return habitatCreated;
  }

  @Override
  public boolean addAnimal(String animalName, String animalSpecies, Characteristics characteristics,
      int minTemp, int maxTemp, NaturalFeatures naturalFeature, Indicators indicators) {
    Animal animal = null;
    boolean addAnimal = false;
    if (null != indicators) {
      if ("reptile".equalsIgnoreCase(animalSpecies) && !indicators.isExtinct()) {
        animal = new Reptile(animalName, characteristics, minTemp, maxTemp, naturalFeature,
            indicators);
      } else if ("amphibian".equalsIgnoreCase(animalSpecies) && !indicators.isExtinct()) {
        animal = new Amphibian(animalName, characteristics, minTemp, maxTemp, naturalFeature,
            indicators);
      } else {
        throw new IllegalArgumentException("Animal species has to be 'Reptile' or 'Amphibian'.");
      }

      for (int i = 0; i < habitatList.size(); i++) {
        if (animal.checkAddAnimal(habitatList.get(i))) {
          addAnimal = habitatList.get(i).addAnimal(animal);
          break;
        }
      }

    } else {
      throw new IllegalArgumentException("Cannot add extinct animal into habitat.");
    }

    return addAnimal;
  }

  @Override
  public String reportNaturalFeatures() {
    sb = new StringBuilder();
    StringBuilder sb1;
    StringBuilder sb2;

    for (int i = 0; i < habitatList.size(); i++) {
      naturalFeaturesList.addAll(habitatList.get(i).getNaturalFeatures());
    }

    naturalFeaturesList.stream().distinct().collect(Collectors.toList());
    Collections.sort(naturalFeaturesList);
    sb.append("Natural Features -- ").append("\n");

    for (int i = 0; i < naturalFeaturesList.size(); i++) {
      sb1 = new StringBuilder();
      sb2 = new StringBuilder();
      for (int j = 0; j < habitatList.size(); j++) {
        String size = (habitatList.get(j).getNaturalFeaturesSize(naturalFeaturesList.get(i)));
        if (!size.isEmpty()) {
          sb1.append("Habitat ").append(habitatList.get(j).getHabitatName()).append(", ")
              .append(size).append("\n");
        }
      }

      if (!sb1.toString().isEmpty() && !sb.toString().contains(naturalFeaturesList.get(i).name())) {
        sb2.append("Natural Feature: ");
        sb2.append(naturalFeaturesList.get(i)).append(": \n");
        sb2.append(sb1);
        sb.append(sb2);
      }
    }

    return sb.toString();
  }

  @Override
  public String lookUpHabitat(String animalSpecies) {
    sb = new StringBuilder();
    boolean speciesFound = false;
    sb.append("Habitat(s) that house ").append(animalSpecies).append(" are: ").append("\n");
    for (int i = 0; i < habitatList.size(); i++) {
      if (habitatList.get(i).checkHabitatType(animalSpecies)) {
        sb.append(habitatList.get(i).getHabitatName()).append("\n");
        speciesFound = true;
      }
    }
    if (!speciesFound) {
      sb = new StringBuilder();
      sb.append("Species ").append(animalSpecies).append(" currently not inhabiting any habitat.");
    }
    return sb.toString();
  }

  @Override
  public String printSignForHabitat(String habitatName) {
    sb = new StringBuilder();
    for (int i = 0; i < habitatList.size(); i++) {
      if (habitatList.get(i).getHabitatName().equalsIgnoreCase(habitatName)) {
        sb.append(habitatList.get(i).toString());
      }
    }
    return sb.toString();
  }

  @Override
  public String mapAllHabitats() {
    Map<String, List<String>> habitats = new HashMap<>();
    sb = new StringBuilder();
    for (int i = 0; i < habitatList.size(); i++) {
      if (!habitats.containsKey(habitatList.get(i).getHabitatLocation())) {
        habitats.put(habitatList.get(i).getHabitatLocation(), new ArrayList<>());
      }
      habitats.get(habitatList.get(i).getHabitatLocation())
          .add(habitatList.get(i).getHabitatMapDetails());
    }

    for (Entry<String, List<String>> location : habitats.entrySet()) {
      sb.append("Location: ").append(location.getKey()).append(" -- ");
      if (location.getValue().size() > 1) {
        sb.append("\n");
      }
      for (int i = 0; i < location.getValue().size(); i++) {
        sb.append(location.getValue().get(i));

        sb.append("\n");
      }
      sb.append("\n");
    }

    return sb.toString();
  }

  @Override
  public String indexOfSpecies() {
    sb = new StringBuilder();
    Map<String, List<String>> animals = new HashMap<>();
    for (int i = 0; i < habitatList.size(); i++) {
      for (Entry<String, String> s : habitatList.get(i).getSpeciesMap().entrySet()) {
        if (!animals.containsKey(s.getKey())) {
          animals.put(s.getKey(), new ArrayList<>());
        }
        animals.get(s.getKey()).add(s.getValue());
      }
    }
    TreeMap<String, List<String>> sorted = new TreeMap<>();
    sorted.putAll(animals);

    for (Entry<String, List<String>> s : sorted.entrySet()) {
      sb.append("\nSpecies: ").append(s.getKey()).append(", ");
      sb.append("Location(s): ").append(s.getValue());
    }
    return sb.toString();
  }

}
