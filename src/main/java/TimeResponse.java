import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeResponse {

    @JsonProperty("$id")
    private String id;
    @JsonProperty("currentDateTime")
    private String currentDateTime;
    @JsonProperty("utcOffset")
    private String utcOffset;
    @JsonProperty("isDayLightSavingsTime")
    private Boolean isDayLightSavingsTime;
    @JsonProperty("dayOfTheWeek")
    private String dayOfTheWeek;
    @JsonProperty("timeZoneName")
    private String timeZoneName;
    @JsonProperty("currentFileTime")
    private long currentFileTime;
    @JsonProperty("ordinalDate")
    private String ordinalDate;
    @JsonProperty("serviceResponse")
    private Object serviceResponse;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(String currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    public String getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(String utcOffset) {
        this.utcOffset = utcOffset;
    }

    public Boolean getIsDayLightSavingsTime() {
        return isDayLightSavingsTime;
    }

    public void setIsDayLightSavingsTime(Boolean isDayLightSavingsTime) {
        this.isDayLightSavingsTime = isDayLightSavingsTime;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public String getTimeZoneName() {
        return timeZoneName;
    }

    public void setTimeZoneName(String timeZoneName) {
        this.timeZoneName = timeZoneName;
    }

    public long getCurrentFileTime() {
        return currentFileTime;
    }

    public void setCurrentFileTime(long currentFileTime) {
        this.currentFileTime = currentFileTime;
    }

    public String getOrdinalDate() {
        return ordinalDate;
    }

    public void setOrdinalDate(String ordinalDate) {
        this.ordinalDate = ordinalDate;
    }

    public Object getServiceResponse() {
        return serviceResponse;
    }

    public void setServiceResponse(Object serviceResponse) {
        this.serviceResponse = serviceResponse;
    }

}
