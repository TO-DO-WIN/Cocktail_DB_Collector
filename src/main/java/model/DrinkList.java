package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DrinkList {

    private ArrayList<Drinks> drinks;

    public DrinkList(){
        this.drinks = new ArrayList<>();
    }

    public void addDrink(Drinks newDrink){
        this.drinks.add(newDrink);
    }

    public ArrayList<Drinks> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<Drinks> drinks) {
        this.drinks = drinks;
    }
}
