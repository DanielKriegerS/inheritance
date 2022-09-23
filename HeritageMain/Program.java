package HeritageMain;

import HeritageEntities.Employee;
import HeritageEntities.OutsourcedEmployee;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        List< Employee> list = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++){
            System.out.println("Employee #"+ i +" data:");
            System.out.print("Outsourced (y/n)? ");
            char cond = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.next();
            String name = sc.nextLine();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per hour: ");
            double vph = sc.nextDouble();
            if (cond == 'n') {
                list.add(new Employee(name, hours, vph));
            }else {
                System.out.print("Additional charge: ");
                double adC = sc.nextDouble();
                list.add(new OutsourcedEmployee(name, hours, vph, adC));
            }

        }
        System.out.println();
        System.out.println("PAYMENTS");
        for (Employee emp: list){
            System.out.println(emp.getName() + " - $" + String.format("%.2f", emp.payment()));
        }


        sc.close();
    }
}
