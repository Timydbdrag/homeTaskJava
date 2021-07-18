package homeTask.six;

public class App {

    public static void main(String[] args) {
//        Study study = new Study("Изучение Java - это просто!");
//        System.out.println(study.printCourse());

//        Home h1 = new Home();
//        h1.setName("apartment");
//        h1.setFloorCount(1);
//        h1.setYearOfConstruction(2010);
//
//        Home h2 = new Home();
//        h2.setName("village");
//        h2.setFloorCount(3);
//        h2.setYearOfConstruction(2015);
//
//        System.out.println(h1);
//        System.out.println("h1 age: "+h1.age());
//        System.out.println(h2);
//        System.out.println("h2 age: "+ h2.age());


//        Tree tree = new Tree();
//        Tree tree1 = new Tree("Birch", 50);
//        Tree tree2 = new Tree("Palm", 10, true);
//        System.out.println(tree);
//        System.out.println(tree1);
//        System.out.println(tree2);


        Aircraft aircraft = new Aircraft();

        Aircraft.Wing left = aircraft.new Wing(1000d);
        Aircraft.Wing right = aircraft.new Wing(1300d);
        System.out.println(left.getWeight());
        System.out.println(right.getWeight());

    }


}


