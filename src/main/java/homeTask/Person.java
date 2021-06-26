package main.java.homeTask;

class Person {
    // instance variable: age of this person
    private int age;
    // another instance variable: name of this person
    private String name;
    // static variable (shared by all instances): global population
    private static int population = 0;

    // constructor
    public Person(int a, String n) {
// copy arguments of constructor to instance variables
        age = a;
        name = n;
// increase the static counter
        population++;
    }

    // static method (not per-instance)
    public static int printPop() {
        return population;
    }
// instance

    public String getName() {
       return name;
    }

    public String getInfo() {
        return "age: " + age+ ", " + "name: " + getName();
    }

}
class Test {
    public static void main(String[] args) {
        printer("population: " + Person.printPop());

        Person myDad = new Person(33, "Lucius");
        Person myMom = new Person(44, "Pandora");
        Person myDentist = myMom;

        printer(myDentist.getInfo());

        printer("population: " + Person.printPop());
    }

    public static void printer(String msg){
        System.out.println(msg);
    }
}