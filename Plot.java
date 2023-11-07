
public class Plot {

	private int x,y,depth,width;

	public Plot()
	{
		this.x =0;
		this.y =0;
		this.depth =1;
		this.width = 1;
	}	
	
	public Plot(int x, int y,int width, int depth)
	{
		this.y =y;
		this.x =x;
		this.depth = depth;
		this.width = width;
	}
	
	public Plot(Plot otherPlot)
	{
		this.x = otherPlot.getX();
		this.y = otherPlot.getY();
		this.width = otherPlot.getWidth();
		this.depth = otherPlot.getDepth();
	}
	
	public void setX (int x)
	{
		this.x = x;
	}
	
	public void setY (int y)
	{
		this.y = y;
	}
	
	public void setDepth(int depth)
	{
		this.depth = depth;
	}
	
	public void setWidth (int width)
	{
		this.width = width;
	}
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public int getWidth()
	{
		return width;
	}
	public int getDepth()
	{
		return depth;
	}
	public String toString()
	{
		return "" + x + ","+ y +","+width+","+depth;
	}
	public boolean overlaps (Plot p)
	{
		if (this.x >= p.getX() && this.y >= p.getY())
		{
			if (p.getWidth()>this.width || p.getDepth()>this.depth)
			{
				return true;
			}
			
			if (p.getWidth()<this.width && p.getDepth()<this.depth)
			{
				return true;
			}
			else 
				return false;
			
		}
		else if(this.x<p.getX() && this.y <p.getY())
		{
			if (p.getWidth()<this.width || p.getDepth() <this.depth)
			{
				return true;
			}
			else
			return false;
		}
		return false;
		
	}
	public boolean encompasses(Plot p)
	{
		if (this.x >= p.getX()&& this.y>=p.getY())
		{
			if (this.width >= p.getDepth()&&this.depth >= p.getDepth())
			{
				return true;
			}
			
		}
		if (this.x<=p.getX() && this.y <= p.getY() )
			if (this.width > p.getDepth()&&  this.depth > p.getDepth())
			{
				return true;
			}
			else
				return false;
		
			return false;
	}
	}


