package ua.fedorenko.sklad;

import java.util.HashMap;
import java.util.Iterator;

public class Warehouse {

	private String address;
	private HashMap<String, Goods> goodsInWarehouse = new HashMap<String, Goods>();
	
	public Warehouse(String address) {
		super();
		this.address = address;
	}

	public void addGoods(String name, int quantity, String mesurements) {
		if (goodsInWarehouse.containsKey(name)) {
			Goods goods = goodsInWarehouse.get(name);
			goods.addQuantity(quantity);
			goodsInWarehouse.put(name, goods);
		} else {
			goodsInWarehouse.put(name, new Goods(name, quantity, mesurements));
		}

	}

	public String getOneOfGoods(String name) {
		if (goodsInWarehouse.containsKey(name)) {
			Goods goods = goodsInWarehouse.get(name);
			return goods.toString();
		} else {
			return "Такого товара на складе нет";
		}
	}

	public int getOneOfGoodsQuantity(String name) {
		if (goodsInWarehouse.containsKey(name)) {
			Goods goods = goodsInWarehouse.get(name);
			return goods.getQuantity();
		} else {
			return 0;
		}
	}

	public String takeGoodsForTransport(String name, int quantity) {
		if (goodsInWarehouse.containsKey(name)) {
			Goods goods = goodsInWarehouse.get(name);
			int actualQtty = goods.getQuantity();
				if (actualQtty>=quantity){
					goods.addQuantity(-quantity);
					goodsInWarehouse.put(name, goods);
					return "";
				}else{
					return "Товара "+name+" недостаточно. Текущее кол-во: "+actualQtty+" "+goods.getMesurement();
				}
		} else {
			return "Нет такого товара на складе";
		}
	}

	public String getAddress() {
		return address;
	}
	
	public String getListOfGoods (HashMap<String, Goods> goods) {
		String listOfGoods = "";
		Iterator<HashMap.Entry<String, Goods>> iterator = goods.entrySet().iterator();

		while (iterator.hasNext()) {
			HashMap.Entry<String, Goods> entry = iterator.next();
			String item = entry.getValue().toString();
			listOfGoods += item;
		}
		return listOfGoods;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((goodsInWarehouse == null) ? 0 : goodsInWarehouse.hashCode());
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
		Warehouse other = (Warehouse) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (goodsInWarehouse == null) {
			if (other.goodsInWarehouse != null)
				return false;
		} else if (!goodsInWarehouse.equals(other.goodsInWarehouse))
			return false;
		return true;
	}
	
}
