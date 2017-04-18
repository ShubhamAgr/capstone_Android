package collegeproject.askme_bot;

import java.util.ArrayList;

/**
 * Created by shubham on 14/3/17.
 */
public class AIResult {

    private Result result;
    private String lang;
    private String id;
    private Status status;
    private  String sessionId;
    private  String timestamp;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

class Result{
    private String action;
    private boolean actionIncomplete;
    private MetaData metadata;
    private ArrayList<String> contexts;
    private String resolvedQuery;
    private float score;
    private  String source;
    private Fullfillment fulfillment;
    private Parameters parameters;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public boolean isActionIncomplete() {
        return actionIncomplete;
    }

    public void setActionIncomplete(boolean actionIncomplete) {
        this.actionIncomplete = actionIncomplete;
    }

    public MetaData getMetadata() {
        return metadata;
    }

    public void setMetadata(MetaData metadata) {
        this.metadata = metadata;
    }

    public ArrayList<String> getContexts() {
        return contexts;
    }

    public void setContexts(ArrayList<String> contexts) {
        this.contexts = contexts;
    }

    public String getResolvedQuery() {
        return resolvedQuery;
    }

    public void setResolvedQuery(String resolvedQuery) {
        this.resolvedQuery = resolvedQuery;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Fullfillment getFulfillment() {
        return fulfillment;
    }

    public void setFulfillment(Fullfillment fulfillment) {
        this.fulfillment = fulfillment;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }
}
class MetaData{
    private  String intentId;
    private  String webhookUsed;
    private  String webhookForSlotFillingUsed;
    private  String intentName;

    public String getIntentId() {
        return intentId;
    }

    public void setIntentId(String intentId) {
        this.intentId = intentId;
    }

    public String getWebhookUsed() {
        return webhookUsed;
    }

    public void setWebhookUsed(String webhookUsed) {
        this.webhookUsed = webhookUsed;
    }

    public String getWebhookForSlotFillingUsed() {
        return webhookForSlotFillingUsed;
    }

    public void setWebhookForSlotFillingUsed(String webhookForSlotFillingUsed) {
        this.webhookForSlotFillingUsed = webhookForSlotFillingUsed;
    }

    public String getIntentName() {
        return intentName;
    }

    public void setIntentName(String intentName) {
        this.intentName = intentName;
    }
}

class Fullfillment{
    private ArrayList<Messages> messages;
    private String speech;

    public ArrayList<Messages> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Messages> messages) {
        this.messages = messages;
    }

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }
}

class Messages{
    private  String speech;
    private int type;

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
class Parameters{
    private String typeOfEvent;
    private String department_branch;
    private String TypeOfEvents;
    private String date_time;
    private String date;
    private String Fees;
    private String discipline;
    private String procedure;
    private String EventsName;
    private String PrizeMoney;


    //For Placement
    private String visitedPastComp;
    private String date_period;
    private String numbers;
    private String packagesOffered1;
    private String packagesOffered;


    private String policy;
    private String companiesPlacement;
    private String upcoming1;
    private String upcoming;

    //For navigation..
    private String blockBuilding;

    //For Admission
    private  String scholarship;
    private  String LpuNest;
    private  String Eligibility;
    private  String Benefits;
//    private String Fees;
//    private String discipline;
//    private  String procedure;
//    private String policy;
    private  String Subjects;
    private String currentQualification;

    //For channcellory
//    private String department_branch;
    private String designation;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getVisitedPastComp() {
        return visitedPastComp;
    }

    public void setVisitedPastComp(String visitedPastComp) {
        this.visitedPastComp = visitedPastComp;
    }

    public String getDate_period() {
        return date_period;
    }

    public void setDate_period(String date_period) {
        this.date_period = date_period;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getPackagesOffered1() {
        return packagesOffered1;
    }

    public void setPackagesOffered1(String packagesOffered1) {
        this.packagesOffered1 = packagesOffered1;
    }

    public String getPackagesOffered() {
        return packagesOffered;
    }

    public void setPackagesOffered(String packagesOffered) {
        this.packagesOffered = packagesOffered;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getCompaniesPlacement() {
        return companiesPlacement;
    }

    public void setCompaniesPlacement(String companiesPlacement) {
        this.companiesPlacement = companiesPlacement;
    }

    public String getUpcoming1() {
        return upcoming1;
    }

    public void setUpcoming1(String upcoming1) {
        this.upcoming1 = upcoming1;
    }

    public String getUpcoming() {
        return upcoming;
    }

    public void setUpcoming(String upcoming) {
        this.upcoming = upcoming;
    }

    public String getBlockBuilding() {
        return blockBuilding;
    }

    public void setBlockBuilding(String blockBuilding) {
        this.blockBuilding = blockBuilding;
    }

    public String getScholarship() {
        return scholarship;
    }

    public void setScholarship(String scholarship) {
        this.scholarship = scholarship;
    }

    public String getLpuNest() {
        return LpuNest;
    }

    public void setLpuNest(String lpuNest) {
        LpuNest = lpuNest;
    }

    public String getEligibility() {
        return Eligibility;
    }

    public void setEligibility(String eligibility) {
        Eligibility = eligibility;
    }

    public String getBenefits() {
        return Benefits;
    }

    public void setBenefits(String benefits) {
        Benefits = benefits;
    }

    public String getSubjects() {
        return Subjects;
    }

    public void setSubjects(String subjects) {
        Subjects = subjects;
    }

    public String getCurrentQualification() {
        return currentQualification;
    }

    public void setCurrentQualification(String currentQualification) {
        this.currentQualification = currentQualification;
    }

    public String getDepartment_branch() {
        return department_branch;
    }

    public void setDepartment_branch(String department_branch) {
        this.department_branch = department_branch;
    }

    public String getTypeOfEvents() {
        return TypeOfEvents;
    }

    public void setTypeOfEvents(String typeOfEvents) {
        TypeOfEvents = typeOfEvents;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFees() {
        return Fees;
    }

    public void setFees(String fees) {
        Fees = fees;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getEventsName() {
        return EventsName;
    }

    public void setEventsName(String eventsName) {
        EventsName = eventsName;
    }

    public String getPrizeMoney() {
        return PrizeMoney;
    }

    public void setPrizeMoney(String prizeMoney) {
        PrizeMoney = prizeMoney;
    }

    public String getTypeOfEvent() {
        return typeOfEvent;
    }

    public void setTypeOfEvent(String typeOfEvent) {
        this.typeOfEvent = typeOfEvent;
    }
}

class Status{
    private int code;
    private String errorType;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }
}