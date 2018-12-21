package application;

public class PieElement {
	public String name;
	public int values;
	
	public PieElement(String name, int value) {
		this.name = name;
		this.values = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValues() {
		return values;
	}
	public void setValues(int values) {
		this.values = values;
	}
	
}
