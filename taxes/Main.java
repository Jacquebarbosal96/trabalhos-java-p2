package taxes;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of tax payers: ");
        int numeroContributors = scanner.nextInt();
        ArrayList<Person> people = new ArrayList<>();

        for (int i = 0; i < numeroContributors; i++) {
            System.out.printf("Tax payer #%02d data: %n", (i + 1));
            System.out.print("Individual or company (i/c)? ");
            String op = scanner.next();
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("Anual income: ");
            double rendaAnual = scanner.nextDouble();

            if (op.equals("i")) {
                double health;
                System.out.print("Health expenditures: ");
                health = scanner.nextDouble();
                Individual individual = new Individual(name, rendaAnual, health);
                individual.calcularTaxa();
                people.add(individual);
            } else if (op.equals("c")) {
                System.out.print("Number of employees: ");
                int worker = scanner.nextInt();
                Company company = new Company(name, rendaAnual, worker);
                company.calcularTaxa();
                people.add(company);
            }
        }

        double total = 0;
        System.out.println("TAXES PAID:");
        for (Person p : people) {
            if (p instanceof Individual) {
                Individual i = (Individual) p;
                System.out.printf("%s: $ %.2f%n", i.getName(), i.getTax());
                total += i.getTax();
            } else if (p instanceof Company) {
                Company c = (Company) p;
                System.out.printf("%s: $ %.2f%n", c.getName(), c.getTax());
                total += c.getTax();
            }
        }

        System.out.printf("TOTAL TAXES: $ %.2f%n", total);
        
        scanner.close();
    }
}