package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
	
		//esse método sdf pode gerar uma exception, por isso é adicionado
		//o throws ParseException no main, quando nãoa há o tratamento dele
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		//Exemplo de composição de classes, objetos criados na mão
		//uma classe relacionada na outra
//		Product prod = new Product("TV", 1000.0);
//		
//		OrderItem oItem = new OrderItem(1,1000.0, prod);//prod é o produto
//		
//		System.out.println(oItem);
//		
		
		//exemplo usando instancia da class Client
		//Client client = new Client("Maria", "maria@gmail.com", sdf.parse("20/10/1995"));
		
		//criando com entrada de dados
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		//neste caso, os dados são digitados e salvos no construtor
		Client client1 = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.println("Status:");
		
		//O valueOf converte o valor string em valor do OrderStatus que
		//será digitado
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client1);
		
		System.out.println("How many items to this orderItems? ");
		int N = sc.nextInt();
		for (int i=1; i<= N; i++) {
			System.out.println("Enter #" + i + "item data:");
			System.out.println("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.println("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.println("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			OrderItem it1 = new OrderItem(quantity, productPrice, product);
			
			
			order.addItem(it1);
		}
				
		System.out.println();
		System.out.println(order);
		
		sc.close();

	}

}
