package homeTask.thirteen;

import homeTask.thirteen.client.ClientFactory;
import homeTask.thirteen.impl.WikiApiRestClient;
import homeTask.thirteen.model.WikiResponse;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        ClientFactory clientFactory = ClientFactory.newInstance();
        WikiApiRestClient wikiApiRestClient = clientFactory.newRestClient();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Введите запрос (для выхода из программы введите: Q )");
            if (sc.hasNext()) {
                String s = sc.nextLine();
                if(s.equals("Q")) System.exit(0);

                WikiResponse java = wikiApiRestClient.getQuery(s);

                System.out.println(java.getQuery().getSearchinfo());
                java.getQuery().getSearch().forEach(System.out::println);
            }
            System.out.println("===============================");
            System.out.println("===============END=============");
            System.out.println("===============================");
        }
    }
}
