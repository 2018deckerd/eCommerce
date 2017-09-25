import java.util.*;

public class ShoppingCart implements Cart  {

	private double total;
	private double tax;
	private double shipping;
	ArrayList<SelectedItem> compareTo = new ArrayList<SelectedItem>();
	ArrayList<SelectedItem> cartItems = new ArrayList<SelectedItem>();
	
	
	public ShoppingCart() {
		
		}
	
	public void addItem(SelectedItem newItem) {	
		try {
		boolean itemInCart = false;
		if (cartItems != null && !cartItems.isEmpty()) {
		for (SelectedItem item: cartItems) {
			if (newItem.getItemNumber() == item.getItemNumber()) {
				item.setQuantity(newItem.getQuantity() + item.getQuantity());
				itemInCart = true;
			} else {
	
			}
		}  
		}
			if (itemInCart == true) {

			} else {
			 cartItems.add(new SelectedItem(newItem.getItemNumber(), newItem.getDescription(), newItem.getUnitPrice(), newItem.getQuantity()));
			}

		} catch (ConcurrentModificationException e) {
		
	}
		
	}
	
	public void deleteItem(int deleteItemNumber) {
		for (SelectedItem item: cartItems) {
			if (deleteItemNumber == item.getItemNumber()) {
				item.setQuantity(0);
			}
		}
	}
	
	public double getTotal() {
		for (SelectedItem item: cartItems) {
			if (!cartItems.isEmpty()) {
			total = (item.getQuantity() * item.getUnitPrice()) + total;
		} else {
			
		}
	}
		return total;
	}
	
	public double getTax() {
		tax = total * 0.045;
		return tax;
	}
	
	public double getShipping() {
		if (total <= 10) {
			shipping = 2.50;
		} else {
			shipping = total * 0.15;
		}
		return shipping;
	}
	
	public String toString() {
	
		for (SelectedItem item: cartItems) {
			if (item.getQuantity() != 0) {
			System.out.println ("Item: " + item.getDescription() + "\nQuantity: " + item.getQuantity() + "\nUnit Price: $" 
		+ item.getUnitPrice() + "\nTotal Price: $" + (item.getQuantity()*item.getUnitPrice()) + "\n");
		}
		} 
			System.out.println("Total: $" + getTotal() + "\nTax: $" + getTax() + "\nShipping: $" + getShipping() +
					"\nGRAND TOTAL: $" + (total + tax + shipping));
			return "";
	}
}



