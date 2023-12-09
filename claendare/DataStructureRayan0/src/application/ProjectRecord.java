package application;

////Name:Rayan Ghnimat.
//Student Num:1211073.
//Dr:Murad Njoum.
//My first Data Structure Project about gaza and the problem of electricity in gaza because of israel.
//#######################################################################################################################################################3
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

//project record class to put the data file in it 
public class ProjectRecord {
	private LocalDate localDate;
	private Double israeliLinesData;
	private Double gazaPowerData;
	private Double egyptianLinesData;
	private Double totalSupplyData;
	private Double overallDemandData;
	private Double powerCutsData;
	private Double tempData;

	public ProjectRecord() {// default constructur

	}

	public ProjectRecord(LocalDate localDate, Double israeliLinesData, Double gazaPowerData, Double egyptianLinesData,
			Double totalSupplyData, Double overallDemandData, Double powerCutsData, Double tempData) {
		super();
		this.localDate = localDate;
		this.israeliLinesData = israeliLinesData;
		this.gazaPowerData = gazaPowerData;
		this.egyptianLinesData = egyptianLinesData;
		this.totalSupplyData = totalSupplyData;
		this.overallDemandData = overallDemandData;
		this.powerCutsData = powerCutsData;
		this.tempData = tempData;
	}

	public LocalDate getDate() {
		return localDate;
	}

	public void setDate(LocalDate localDate2) {
		this.localDate = localDate2;
	}

	public Double getIsraeliLinesData() {
		return israeliLinesData;
	}

	public void setIsraeliLinesData(Double israeliLinesData) {
		this.israeliLinesData = israeliLinesData;
	}

	public Double getGazaPowerData() {
		return gazaPowerData;
	}

	public void setGazaPowerData(Double gazaPowerData) {
		this.gazaPowerData = gazaPowerData;
	}

	public Double getEgyptianLinesData() {
		return egyptianLinesData;
	}

	public void setEgyptianLinesData(Double egyptianLinesData) {
		this.egyptianLinesData = egyptianLinesData;
	}

	public Double getTotalSupplyData() {
		return totalSupplyData;
	}

	public void setTotalSupplyData(Double totalSupplyData) {
		this.totalSupplyData = totalSupplyData;
	}

	public Double getOverallDemandData() {
		return overallDemandData;
	}

	public void setOverallDemandData(Double overallDemandData) {
		this.overallDemandData = overallDemandData;
	}

	public Double getPowerCutsData() {
		return powerCutsData;
	}

	public void setPowerCutsData(Double powerCutsData) {
		this.powerCutsData = powerCutsData;
	}

	public Double getTempData() {
		return tempData;
	}

	public void setTempData(Double tempData) {
		this.tempData = tempData;
	}
//****************************************************************************************************************************

	@Override
	public String toString() {
		return localDate + "," + israeliLinesData + "," + gazaPowerData + "," + egyptianLinesData + ","
				+ totalSupplyData + "," + overallDemandData + "," + powerCutsData + "," + tempData;
	}

	public Double getField(String fieldName) {
		Objects.requireNonNull(fieldName, "fieldName cannot be null");

		switch (fieldName.toLowerCase()) {
		case "israelilinesdata":
			return getIsraeliLinesData();
		case "gazapowerdata":
			return getGazaPowerData();
		case "egyptianlinesdata":
			return getEgyptianLinesData();
		case "totalsupplydata":
			return getTotalSupplyData();
		case "overalldemanddata":
			return getOverallDemandData();
		case "powercutsdata":
			return getPowerCutsData();
		case "tempdata":
			return getTempData();
		default:
			throw new IllegalArgumentException("Invalid fieldName: " + fieldName);
		}
	}
	 public Double getField(int columnIndex) {
	        switch (columnIndex) {
	            case 0:
	                return (double) localDate.toEpochDay(); // Assuming 'date' is a LocalDate
	            case 1:
	                return israeliLinesData;
	            case 2:
	                return gazaPowerData;
	            case 3:
	                return egyptianLinesData;
	            case 4:
	                return totalSupplyData;
	            case 5:
	                return overallDemandData;
	            case 6:
	                return powerCutsData;
	            case 7:
	                return tempData;
	            default:
	                throw new IllegalArgumentException("Invalid column index: " + columnIndex);
	        }
	    }

}
