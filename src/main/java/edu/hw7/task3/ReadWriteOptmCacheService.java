package edu.hw7.task3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteOptmCacheService implements PersonDatabase {

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Map<Integer, Person> ids = new HashMap<>();
    private final Map<String, Person> names = new HashMap<>();
    private final Map<String, Person> addresses = new HashMap<>();
    private final Map<String, Person> phones = new HashMap<>();

    @Override
    public void add(Person person) {
        lock.writeLock().lock();
        try {
            ids.put(person.id(), person);
            names.put(person.name(), person);
            addresses.put(person.address(), person);
            phones.put(person.phoneNumber(), person);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        lock.writeLock().lock();
        try {
            Person person = ids.remove(id);
            if (person != null) {
                names.remove(person.name());
                addresses.remove(person.address());
                phones.remove(person.phoneNumber());
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public Person findByName(String name) {
        lock.readLock().lock();
        try {
            return names.get(name);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public Person findByAddress(String address) {
        lock.readLock().lock();
        try {
            return addresses.get(address);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public Person findByPhone(String phone) {
        lock.readLock().lock();
        try {
            return phones.get(phone);
        } finally {
            lock.readLock().unlock();
        }
    }
}
