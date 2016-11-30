package bg.elsys.ip.rest.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@ApiModel
public class Product {
	public static String DATE_FORMAT = "MM/dd/yyyy";
    private static int ID_COUNTER = 1;
	@ApiModelProperty("An unique id for product")
	private int id;
	@ApiModelProperty(value = "The name of the product", example = "Coca Cola")
	private String name;
	@ApiModelProperty(value = "The expiry date of the product", example = "10/12/2017")
    private Date expiryDate;
	@ApiModelProperty(value = "The quantity in storage of the product", example = "50")
	private float quantity;
	@ApiModelProperty(value = "The price of the product", example = "2.20")
	private float price;
	@ApiModelProperty(value = "The provider of the product", example = "Coca Cola")
	private String provider;
	@ApiModelProperty(value = "The department in which the product is stored", example = "Drinks")
	private String department;
	@ApiModelProperty(value = "The barcode of the product", example = "12345678")
	private String barcode;

	public Product() {
		this.id = ID_COUNTER++;
	}

	public Product(String name, String expiryDate, float quantity, float price, String provider, String department, String barcode) {
        this();
		this.name = name;
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
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
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		return df.format(expiryDate);
	}

	public void setExpiryDate(String expiryDate) {
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
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
