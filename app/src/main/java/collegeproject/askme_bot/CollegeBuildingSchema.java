package collegeproject.askme_bot;

import java.util.ArrayList;

/**
 * Created by shubham on 12/4/17.
 */
public class CollegeBuildingSchema {
    private  String _id,block_id,block_information,created_on;
    private ArrayList<String> block_location;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getBlock_id() {
        return block_id;
    }

    public void setBlock_id(String block_id) {
        this.block_id = block_id;
    }

    public String getBlock_information() {
        return block_information;
    }

    public void setBlock_information(String block_information) {
        this.block_information = block_information;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public ArrayList<String> getBlock_location() {
        return block_location;
    }

    public void setBlock_location(ArrayList<String> block_location) {
        this.block_location = block_location;
    }
}
