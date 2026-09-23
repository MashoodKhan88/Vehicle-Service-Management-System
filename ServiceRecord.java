public class ServiceRecord{
    String vehicleNumber;
    String serviceType;
    String serviceDate;
    Double serviceCost;

    public ServiceRecord(String vehicleNumber, String serviceType, String serviceDate, Double serviceCost){
        this.vehicleNumber = vehicleNumber;
        this.serviceType = serviceType;
        this.serviceDate = serviceDate;
        this.serviceCost = serviceCost;
    }
}