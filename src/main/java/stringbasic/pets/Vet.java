package stringbasic.pets;

import java.util.ArrayList;
import java.util.List;

public class Vet {
    private List<Pet> pets = new ArrayList<>();

    public List<Pet> getPets() {
        return pets;
    }

    public void add (Pet pet){
        for (Pet selectedPet : pets) {
            if (areEquals(selectedPet, pet)) {
                return;
            }
        }
        pets.add(pet);
    }
     public boolean areEquals(Pet onePet, Pet otherPet){
        if(onePet.getRegnum().equals(otherPet.getRegnum())== true){
            return true;
        }
        else return false;
        }
     }

