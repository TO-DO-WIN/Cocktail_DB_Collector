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
        String drinkListJson = getDrinkList();
        DrinkList drinkList = mapListObject(drinkListJson);
//        setDrinkListItems(drinkList);
        for(Drinks i : drinkList.getDrinks()){
            System.out.println("Drink Name:" + i.getStrDrink() +"; ID:" + i.getIdDrink());;
        }
    }



    private String getDrinkList() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> stringResponseEntity = null;
        try {
            RequestEntity<String> requestEntity = new RequestEntity<String>(HttpMethod.GET, new URI(baseURL + "c=Ordinary_Drink"));
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

//    private void setDrinkListItems(DrinkList drinkList){
//        ObjectMapper mapper = new ObjectMapper();
//        try{
//            drinkList.setDrinkIDList(mapper.readValue(drinkListJson,DrinkList.class));
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
}
