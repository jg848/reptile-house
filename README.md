# ReptileHouse

### About/Overview
ReptileHouse is a tracking system for the Cold-Blooded Conservancy for their many Reptile Houses which house reptiles and amphibians in a number of different habitats.
What it does:
  - Constructs a Reptile House with the given area and the maximum number of habitats it can have.
  - Creates a habitat inside the Reptile House with the given name, size, list of natural features, location and temperature range.
  - Adds a given animal species into a habitat by checking the preferred requirements in the Reptile House.
  - Lists all the natural features being used in the Reptile House and includes the habitats where the natural feature is located and how much space is left in the habitat for additional animals.
  - Looks up which habitat(s) house a given species type.
  - Prints a sign for a given habitat that lists the species that it houses along with their defining characteristics, other indicators and an indicator of how many of that species type is housed in the habitat.
  - Lists all the habitats in the Reptile House by location and the natural features in the habitat and species they house.
  - Gives an index that lists all species in the Reptile House and their location(s).

### List of features

  - The **Reptile House Tracking System** is built by using the **Factory Design Pattern**, which is one of the most used design patterns in Java.
  - The **ReptileHouse** Interface is implemented by the **ReptileHouseImpl** class which consists of the functionality for the tracking system. The instance of **ReptileHouse** is created by giving an input of the total area of the Reptile House in square meters `totalReptileHouseArea` and an integer value for maximum number of habitats it can have `maximumNumberOfHabitats`.
    > `createHabitat()` method is used to create a habitat in the Reptile House by using the **Habitat** Interface which is implemented by **HabitatImpl** class. The constructor of the **HabitatImpl** requires an input of the name of the habitat `habitatName`, size of the habitat `habitatSize`, list of upto three natural features it can have `naturalFeaturesList`, location of the habitat `location`, minimum temperature it can have `minimumTemperature` and the maximum temperature it can have `maximumTemperature`.
	>> The natural features are represented by an enumeration **NaturalFeatures** which contain a list of the available natural features. They are **DESERT, FALLEN_LOGS, FLOWING_WATER, GRASS, LILY_PADS, POND, ROCKS, SALT_WATER, SANDY_BEACH, TREE_BRANCHES**.
	> `addAnimal()` method is used to add the given animal species into a habitat in the Reptile House by using the **Animal** Interface which is implemented by the **AnimalImpl** abstract class which is further extended by **Reptile** and **Amphibian** classes. It requires an input of the name of the animal `animalName`, type of species `animalSpecies`, defining characteristics of an animal `characteristics`, preferred minimum temperature `minimumTemperature`, preferred maximum temperature `maximumTemperature`, preferred natural feature `naturalFeature` and other indicators `indicators`. Based on the input `animalSpecies` value, the **Reptile** or **Amphibian** class is initialized accordingly such that the instance of **Animal** represents a single **Reptile** or **Amphibian** species.
	>> The defining characteristics of an animal species is represented by the **Characteristics** Interface which is implemented by the **CharacteristicsImpl** class. The constructor of the **CharacteristicsImpl** requires an input of the description of the animal species `description` and the size of an animal which is represented by an enumeration **AnimalSize** which has the types **SMALL, MEDIUM, LARGE**.
	>> The other Indicators of an animal species include if the animal species is poisonous or not `isPoisonous`, endangered or not `isEndangered`, extinct or not `isExtinct` and can live with other species of animals or not `canCoLive` through the **Indicators** Interface which is implemented by **IndicatorsImpl** class.
	> `reportNaturalFeatures()` method is used to get list of all the natural features being used in the Reptile House and includes the habitats where the natural feature is located and how much space is left in the habitat for additional animals.
	> `lookUpHabitat()` method is used to look up which habitat(s) house a given species type which is `Reptile` or `Amphibian`.
	> `printSignForHabitat()` method is used to print a sign for the given habitat that lists the species that it houses along with a description of the species (including their name, their defining characteristics and other indicators like poisonous, extinct, endangered, can live with other species) and an indicator of how many of that species is housed in that habitat.
	> `mapAllHabitats()` method is used to get the list of all the habitats by location along with the natural features in the habitat and species they house.
	> `indexOfSpecies()` method is used to get an index that lists all species in the Reptile House in alphabetical order and their location(s). 
  - The **ReptileHouseDriver** class is a Driver class that is used to demonstrate the working of the ReptileHouse tracking system. It contains the `main()` method which is used to create an instance of the **ReptileHouse** interface and call the available methods to demonstrate the functionality of the tracking system.

