package ua.fedorenko.sklad;

public class Goods {
	private String name;
	private int quantity;
	private String mesurement; 
	
	public Goods (String name, String mesurement){
		super();
		this.name = name;
		this.mesurement = mesurement;
	}

	public Goods(String name, int quantity, String mesurement) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.mesurement = mesurement;
	}

	public int getQuantity() {
		return quantity;
	}

	public void addQuantity(int quantity) {
		this.quantity += quantity;
	}

	public String getName() {
		return name;
	}

	public String getMesurement() {
		return mesurement;
	}

	@Override
	public String toString() {
		return "В наличии товар " + name + ", в количестве " + quantity + " " + mesurement + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mesurement == null) ? 0 : mesurement.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + quantity;
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
		Goods other = (Goods) obj;
		if (mesurement == null) {
			if (other.mesurement != null)
				return false;
		} else if (!mesurement.equals(other.mesurement))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	
	
	
	
}
