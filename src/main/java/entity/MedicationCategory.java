package entity;

public class MedicationCategory {
	private int id;
	private String name;
	
	public MedicationCategory() {}
	
	public MedicationCategory(
		int id,
		String name
	) {
		this.setId(id);
		this.setName(name);
	}
	
	public int getId() { return this.id; }
	public String getName() { return this.name; }
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
}