### How To Run
  Instructions to run the **JAR** file is:
  > Use: **java -jar .\ReptileHouseTrackingSystem.jar** in the command prompt(Windows).
  > **jdk-11 Java version** is used to compile and build the application.

### How to Use the Program
  The **Main** class **ReptileHouseDriver** has a **main** function that calls all the methods of **ReptileHouse** automatically when the program is launched. It prints all the information about the Reptile House while it executes.
> It shows the information on the console when
>> `createHabitat()` method is called to create a new habitat in the Reptile House.
>> `addAnimal()` method is called when a new animal is being added into one of the habitats in the Reptile House.
>> `mapAllHabitats()` method is called to print the details of all the habitats in the Reptile House.
>> `reportNaturalFeatures()` method is called to print all the details of the natural features being used in the Reptile House.
>> `lookUpHabitat()` method is called to get the habitats which house a particular species type.
>> `printSignForHabitat()` method is called to get the sign for a given habitat.
>> `indexOfSpecies()` method is called to get an index of all the species living in the Reptile House.

### Description of Example Run
```sh
Filename: sampleRun.txt
```
The program prints out statements while the code executes after it has been launched.
> The flow of execution is as follows:
>> **Running ReptileHouse.** is displayed first when the program is launched.
>> **Creating reptile house of size 100 square meters and can have a maximum of 3 habitats.** is displayed when the Reptile House is constructed with predefined values.
>> **Creating habitat 'Texas Reptile Zoo'.** is printed when the program tries to create a habitat named 'Texas Reptile Zoo'. If the habitat is successfully created, **Created habitat - true.** is printed.
>> **Creating habitat 'Mojave Desert'.** is printed when the program tries to create a habitat named 'Mojave Desert'. If the habitat is successfully created, **Created habitat - true.** is printed.
>> **Creating habitat 'North Carolina Zoo'.** is printed when the program tries to create a habitat named 'North Carolina Zoo'. If the habitat is successfully created, **Created habitat - true.** is printed.
>> **Calling method mapAllHabitats().** is displayed before calling the `mapAllHabitats()` method. The result printed will be:
>>> **Location: North Carolina -- Name: North Carolina Zoo, Natural Features: [POND, FLOWING_WATER], Species: []**
>>> 
>>> **Location: Texas -- Name: Texas Reptile Zoo, Natural Features: [TREE_BRANCHES, FLOWING_WATER, GRASS], Species: []**
>>> 
>>> **Location: Nevada -- Name: Mojave Desert, Natural Features: [DESERT, ROCKS], Species: []**
>>> 
>>> 
>>> 
>> **Calling method reportNaturalFeatures().** is displayed after calling the `reportNaturalFeatures()` method. The result is displayed as follows:
>>> **Natural Features --**
>>> **Natural Feature: DESERT:**
>>> **Habitat Mojave Desert, Maximum space available: 30**
>>> **Natural Feature: FLOWING_WATER:**
>>> **Habitat Texas Reptile Zoo, Maximum space available: 30**
>>> **Habitat North Carolina Zoo, Maximum space available: 30**
>>> **Natural Feature: GRASS:**
>>> **Habitat Texas Reptile Zoo, Maximum space available: 30**
>>> **Natural Feature: POND:**
>>> **Habitat North Carolina Zoo, Maximum space available: 30**
>>> **Natural Feature: ROCKS:**
>>> **Habitat Mojave Desert, Maximum space available: 30**
>>> **Natural Feature: TREE_BRANCHES:**
>>> **Habitat Texas Reptile Zoo, Maximum space available: 30**
>>> 
>>> 
>> **Calling method lookUpHabitat("REPTILE").** is printed when the `lookUpHabitat()` method is called with input as "REPTILE" species type. The result is **Species REPTILE currently not inhabiting any habitat.**
>> **Calling method lookUpHabitat("AMPHIBIAN").** is printed when the `lookUpHabitat()` method is called with input as "AMPHIBIAN" species type. The result is **Species AMPHIBIAN currently not inhabiting any habitat.**
>> **Calling method printSignForHabitat("Texas Reptile Zoo").** is displayed when the `printSignForHabitat()` is called with input as 'Texas Reptile Zoo'. The result is:
>>> **Texas Reptile Zoo**
>>> **Type of Species in habitat - Species Type not assigned.**
>>> **Total number of Species currently inhabiting - 0**
>>> 
>>> 
>> **Calling method printSignForHabitat("Mojave Desert").** is displayed when the `printSignForHabitat()` is called with input as 'Mojave Desert'. The result is:
>>> **Mojave Desert**
>>> **Type of Species in habitat - Species Type not assigned.**
>>> **Total number of Species currently inhabiting - 0**
>>> 
>>> 
>> **Calling method printSignForHabitat("North Carolina Zoo").** is displayed when the `printSignForHabitat()` is called with input as 'North Carolina Zoo'. The result is:
>>> **North Carolina Zoo**
>>> **Type of Species in habitat - Species Type not assigned.**
>>> **Total number of Species currently inhabiting - 0**
>>> 
>>> 
>> **Adding animal Gray Treefrog into Reptile House.** is displayed when the `addAnimal()` method is called. The message **Added animal into habitat - true** is printed out if the animal is successfully added into a habitat.
>> **Adding animal Desert Tortoise into Reptile House.** is displayed when the `addAnimal()` method is called. The message **Added animal into habitat - true** is printed out if the animal is successfully added into a habitat.
>> **Adding animal American Alligator into Reptile House.** is displayed when the `addAnimal()` method is called. The message **Added animal into habitat - true** is printed out if the animal is successfully added into a habitat.
>> **Calling method reportNaturalFeatures().** is displayed when the `reportNaturalFeatures()` method is called. The result printed is:
>>> **Natural Features --**
>>> **Natural Feature: DESERT:**
>>> **Habitat Mojave Desert, Maximum space available: 25**
>>> **Natural Feature: FLOWING_WATER:**
>>> **Habitat Texas Reptile Zoo, Maximum space available: 29**
>>> **Habitat North Carolina Zoo, Maximum space available: 20**
>>> **Natural Feature: GRASS:**
>>> **Habitat Texas Reptile Zoo, Maximum space available: 29**
>>> **Natural Feature: POND:**
>>> **Habitat Mojave Desert, Maximum space available: 25**
>>> **Habitat North Carolina Zoo, Maximum space available: 20**
>>> **Natural Feature: ROCKS:**
>>> **Habitat Mojave Desert, Maximum space available: 25**
>>> **Natural Feature: TREE_BRANCHES:**
>>> **Habitat Texas Reptile Zoo, Maximum space available: 29**
>>> 
>>> 
>> **Calling method lookUpHabitat("REPTILE").** is printed when the `lookUpHabitat()` method is called with input as "REPTILE" species type. The result is:
>>> **Habitat(s) that house REPTILE are:**
>>> **Mojave Desert**
>>> **North Carolina Zoo**
>>> 
>>> 
>> **Calling method lookUpHabitat("AMPHIBIAN").** is printed when the `lookUpHabitat()` method is called with input as "AMPHIBIAN" species type. The result is:
>>> **Habitat(s) that house AMPHIBIAN are:**
>>> **Texas Reptile Zoo**
>>> 
>>> 
>> **Calling method printSignForHabitat("Texas Reptile Zoo").** is displayed when the `printSignForHabitat()` is called with input as 'Texas Reptile Zoo'. The result is:
>>> **Texas Reptile Zoo**
>>> **Type of Species in habitat - AMPHIBIAN**
>>> **Total number of Species currently inhabiting - 1**
>>> **Species name: Gray Treefrog, Description: Gray treefrogs have a white spot beneath each eye and a dark stripe from the rear of the eyes to the front of the legs., Size: SMALL, Poisonous: false, Endangered: false, Extinct: false, Can live with other species: false, Frequency - 1**
>>> 
>>> 
>> **Calling method printSignForHabitat("Mojave Desert").** is displayed when the `printSignForHabitat()` is called with input as 'Mojave Desert'. The result is:
>>> **Mojave Desert**
>>> **Type of Species in habitat - REPTILE**
>>> **Total number of Species currently inhabiting - 1**
>>> **Species name: Desert Tortoise, Description: Desert tortoises dig underground burrows in order to hide from the sun in the deep desert., Size: MEDIUM, Poisonous: false, Endangered: false, Extinct: false, Can live with other species: false, Frequency - 1**
>>> 
>>> 
>> **Calling method printSignForHabitat("North Carolina Zoo").** is displayed when the `printSignForHabitat()` is called with input as 'North Carolina Zoo'. The result is:
>>> **North Carolina Zoo**
>>> **Type of Species in habitat - REPTILE**
>>> **Total number of Species currently inhabiting - 1**
>>> **Species name: American Alligator, Description: American alligator is capable of biting through a turtle's shell or a moderately sized mammal bone., Size: LARGE, Poisonous: false, Endangered: false, Extinct: false, Can live with other species: false, Frequency - 1**
>>> 
>>> 
>> **Calling method indexOfSpecies().** is displayed when the `indexOfSpecies()` method is called. The result printed is:
>>> 
>>> **Species: American Alligator, Location(s): [North Carolina]**
>>> **Species: Desert Tortoise, Location(s): [Nevada]**
>>> **Species: Gray Treefrog, Location(s): [Texas]**
>>> 

