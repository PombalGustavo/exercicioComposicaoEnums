package Application;

import Entities.Client;
import Entities.Order;
import Entities.OrderItem;
import Entities.Product;
import Entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdfBirthDate = new SimpleDateFormat("dd/MM/yyyy");
        List<OrderItem> items = new ArrayList<>();

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String nameClient = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdfBirthDate.parse(sc.next());

        Client client = new Client(nameClient, email, birthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String status = sc.next().toUpperCase();

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        Date moment = new Date();

        Order order = new Order(moment, OrderStatus.valueOf(status), client);

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter #" + i + " item data: ");
            System.out.print("Product name : ");
            String procuctName = sc.nextLine();
            sc.next();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            Product product = new Product(procuctName, productPrice);
            OrderItem item = new OrderItem(quantity,productPrice,product);
            items.add(item);
        }

        System.out.println();
        System.out.println(order);


        sc.close();
    }
}
