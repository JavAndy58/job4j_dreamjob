package ru.job4j.dream.store;

import org.springframework.stereotype.Repository;
import ru.job4j.dream.model.City;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class CityStore {

    private AtomicInteger ids = new AtomicInteger(3);
    private Map<Integer, City> cities = new ConcurrentHashMap<>();

    private CityStore() {
        cities.put(1, new City(1, "Москва"));
        cities.put(2, new City(2, "СПб"));
        cities.put(3, new City(3, "Екб"));
    }

    public List<City> getAllCities() {
        return new ArrayList<>(cities.values());
    }

    public void create(City city) {
        city.setId(ids.incrementAndGet());
        cities.put(city.getId(), city);
    }

    public void update(City city) {
        cities.put(city.getId(), new City(city.getId(), city.getName()));
    }

    public City findById(int id) {
        return cities.get(id);
    }
}
