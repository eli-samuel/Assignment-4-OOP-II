public class CellPhone {

    private long serialNum;
    private String brand;
    private int year;
    private double price;

    public CellPhone(long serialNum, String brand, double price, int year){
        this.serialNum = serialNum;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    public CellPhone(CellPhone c){
        this.serialNum = c.serialNum;
        this.brand = c.brand;
        this.year = c.year;
        this.price = c.price;
    }

    public long getSerialNum() {
		return serialNum;
	}

    public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}

    public String getBrand() {
		return brand;
	}

    public void setBrand(String brand) {
		this.brand = brand;
	}

    public int getYear() {
		return year;
	}

    public void setYear(int year) {
		this.year = year;
	}

    public double getPrice() {
		return price;
	}

    public void setPrice(double price) {
		this.price = price;
	}

    public CellPhone clone(){
        return new CellPhone(this);
    }

    public String toString(){
        return "serial number: "+ serialNum +" brand: "+ brand + " manufacturing year: "+ year + " price: "
        + price;
    }

    public boolean equals(Object o){
        if(o == null)return false;
        else if(o.getClass() != this.getClass())return false;
        else{
            CellPhone c = (CellPhone) o;

            return(this.brand.equals(c.brand) && this.year == c.year && this.price == c.price);
        }
    }
}
