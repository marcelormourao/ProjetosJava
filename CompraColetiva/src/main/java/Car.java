
public class Car {
	
	private String id;
	private String brand;
	private int year;
	private String color;
	private int price;
	private boolean vendido;
	
	public Car(String id, String brand, int ano, String cor, int preco,
			boolean vendido) {
		super();
		this.id = id;
		this.brand = brand;
		this.year = ano;
		this.color = cor;
		this.price = preco;
		this.vendido = vendido;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public boolean isVendido() {
		return vendido;
	}



	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

}
