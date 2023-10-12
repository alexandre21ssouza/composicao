package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import entities.enums.OrderStatus;

public class Order {

	//converter a data de String para o formato data
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date momment;
	private OrderStatus status;
	
	//um pedido tem um client
	private Client client;
	
	
	//Um pedido pode ter vários itens
	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {
		
	}

	//não coloca a coleçaõ no construtor, List
	public Order(Date momment, OrderStatus status, Client client) {
		
		this.momment = momment;
		this.status = status;
		this.client = client;
	}

	public Date getMomment() {
		return momment;
	}

	public void setMomment(Date momment) {
		this.momment = momment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	
	//neste caso é interessante não disponibilizar acesso a lista criada 
	//pelo getItems, pois ela pode ser alterada por algum acesso indevido
	// excluíndo tanto o setter e getter é a melhor opção, por isso comentei.
	//então vai ficar de acesso a lista somente pelos métodos abaixo
//	public List<OrderItem> getItems() {
//		return items;
//	}
	
	
	//método add no lugar do setItems, pq o set iria substituir a lista
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	
	public Double total() {
		double sum = 0.0;
		for(OrderItem it : items) {
			sum += it.subTotal();
		}
		return sum;
	}
	
	@Override
	public String toString() {
		
		//StringBuilder concatena tudo mais rápido e transforma em String
		StringBuilder sb = new StringBuilder();
		sb.append("Oder momment: ").append(sdf.format(momment) + "\n")
		.append("Order status: ").append(status + "\n")
		.append("Client: ").append(client + "\n")
		.append("Order items: ").append(items + "\n");
		for (OrderItem mostraItem : items) {
			sb.append(mostraItem + "\n");
		}
		sb.append("Total price: $").append(String.format("%.2f", total()));
		return sb.toString();
		
	}
	
}
