
public class Property {
	private String propertyName, city,owner;
	private double amount;
	private Plot p;
	
	public Property()
	{
		propertyName = "";
		city ="";
		owner ="";
		amount = 0.0;
		p = new Plot();
	}
	public Property(String propertyName, String city, double amount, String owner)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.amount = amount;
		this.owner= owner;
		p = new Plot();
	}
	public Property(String propertyName, String city, double amount, String owner, int x, int y, int width, int depth)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.amount = amount;
		this.owner= owner;
		p = new Plot(x,y,width,depth);
	}
	public Property (Property pro)
	{
		this.propertyName =pro.getPropertyName();
		this.city =pro.getCity();
		this.amount = pro.getRentAmount();
		this.owner = pro.getOwner();
		this.p = new Plot(pro.getPlot());
	}
	
	public String getPropertyName()
	{
		return propertyName;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public double getRentAmount()
	{
		return amount;
	}
	
	public String getOwner()
	{
		return owner;
	}
	public Plot getPlot()
	{
		return p;
	}
	public String toString()
	{
		return ""+propertyName+","+city+","+owner+","+amount;
	}
	
	
	
	
	
}
