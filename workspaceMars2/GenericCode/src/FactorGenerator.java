
public class FactorGenerator {
	int num, factor, i, remain;
	boolean hasF=true;
	public FactorGenerator (int numberToFactor){
		num=numberToFactor;
		i=2;
	}
	
	public int nextFactor(int i){
		if (num%i==0){
			num=num/i;
			factor=i;
		}
		return factor;
	}
	
	public boolean hasMoreFactors(int i){
		if (num%i!=0){
			hasF=false;
		}
		return hasF;
	}
}
