package service;

import model.Toy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ToyPicker {
    public Toy choosePrizeToy(List<Toy> toys) {
        double totalWeight = toys.stream().mapToDouble(Toy::getWeight).sum();
        Random random = new Random();
        double randNum = random.nextDouble() * totalWeight;

        double cumulativeWeight = 0;
        Toy chosenToy = null;

        for (Toy toy : toys) {
            cumulativeWeight += toy.getWeight();
            if (randNum <= cumulativeWeight) {
                chosenToy = toy;
                break;
            }
        }

        if (chosenToy != null) {
            chosenToy.setQuantity(chosenToy.getQuantity() - 1);
            writePrizeToFile(chosenToy.getName()); // Записываем призовую игрушку в файл
            System.out.println("Выбрана призовая игрушка: " + chosenToy.getName());
        } else {
            System.out.println("Нет доступных игрушек для выбора.");
        }

        return chosenToy;
    }

    private void writePrizeToFile(String prizeToyName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("prize_toys.txt", true))) {
            writer.write(prizeToyName + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