### Design/Model Changes

> Changed the design pattern by including interfaces and abstract class where required for all the concrete classes to implement **Factory Design Pattern**.
> Removed Species enumeration implementation and created concrete classes **Reptile** and **Amphibian** extending **AnimalImpl** abstract class which implements **Animal** interface.
> Also included new interfaces **Characteristics** and **Indicators** with their implementation classes **CharacteristicsImpl** and **IndicatorsImpl**.
> Included the functions related to each ReptileHouse, Habitat and Animal in their respective implementation classes.

### Assumptions

> **ReptileHouse** can have a **totalReptileHouseArea** in square meters which will be an integer value greater than 0, defined when constructing a **ReptileHouse**.
```sh
totalReptileHouseArea > 0
```

> **ReptileHouse** can have a maximum of **n** habitats which should be defined when constructing a **ReptileHouse**. 
```sh
n > 0
```

> **Habitat** must have a valid string for `habitatName` value. Input cannot be empty or null.
```sh
null!=habitatName && !habitatName.isEmpty()
```

> **Habitat** must have a valid size which is an integer value greater than 0 and less than the `availableReptileHouseArea`.
```sh
availableReptileHouseArea >= habitatSize > 0
```

> **Habitat** can have only upto three natural features. There can also be only one natural feature given multiple times to have the entire habitat for one particular animal species.

