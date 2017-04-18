package collegeproject.askme_bot;

/**
 * Created by shubham on 12/4/17.
 */
public class EventsSchema {
    private String _id,department_branch,discipline,EventsName,Fees,PrizeMoney,procedure,date_time,TypeOfEvents,event_name,event_type,event_venue,
            event_date,event_information,created_on;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDepartment_branch() {
        return department_branch;
    }

    public void setDepartment_branch(String department_branch) {
        this.department_branch = department_branch;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getEventsName() {
        return EventsName;
    }

    public void setEventsName(String eventsName) {
        EventsName = eventsName;
    }

    public String getFees() {
        return Fees;
    }

    public void setFees(String fees) {
        Fees = fees;
    }

    public String getPrizeMoney() {
        return PrizeMoney;
    }

    public void setPrizeMoney(String prizeMoney) {
        PrizeMoney = prizeMoney;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getTypeOfEvents() {
        return TypeOfEvents;
    }

    public void setTypeOfEvents(String typeOfEvents) {
        TypeOfEvents = typeOfEvents;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public String getEvent_venue() {
        return event_venue;
    }

    public void setEvent_venue(String event_venue) {
        this.event_venue = event_venue;
    }

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public String getEvent_information() {
        return event_information;
    }

    public void setEvent_information(String event_information) {
        this.event_information = event_information;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }
}
