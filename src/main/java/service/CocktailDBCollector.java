package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Drinks;
import model.DrinkList;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class CocktailDBCollector {

    private static final String baseURL = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?";

    public void getAndCacheCocktails() {
        DrinkList completeDrinkList = getCompleteDrinkList();

        for(Drinks i : completeDrinkList.getDrinks()){
            System.out.println("Drink: "+i.getStrDrink() + " ID: "+i.getIdDrink());
        }

    }

    private DrinkList getCompleteDrinkList() {
        String ordinaryDrinkListString = httpGetResponse(baseURL + "c=Ordinary_Drink");
        String cocktailDrinkListString = httpGetResponse(baseURL + "c=Cocktail");
        DrinkList ordinaryDrinkList = mapListObject(ordinaryDrinkListString);
        DrinkList cocktailDrinkList = mapListObject(cocktailDrinkListString);
        DrinkList completeList = new DrinkList();
        completeList.setDrinks(ordinaryDrinkList.getDrinks());
        completeList.getDrinks().addAll(cocktailDrinkList.getDrinks());
        return completeList;
    }

    /**
     * Method uses http get request to hit provided endpoint and store response in String Entity
     * a rest template is provided request instructions via the request entity
     * The request response is stored in a generics RequestEntity
     * @param requestURI is the url/endpoint to be processed
     *                   @return the endpoint response body is returned to the calling method
     * */
    private String httpGetResponse(String requestURI) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> stringResponseEntity = null;
        try {
            RequestEntity<String> requestEntity = new RequestEntity<String>(HttpMethod.GET, new URI(requestURI));
            stringResponseEntity = restTemplate.exchange(requestEntity, String.class);
        }catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return stringResponseEntity.getBody();
    }

    private DrinkList mapListObject(String drinkListJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        DrinkList mappedDrinkList = null;
        try {
            mappedDrinkList = objectMapper.readValue(drinkListJson,DrinkList.class);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return mappedDrinkList;
    }


}
