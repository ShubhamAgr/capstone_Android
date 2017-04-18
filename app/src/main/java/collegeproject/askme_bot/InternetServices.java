package collegeproject.askme_bot;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by shubham on 1/3/17.
 */
public interface InternetServices {

    @GET("givequery")
    Observable<AIResult> mgetAIResults(@Query("user_query") String query);

    @GET("search_user/{query}")
    Observable<UsersSchema> searchUser(@Path("query") String query);

    @POST("search_events")
    Observable<List<EventsSchema>> searchEvents(@Body nQuery query);

    @GET("search_process/{query}")
    Observable<ProcessSchema> searchProcess(@Path("query") String query);

    @GET("search_college_information/{query}")
    Observable<CollegeInformationSchema> searchCollegeInformation(@Path("query") String query);

    @GET("search_college_buildings/{query}")
    Observable<CollegeBuildingSchema> searchCollegeBuildings(@Path("query") String query);

    @GET("search_placement_detail/{query}")
    Observable<String> searchPlacementDetail(@Path("query") String query);

    @GET("search_admission/{query}")
    Observable<AdmissionSchema> searchAdmissionDetail(@Path("query") String query);

}
