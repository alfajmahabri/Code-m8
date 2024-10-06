package in.buildbytes.codem8;

public class DataClass {
    private String dataNoh;
    private String dataVenue;
    private int data_count;
    private String data_date;

    // Empty constructor required for Firebase
    public DataClass() {
    }

    public DataClass(String dataNoh, String dataVenue, int data_count, String data_date) {
        this.dataNoh = dataNoh;
        this.dataVenue = dataVenue;
        this.data_count = data_count;
        this.data_date = data_date;
    }

    // Getter and Setter methods
    public String getDataNoh() {
        return dataNoh;
    }

    public void setDataNoh(String dataNoh) {
        this.dataNoh = dataNoh;
    }

    public String getDataVenue() {
        return dataVenue;
    }

    public void setDataVenue(String dataVenue) {
        this.dataVenue = dataVenue;
    }

    public int getData_count() {
        return data_count;
    }

    public void setData_count(int data_count) {
        this.data_count = data_count;
    }

    public String getData_date() {
        return data_date;
    }

    public void setData_date(String data_date) {
        this.data_date = data_date;
    }
}
