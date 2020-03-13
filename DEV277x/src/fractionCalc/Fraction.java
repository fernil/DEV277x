package fractionCalc;

public class Fraction {
	private int numerator;
	private int denominator;

	public Fraction(int numerator, int denominator) {
		if (denominator == 0) {
			throw new IllegalArgumentException();
		}
		if (numerator < 0 && denominator < 0) {
			numerator *= -1;
			denominator *= -1;
		} else if (denominator < 0) {
			numerator *= -1;
			denominator *= -1;
		}
		this.numerator=numerator;
		this.denominator=denominator;
	}

	public Fraction(int num) {
		this(num,1);
	}

	public Fraction() {
		this(0,1);
	}

	public int getNumerator() {
		return numerator;
	}
	public int getDenominator() {
		return denominator;
	}
	public String toString() {
		return numerator+"/"+denominator;
	}
	public double toDouble() {
		return (double)numerator/denominator;
	}
	public Fraction add(Fraction frac) {
		Fraction f=new Fraction();
		if(this.denominator==frac.denominator) {
			f.numerator=this.numerator+frac.numerator;
			f.denominator=this.denominator;
			f.toLowerTerms();
			return f;
		}
		f.denominator=this.denominator*frac.denominator;
		f.numerator=this.numerator*frac.denominator+this.denominator*frac.numerator;
			return f;
	}
	public Fraction subtract(Fraction frac) {
		Fraction f=new Fraction();
		if(this.denominator==frac.denominator) {
			f.numerator=this.numerator-frac.numerator;
			f.denominator=this.denominator;
			f.toLowerTerms();
			return f;
		}
		f.denominator=this.denominator*frac.denominator;
		f.numerator=this.numerator*frac.denominator-this.denominator*frac.numerator;
		f.toLowerTerms();
			return f;
	}
	public Fraction multiply(Fraction frac) {
		Fraction f=new Fraction();
		f.numerator=this.numerator*frac.numerator;
		f.denominator=this.denominator*frac.denominator;
		f.toLowerTerms();
		return f;
	}
	public Fraction divide(Fraction frac) {
		Fraction f=new Fraction();
		f.numerator=this.numerator*frac.denominator;
		f.denominator=this.denominator*frac.numerator;
		f.toLowerTerms();
		return f;
	}
	
	public boolean equals(Object other) {
		 if(!(other instanceof Fraction)) {
		        return false;}
		 else {
		 Fraction verify=(Fraction) other;
		 Fraction tempver=new Fraction(verify.numerator,verify.denominator);
		 Fraction tempfr=new Fraction(this.numerator,this.denominator);
		 tempfr.toLowerTerms();
		 tempver.toLowerTerms();
		 if((tempver.numerator==tempfr.numerator)&&(tempver.denominator==tempfr.denominator)) {
			 return true;
		 }return false;
				 
		 }
	}
	public void toLowerTerms() {
		int low=gdc(this.numerator,this.denominator);
		this.numerator=this.numerator/low;
		this.denominator=this.denominator/low;
		
	}
	public static int gdc(int num, int den) {
		int gdc=1;
		for(int i=1;i<=Math.abs(num);i++) {
			if(num%i==0&&den%i==0) {
				if(i>gdc) {
					gdc=i;
				}
			}
		}return gdc;
	}
}