> **Habitat** cannot have an invalid `location` value. The value must be a valid string which cannot be null or empty.
```sh
null!=habitatLocation && !habitatLocation.isEmpty()
```

> **Habitat** must have integer values for temperatures and `minimumTemperature` cannot be greater than `maximumTemperature`.
```sh
minimumTemperature < maximumTemperature
```
> **Habitat** does not have a preferred species type initially but is set when an animal is added.

> If **Habitat** has less than three natural features, the preferred natural feature of an animal can be added to the naturalFeaturesList of the **Habitat** after checking the other requirements of the animal.

> **Reptile** and **Amphibian** cannot be added into the same **Habitat**.

> **Characteristics** of an animal containing the description and size must be valid. The `description` has to be a non empty, not null valid string and size should be a not null valid **AnimalSize** enumeration type value.

> **Indicators** of an animal cannot be null and need to have valid true or false values for `isPoisonous`, `isEndangered`, `isExtinct` and `canCoLive`.

> **Animal** must have a valid string `animalName` which cannot be null or empty.

> **Animal** must have a valid integer values for temperatures and `minimumTemperature` cannot be greater than `maximumTemperature`.
```sh
minimumTemperature < maximumTemperature
```

> **Animal** which have the same `animalName` can be added into the same habitat even if the indicator `canCoLive` is false.

> **Animal** which has the indicator `isExtinct` cannot be added into any habitat.

> **Animal** cannot be added into a habitat if there is no space available. `habitatSize` must always be greater than `animalSize` if it is to be added into a habitat.
```sh
habitatSize > animalSize
```
