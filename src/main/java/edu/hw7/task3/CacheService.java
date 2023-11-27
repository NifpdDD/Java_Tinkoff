package edu.hw7.task3;

import java.util.HashMap;
import java.util.Map;

public class CacheService implements PersonDatabase {

    private Map<Integer, Person> ids = new HashMap<>();
    private Map<String, Person> names = new HashMap<>();
    private Map<String, Person> addresses = new HashMap<>();
    private Map<String, Person> phones = new HashMap<>();

    @Override
    public synchronized void add(Person person) {
        ids.put(person.id(), person);
        names.put(person.name(), person);
        addresses.put(person.address(), person);
        phones.put(person.phoneNumber(), person);
    }

    @Override
    public synchronized void delete(int id) {
        Person person = ids.remove(id);
        if (person != null) {
            names.remove(person.name());
            addresses.remove(person.address());
            phones.remove(person.phoneNumber());
        }
    }

    @Override
    public synchronized Person findByName(String name) {
        return names.get(name);
    }

    @Override
    public synchronized Person findByAddress(String address) {
        return addresses.get(address);
    }

    @Override
    public synchronized Person findByPhone(String phone) {
        return phones.get(phone);
    }
}
