package hibernatehelloworld;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Person {
	

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "street",column = @Column(name = "shipping_street")),
		@AttributeOverride(name = "city",column = @Column(name = "shipping_city")),
		@AttributeOverride(name = "pincode",column = @Column(name = "shipping_pincode"))

	})
	private Address shipping_address;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "street",column = @Column(name = "billing_street")),
		@AttributeOverride(name = "city",column = @Column(name = "billing_city")),
		@AttributeOverride(name = "pincode",column = @Column(name = "billing_pincode"))

	})
	private Address billing_address;
	

	public Person(long id, String name, Address shipping_address, Address billing_address) {
		super();
		this.id = id;
		this.name = name;
		this.shipping_address = shipping_address;
		this.billing_address = billing_address;
	}


	public Person(String name, Address shipping_address, Address billing_address) {
		super();
		this.name = name;
		this.shipping_address = shipping_address;
		this.billing_address = billing_address;
	}
	
}
