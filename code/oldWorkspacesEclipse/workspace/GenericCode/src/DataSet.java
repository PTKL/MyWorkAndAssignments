
public class DataSet {
	double[] data;
	int dataSize;
	public DataSet () {
		data = new double[10];
		dataSize=0;
	}
	
	public void add(double x){
		if (dataSize<data.length){
			data[dataSize]=x;
			dataSize++;
		}
		else {
			double[] newData = new double[2*data.length];
			System.arraycopy(data, 0, newData, 0, data.length);
			newData[dataSize]=x;
			data=newData;
			dataSize++;
		}
	}
	
	public double alternatingSum(){
		double sum=0;
		for (int i=0; i<data.length; i++){
			if (i%2==0){
				sum=sum+data[i];
			}
			else {
				sum=sum-data[i];
			}
		}
		return sum;
	}
	
	public int getDataSize(){
		return dataSize;
		
	}
}
