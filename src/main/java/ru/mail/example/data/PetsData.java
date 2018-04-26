package ru.mail.example.data;

/**
 * Животные
 * @author Pavel Balahonov <p.balahonov@corp.mail.ru>
 */
public enum PetsData {
    All("Все"),
    Dogs("Собаки"),
    Cats("Кошки");

    private final String name;

    PetsData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
