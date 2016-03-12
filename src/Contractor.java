public class Contractor extends Person {

	private String carRegistration;
	private String type = "contractor";

public Contractor(){
		
	}
	
	public Contractor(String name, String address, String phone, String email, String reg){
		super(name, address, phone, email);
		carRegistration = reg;
	}

	
	
	public String getType() {
		return type;
	}

	public String getCarRegistration() {
		return carRegistration;  
	}

	public void setCarRegistration(String carRegistration) {
		this.carRegistration = carRegistration;
	}
	
	@Override
	public String toString() {
		return getName() + "," + getAddress()+","+getPhone()+","+getEmail()+","+getCarRegistration()+","+getType();
	}
}
