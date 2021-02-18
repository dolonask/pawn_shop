package kg.megacom;

import kg.megacom.enums.OperationStatus;
import kg.megacom.exceptions.ClientNotFound;
import kg.megacom.models.Client;
import kg.megacom.models.Operation;
import kg.megacom.models.Product;
import kg.megacom.services.ClientService;
import kg.megacom.services.impl.ClientServiceImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
	// write your code here


        ClientService clientService  = ClientService.INSTANCE;
        Client client;
        try {
           client = clientService.findClientByIdCard("ID123");
        }catch (ClientNotFound ex){
            client = clientService.createClient("Аселя", "ID123");
        }

        Product product = new Product("Телевизор", 10000);

        ArrayList<Product> products = new ArrayList<>();
        products.add(product);

        Operation operation = new Operation();
        operation.setId(1);
        operation.setStatus(OperationStatus.OPEN);
        operation.setStartDate(new Date());
        operation.setClient(client);
        operation.setProducts(products);

        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.DAY_OF_YEAR, 20);

        operation.setEndDate(calendar.getTime());


        double totalPrice = 0;

        for (Product item:products
             ) {
            totalPrice += item.getPrice();
        }
        operation.setPrice(totalPrice + totalPrice * 20 / 100);

        System.out.println(operation.getStartDate());
        System.out.println(operation.getEndDate());
        System.out.println(operation.getPrice());




        /*
            ProductService
                createProduct

            OperationService
                createOperation
                closeOperation(date)
            создание операция
         */

    }
}
