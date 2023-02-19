package com.company.tasks.RandGame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ServerSteps {
    public static List<Player> initPlayers(BufferedWriter writer, BufferedReader reader) {
        List<Player> players = new ArrayList<>();
        try {
            writer.write("Введите количество игроков: ");
            writer.newLine();
            writer.flush();
            int countPlayers = Integer.parseInt(reader.readLine());
            if (countPlayers < 2)
                throw new RandGameException("Игроков должно быть больше одного, а вас", countPlayers);

            for (int i = 0; i < countPlayers; i++) {
                writer.write("Игрок " + (i + 1) + ", введите ваше имя: ");
                writer.newLine();
                writer.flush();
                players.add(new Player(reader.readLine(), 20000));
            }

        } catch (IOException | RandGameException e) {
            e.printStackTrace();
        }
        return players;
    }

    public static int setNumber(BufferedWriter writer) {
        try {
            writer.write("Я загадал число от 1 до 10, кто его угадает или будет ближе всех?");
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return (int) Math.round(Math.random() * 9) + 1;
    }

    public static int setCash(List<Player> players, BufferedWriter writer, BufferedReader reader) {
        int cash = 100;
        String winnerName = null;
        List<String> losers = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            try {
                writer.write(String.format("Сейчас ставка - %d рублей, игрок %s, у вас на счету %d рублей. Будем повышать? да/нет/пас",
                        cash, players.get(i).getName(), players.get(i).getMoney()));
                writer.newLine();
                writer.flush();

                String yesOrNo = reader.readLine();
                if (cash > players.get(i).getMoney()) {
                    yesOrNo = "пас";
                }
                switch (yesOrNo) {
                    case "да":
                        writer.write("Напишите новую ставку: ");
                        writer.newLine();
                        writer.flush();
                        cash = Integer.parseInt(reader.readLine());
                        winnerName = players.get(i).getName();
                        if (i != 0) {
                            i = -1;
                        }
                        break;
                    case "пас":
                        players.get(i).changeMoney(-cash);
                        losers.add(players.get(i).getName());
                        cash = 0;
                        break;
                    case "нет":
                        break;
                }
                if (yesOrNo.equals("пас")) {
                    return cash;
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            writer.write("Ставки сделаны");
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (losers.size() == players.size() - 1) {
            String finalWinnerName = winnerName;
            players.stream().filter(x -> Objects.equals(x.getName(), finalWinnerName))
                    .collect(Collectors.toList()).get(0).changeMoney((players.size() - 1) * cash);
        }
        return cash;
    }

    public static void stepGame(List<Player> players, int number, int cash, BufferedWriter writer,
                                BufferedReader reader) throws IOException {
        List<Integer> raznici = new ArrayList<>();
        StringBuilder winnersNames = new StringBuilder();
        for (Player p : players) {
            writer.write(String.format("Игрок %s, введите число:", p.getName()));
            writer.newLine();
            writer.flush();
            raznici.add(Math.abs(number - Integer.parseInt(reader.readLine())));
        }
        int min = 9;
        for (int i = 0; i < raznici.size(); i++) {
            if (min > raznici.get(i))
                min = raznici.get(i);
        }

        List<Integer> numberWinners = new ArrayList<>();
        for (int i = 0; i < raznici.size(); i++) {
            if (raznici.get(i) == min) {
                numberWinners.add(i);
                winnersNames.append(players.get(i)).append(" ");
            }
        }
        if (numberWinners.size() > 1) {
            writer.write("Победители: " + winnersNames + " получают " + cash + " рублей");
            writer.newLine();
            writer.flush();
            for (int i = 0; i < numberWinners.size(); i++) {
                players.get(numberWinners.get(i)).changeMoney(cash);
            }
        }
        else {
            writer.write("Я загадал число - " + number + ". Победитель: " + winnersNames + " получает " + cash + " рублей");
            writer.newLine();
            writer.flush();
            players.get(numberWinners.get(0)).changeMoney(cash);
        }

        for (int i = 0; i < players.size(); i++) {
            if (!numberWinners.contains(i))
                players.get(i).changeMoney(-cash);
        }

        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getMoney() <= 0) {
                players.remove(i);
            }
        }
    }
}