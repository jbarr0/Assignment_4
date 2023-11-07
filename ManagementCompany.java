
public class ManagementCompany {
	private String managementCompanyName, taxID;
	private double rate;
	static final int MAX_PROPERTY = 5;
	static final int MAX_DEPTH =10;
	static final int MAX_WIDTH =10;
	private Property[] properties;
	private Plot plot;
	private int numberOfProperties;
	private int index;

	public ManagementCompany()
	{
		managementCompanyName="";
		taxID = "";
		rate =0.0;
		plot = new Plot(0,0,MAX_WIDTH,MAX_DEPTH);
		properties = new Property[MAX_PROPERTY];	
		numberOfProperties =0;
		index =0;
	
	}
	public ManagementCompany(String managementCompanyName, String taxID, double fee )
	{
		this.managementCompanyName=managementCompanyName;
		this.taxID =taxID;
		rate =fee;
		plot = new Plot(0,0,MAX_WIDTH,MAX_DEPTH);
		properties = new Property[MAX_PROPERTY];
		numberOfProperties =0;
		index =0;

		
	}
	public ManagementCompany(String managementCompanyName, String taxID, double fee, int x, int y,int width, int depth)
	{
		this.managementCompanyName=managementCompanyName;
		this.taxID =taxID;
		rate =fee;
		plot = new Plot(x,y,width,depth);
		properties = new Property[MAX_PROPERTY];
		numberOfProperties =0;
		index =0;


		
	}
	public ManagementCompany(ManagementCompany m )
	{
		
	}
	public void setMgmFeePer(double fee)
	{
		this.rate = fee; 
	}
	public void setName (String s)
	{
		this.managementCompanyName =s;
	}
	public void setPlot(Plot p)
	{
		this.plot = p;
	}
	public void setTaxId(String s)
	{
		this.taxID =s;
	}
	public double getMgmFeePer()
	{
		return rate;
	}
	public String getName()
	{
		return managementCompanyName;
	}
	public Plot getPlot()
	{
		return plot;
	}
	public Property[] getProperties()
	{
		return properties;
	}
	public int getPropertiesCount()
	{
		return numberOfProperties;
	}
	public String getTaxID()
	{
		return taxID;
	}
	
	public int addProperty (String name, String city, double rent, String owner)
	{
		if (numberOfProperties >5 )
			return -1;
		properties[numberOfProperties] = new Property (name,city,rent,owner);
		if (properties[numberOfProperties] == null)
			return -2;
		if(!(this.plot.encompasses(properties[numberOfProperties].getPlot())))
			return -3;	
		for ( int i =0;i<numberOfProperties;i++)
		{
			if(numberOfProperties == i)
				i++;
			if(properties[numberOfProperties].getPlot().overlaps(properties[i].getPlot()))
				return -4;
		}
		numberOfProperties++;
		int rIndex;
		
		rIndex = numberOfProperties -1;
		return rIndex;
	}
	public int addProperty(String name,String city, double rent, String owner, int x, int y, int width, int depth)
	{
		if (numberOfProperties >5 )
			return -1;
		properties[numberOfProperties] = new Property (name,city,rent,owner,x,y,width,depth);
		if (properties[numberOfProperties] == null)
			return -2;
		if(!(this.plot.encompasses(properties[numberOfProperties].getPlot())))
			return -3;	
		for ( int i =0;i<numberOfProperties+1;i++)
		{
			if(numberOfProperties == i)
				i++;
			if(properties[numberOfProperties].getPlot().overlaps(properties[i].getPlot()))
				return -4;
		}

		numberOfProperties++;
		int rIndex;

		rIndex = numberOfProperties -1;
		return rIndex;

	}
	public int addProperty(Property p)
	
	{
		if (numberOfProperties >5 )
			return -1;
		properties[numberOfProperties] = new Property (p);
		if (properties[numberOfProperties] == null)
			return -2;
		if(!(this.plot.encompasses(properties[numberOfProperties].getPlot())))
			return -3;	
		for ( int i =0;i<numberOfProperties;i++)
		{
			if(numberOfProperties == i)
				i++;
			if(properties[numberOfProperties].getPlot().overlaps(properties[i].getPlot()))
				return -4;
		}
		numberOfProperties++;
		int rIndex;
		
		rIndex = numberOfProperties -1;
		return rIndex;
		
	}
	public double getTotalRent()
	{
		double total=0.0;
		for ( int i =0;i<numberOfProperties; i++)
		{
			total += this.properties[i].getRentAmount();
		}
		return total;
	}
	public Property getHighestRentPropperty()
	{
		Property highest = properties[0];
		for (int i = 1; i < numberOfProperties; i++)
		{
			if (properties[i].getRentAmount()>highest.getRentAmount())
			{
				highest = properties[i];
			}
		}
		return highest;
	}
	public void removeLastProperty()
	{
		properties[numberOfProperties-1]=null;
	}
	public boolean isPropertiesFull()
	{
		if (numberOfProperties >= 5)
			return true;
		return false;
	}
	public boolean isManagementFeeValid() 
	{
		if (rate >0 && rate <100)
		{
			return true;
		}
		return false;
	}
	
	
	public String toString()
	{
		String s = "List of the properties for " + managementCompanyName + ", taxID: " + taxID + "\n______________________________________________________";
		for (int i =0; i <numberOfProperties; i++)
		{
			s+="\n" + properties[i].toString();
		}
		s+="\n______________________________________________________\n\n total management Fee: " + (getTotalRent()*(rate/100));
		return s;
	}
}
