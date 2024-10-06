package in.buildbytes.codem8;

public class DataClass {
    private String dataNoh;
    private String dataVenue;
    private int data_count;
    private long data_date;

    public String getDataNoh() {
        return dataNoh;
    }

    public String getDataVenue() {
        return dataVenue;
    }

    public int getData_count() {
        return data_count;
    }

    public long getData_date() {
        return data_date;
    }

    public DataClass(String dataNoh, String dataVenue, int data_count, long data_date) {
        this.dataNoh = dataNoh;
        this.dataVenue = dataVenue;
        this.data_count = data_count;
        this.data_date = data_date;
    }

    public void setDataNoh(String dataNoh) {
        this.dataNoh = dataNoh;
    }

    public void setDataVenue(String dataVenue) {
        this.dataVenue = dataVenue;
    }

    public void setData_count(int data_count) {
        this.data_count = data_count;
    }

    public void setData_date(long data_date) {
        this.data_date = data_date;
    }
}
