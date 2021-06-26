package main.java.homeTask.six;

public class Aircraft {
 /*
    4. Создайте класс Самолет. В классе создайте вложенный класс - крыло. Внутри класса Крыло, реализуйте:
    поле для хранения информации про вес крыла;
    метод, который будет показывать вес крыла.

    В главном классе создайте объект и добавьте во вложенный класс данные про вес крыла
     и выведите информацию на экран. Создайте два объекта и добавьте разный вес для крыльев.
*/

    class Wing {
        private final double weight;

        public Wing(double weight) {
            this.weight = weight;
        }

        public double getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "Wing{" +
                    "weight=" + weight +
                    '}';
        }
    }
}
