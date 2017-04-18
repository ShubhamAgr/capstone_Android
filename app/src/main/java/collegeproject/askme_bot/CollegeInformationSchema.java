package collegeproject.askme_bot;

/**
 * Created by shubham on 12/4/17.
 */
public class CollegeInformationSchema {
    private String _id,information_title,information_description,information_file, created_on;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getInformation_title() {
        return information_title;
    }

    public void setInformation_title(String information_title) {
        this.information_title = information_title;
    }

    public String getInformation_description() {
        return information_description;
    }

    public void setInformation_description(String information_description) {
        this.information_description = information_description;
    }

    public String getInformation_file() {
        return information_file;
    }

    public void setInformation_file(String information_file) {
        this.information_file = information_file;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }
}
