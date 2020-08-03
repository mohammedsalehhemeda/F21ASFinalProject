package f21as.checkinsystem.models;

public class Baggage {

	private Double length;
	private Double width;
	private Double height;
	private Double weight;
	private Double excess_fee_paid;
	
	//Getters
	public Double getVolume() {
		return (length*width*height)/(100*100*100); //returning in cubic meter
	}
	
	public Double getWeight() {
		return weight;
	}
	
	public Double calcuateExcessFee(Double allowed_weight, Double fee_per_kg) {
		Double excess_fee = 0.0;
		if (weight > allowed_weight)
		{
			Double difference  = weight - allowed_weight;
			excess_fee =  difference * fee_per_kg;
		}
		return excess_fee;
	}
	
	public void setExcessFee(Double _excess_fee) {
		excess_fee_paid = _excess_fee;
	}
	
		public Double getExcessFee() {
			return excess_fee_paid;
    }
	
		
	public Baggage(Double _length_cm, Double _width_cm,Double _height_cm, Double _weight_kg) {
		length = _length_cm;
		width = _width_cm;
		height = _height_cm;
		weight = _weight_kg;
	}
}
