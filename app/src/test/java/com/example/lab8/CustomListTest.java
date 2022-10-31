package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     * one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize + 1);
    }

    /**
     * create a mock city list
     * add a new city to it
     * and check that hasCity returns that the city is in fact in list
     */
    @Test
    public void hasCityTest(){

        list = MockCityList();
        City mockCity = new City("Estevan", "SK");
        list.addCity(mockCity);
        assertEquals(true, list.hasCity(mockCity));
    }

    /**
     * create a mock city list, add a new city to it &
     * then delete the city
     * check if the city has been successfully removed
     */
    @Test
    public void deleteCityTest(){
        list = MockCityList();
        City mockCity = new City("Estevan", "SK");
        list.addCity(mockCity);
        list.deleteCity(mockCity);
        assertEquals(false, list.hasCity(mockCity));
    }


    @Test
    public void countCitiesList(){
        list = MockCityList();
        assertEquals(0, list.countCities());
        City mockCity = new City("Estevan", "SK");
        list.add(mockCity);
        assertEquals(1, list.countCities());
        list.deleteCity(mockCity);
        assertEquals(0, list.countCities());
    }

}
