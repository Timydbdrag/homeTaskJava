package main.java.homeTask.six;

public class Tree {
    /*
    3. Создайте класс Tree. Добавьте в него поля:
     возраст, живое ли дерево и название дерева. Создайте три конструктора:
    Конструктор, который устанавливает только возраст и название;
    Конструктор, который устанавливает все переменные в классе;
    Конструктор, который ничего не устанавливает, но выводит сообщение «Пустой конструктор без параметров сработал».

    Создайте три объекта на основе класса и используйте по одному конструктору на каждый.
    */

    private String name;
    private int age;
    private boolean life;

    public Tree(){
        System.out.println("Пустой конструктор без параметров сработал");
    }

    public Tree(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Tree(String name, int age, boolean life) {
        this.name = name;
        this.age = age;
        this.life = life;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isLife() {
        return life;
    }

    public void setLife(boolean life) {
        this.life = life;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", life=" + life +
                '}';
    }
}
