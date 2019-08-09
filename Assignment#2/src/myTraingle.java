
public class myTraingle {
	
	private double sideA, sideB, sideC;
	
	
	//constructor 
	myTraingle(double sideA, double sideB, double sideC){
		if (sideA < 0 || sideB < 0 || sideC < 0) {
			sideA = 1;
			sideB = 1;
			sideC = 1;
		}
		setSide(sideA, sideB, sideC);
		
		
	}

  public void setSide( double a, double b, double c) {
 	if(a < 0 || b < 0 || c < 0) {
 		a = 1;
 		b = 1;
 		c = 1;
 	}
	 if ((a+b)>c && (a+c)>b && (b+c)>a) {
 	sideA = a;
 	sideB = b;
 	sideC = c;
 	}
 }
  public double getSideA() {
    	   return sideA;
      }
     
  public double getSideB() {
    	    return sideB;
      }
     
  public double getSideC() {
    	     return sideC;
      }
     
  public double perimeter(double a, double b, double c) {
    	return (a + b + c);
    }
    
  public double Area(double a, double b, double c) {
    double area, product;
    double p = perimeter(a,b,c) / 2;
    	product = p * (p - a)*(p - b)*(p - c);
    area = Math.sqrt(product);
    return area;
  }
}




