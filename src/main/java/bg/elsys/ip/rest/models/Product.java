package bg.elsys.ip.rest.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@XmlRootElement
public class Product {
    private static int ID_COUNTER = 1;
	private int id;
	private String name;
    private Date expiryDate;
	private float quantity;
	private float price;
	private String provider;
	private String department;
	private String barcode;

	public Product() {
		this.id = ID_COUNTER++;
	}

	public Product(String name, String expiryDate, float quantity, float price, String provider, String department, String barcode) {
        this();
		this.name = name;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.expiryDate = df.parse(expiryDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.quantity = quantity;
		this.price = price;
		this.provider = provider;
		this.department = department;
		this.barcode = barcode;
	}

	public String getExpiryDate() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(expiryDate);
	}

	public void setExpiryDate(String expiryDate) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.expiryDate = df.parse(expiryDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
