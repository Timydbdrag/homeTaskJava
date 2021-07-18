package homeTask.six;

import java.time.LocalDate;

public class Home {
     /* 2. Создайте класс Дом. Добавьте в него следующие данные:
    поля: количество этажей, год постройки, наименование;
    метод для установки всех значений;
    метод для вывода всех значений;
    метод, возвращающий количество лет с момента постройки.

    На основе класса создайте два объекта и пропишите для каждого характеристики.
    Добавление характеристик реализуйте через метод класса.

    Выведите информацию про каждый объект.*/

    private String name;
    private int floorCount;
    private int yearOfConstruction;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    public int getYearOfConstruction() {
        return yearOfConstruction;
    }

    public void setYearOfConstruction(int yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
    }

    public int age() {
        LocalDate date = LocalDate.now();
        return date.getYear() - yearOfConstruction;
    }

    @Override
    public String toString() {
        return "Home{" +
                "name='" + name + '\'' +
                ", floorCount=" + floorCount +
                ", yearOfConstruction=" + yearOfConstruction +
                '}';
    }



}
