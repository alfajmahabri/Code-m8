package in.buildbytes.codem8;

public class DataClass {
    private String dataNoh;
    private String dataVenue;
    private int data_count;
    private String data_date;
    private String leaderName;
    private int currentTeamCount;

    // Empty constructor required for Firebase
    public DataClass() {
    }

    // Updated constructor with new variables
    public DataClass(String dataNoh, String dataVenue, int data_count, String data_date, String leaderName, int currentTeamCount) {
        this.dataNoh = dataNoh;
        this.dataVenue = dataVenue;
        this.data_count = data_count;
        this.data_date = data_date;
        this.leaderName = leaderName;
        this.currentTeamCount = currentTeamCount;
    }

    // Getter and Setter methods for old variables
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

    // Getter and Setter methods for new variables
    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public int getCurrentTeamCount() {
        return currentTeamCount;
    }

    public void setCurrentTeamCount(int currentTeamCount) {
        this.currentTeamCount = currentTeamCount;
    }
}
