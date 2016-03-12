public class Consultant extends Person {
	
	private String language;
	private String type = "consultant";

	public Consultant(){
		
	}
	
	public Consultant(String name, String address, String phone, String email, String language){
		super(name, address, phone, email);
		this.language = language;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return getName() + "," + getAddress()+","+getPhone()+","+getEmail()+","+getLanguage()+","+getType();
	}
}
