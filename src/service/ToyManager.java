package service;

import model.Toy;

import java.util.ArrayList;
import java.util.List;

public class ToyManager {
    private List<Toy> toys;

    public ToyManager() {
        this.toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateWeight(int toyId, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(weight);
                return;
            }
        }
        System.out.println("Игрушка с указанным ID не найдена.");
    }

    public void addNewToy(int id, String name, int quantity, double weight) {
        Toy newToy = new Toy(id, name, quantity, weight);
        toys.add(newToy);
    }

    public void setToyWeight(int toyId, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(weight);
                return;
            }
        }
        System.out.println("Игрушка с указанным ID не найдена.");
    }
    public List<Toy> getToys() {
        return toys;
    }
}