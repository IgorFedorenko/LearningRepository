package ua.fedorenko.sklad;

import java.util.HashMap;
import java.util.Iterator;

public class OperationsHandler {
	HashMap<String, Supplier> suppliers = new HashMap<String, Supplier>();
	HashMap<String, Warehouse> warehouses = new HashMap<String, Warehouse>();

	public Warehouse getWarehouse(String address) {
		if (warehouses.containsKey(address)) {
			Warehouse warehouse = warehouses.get(address);
			return warehouse;
		} else {
			return null;
		}
	}

	public Supplier getSupplier(String name) {
		if (suppliers.containsKey(name)) {
			Supplier receivedSupplier = suppliers.get(name);
			return receivedSupplier;
		} else {
			return null;
		}
	}

	public void addWarehouse(String address) {
		if (!warehouses.containsKey(address)) {
			warehouses.put(address, new Warehouse(address));
		} else {

		}

	}

	public void addSupplier(String name, String address) {
		if (!suppliers.containsKey(name)) {
			suppliers.put(name, new Supplier(name, address));
		} else {

		}
	}

	public void updateWarehouse(Warehouse warehouse) {
		String address = warehouse.getAddress();
		warehouses.put(address, new Warehouse(address));
	}

	public String getListWarehouses(HashMap<String, Warehouse> hashMap) {
		String listOfWarehouses = "";
		int warehouseNumber = 1;
		Iterator<HashMap.Entry<String, Warehouse>> iterator = hashMap.entrySet().iterator();

		while (iterator.hasNext()) {
			HashMap.Entry<String, Warehouse> entry = iterator.next();
			String address = entry.getValue().getAddress();
			listOfWarehouses += warehouseNumber+". "+address+"\n";
			warehouseNumber++;
		}
		return listOfWarehouses;
	}
	
	public String getListSuppliers (HashMap<String, Supplier> suppliers) {
		String listOfSuppliers = "";
		int supplierNumber = 1;
		Iterator<HashMap.Entry<String, Supplier>> iterator = suppliers.entrySet().iterator();

		while (iterator.hasNext()) {
			HashMap.Entry<String, Supplier> entry = iterator.next();
			String name = entry.getValue().getName();
			String address = entry.getValue().getAddress();
			listOfSuppliers += supplierNumber+". "+name+", "+address+"\n";
			supplierNumber++;
		}
		return listOfSuppliers;
	}
	

}
