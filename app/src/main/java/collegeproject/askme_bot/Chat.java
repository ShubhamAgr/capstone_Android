package collegeproject.askme_bot;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;
import javax.inject.Named;
import android.speech.tts.TextToSpeech;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class Chat extends Fragment {
    @Inject
    @Named("vipin")
    Retrofit retrofit;

    @Inject @Named("shubham")
    Retrofit retrofit2;
    public static double lat;
    public static double lang;
    private SpeechRecognizer mSpeechRecognizer;
    private Intent mSpeechRecognizerIntent;
    private  final int REQ_CODE_SPEECH_INPUT = 100;
    private boolean mIsListening;
    private static TextToSpeech t1;
    private static InternetServices internetServices;
    private static  InternetServices minternetServices;
    private Subscription subscription;
    private static final Timer timer = new Timer();
    GPSTracker gps;
    private static EditText editText;
    private static RecyclerView recyclerView;
    private  static ResultAdapter adapter;
    private static LinearLayoutManager llm;
    private  static TabLayout tabhost;
    private  static List<String> results;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_chat, container, false);
        editText = (EditText) view.findViewById(R.id.meditText);
        editText.setText("Data Do");
        ((AskMe_App) getActivity().getApplication()).getNetAppComponent().inject(this);
//        adapter = null;
        tabhost = (TabLayout) getActivity().findViewById(R.id.tabs);
        results = null;
        lat = 0;
        lang = 0;
        internetServices = retrofit.create(InternetServices.class);
        minternetServices = retrofit2.create(InternetServices.class);
        recyclerView = (RecyclerView) view.findViewById(R.id.results_recycler_view);
        llm = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,true);
        recyclerView.setLayoutManager(llm);
        t1=new TextToSpeech(getActivity().getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });
        mIsListening = false;
        mSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(getActivity());
        mSpeechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,
                getActivity().getPackageName());


        SpeechRecognitionListener listener = new SpeechRecognitionListener();
        mSpeechRecognizer.setRecognitionListener(listener);
        results = new ArrayList<String>();
        String message = "Hi there, I am your Personal University Assistant. I will help you with your queries with lovely professional " +
                "university";
        results.add(0,message);
        adapter = new ResultAdapter(results);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
/**************************************************************************/
        return (view);//inflater.inflate(R.layout.fragment_chat, container, false);
    }
    public   void onClickA(){
        Log.d("aa","aa");
//        Toast.makeText(getActivity(),"afdas",Toast.LENGTH_LONG).show();
        String query = editText.getText().toString();
        if(results == null){
            results = new ArrayList<String>();
            results.add(0,query);
            adapter = new ResultAdapter(results);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }else {
            results.add(0,query);
            adapter.notifyDataSetChanged();
        }
        Log.d("Query",query);
        hiToAi(query);
    }

    public void onClickB(){
        promptSpeechInput();
    }


    //showing google speech input dialog
    private void promptSpeechInput(){
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Prompt");
        try{
            getActivity().startActivityForResult(intent,REQ_CODE_SPEECH_INPUT);

        }catch (ActivityNotFoundException a){
            Toast.makeText(getActivity().getApplicationContext(),
                    "Speech not supported",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public  void setText(String s){
        editText.setText(s);
        String query = editText.getText().toString();
        if(results == null){
            results = new ArrayList<String>();
            results.add(0,query);
            adapter = new ResultAdapter(results);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }else {
            results.add(0,query);
            adapter.notifyDataSetChanged();
        }
        Log.d("Query",query);
        hiToAi(query);
    }


    public void hiToAi(String query){

        Observable<AIResult> getAIResults = internetServices.mgetAIResults(query);
        getAIResults.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(aiResult -> {

            if(results == null){
                results = new ArrayList<String>();
                results.add(0,aiResult.getResult().getFulfillment().getMessages().get(0).getSpeech());
                adapter = new ResultAdapter(results);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }else {
                Log.d("aaa",aiResult.getResult().getMetadata().getIntentName());
                String caseValue = aiResult.getResult().getMetadata().getIntentName();
                switch(caseValue){
                 case ("Events"):
                     Log.d("e","1");
                     caseEvent(aiResult);
                     break;
                    case("Placement"):
                        Log.d("e","2");
                        casePlacement(aiResult);
                        break;
                    case("Admission"):
                        Log.d("e","3");
                        caseAdmission(aiResult);
                        break;
                    case ("Administrator.person"):
                        Log.d("e","4");
                        caseAdministrator(aiResult);
                        break;
                    case("maps.navigate"):
                        Log.d("e","5");
                        caseNavigate(aiResult);
                        break;
                    case("maps.current_location"):
                        Log.d("e","6");
                        caseLocation(aiResult);
                        break;
                    case ("Default Fallback Intent"):
                        Log.d("e","7");
                        caseDefault(aiResult);
                        break;
                 default:
                     Log.d("e","8");
                     results.add(0, aiResult.getResult().getFulfillment().getMessages().get(0).getSpeech());
                     adapter.notifyDataSetChanged();
                }
            }
        },throwable -> {
            Log.d("Error","Error");
            Log.e("Error",throwable.toString());
        });
    }

    public void caseEvent(AIResult aiResult){
        String dep = aiResult.getResult().getParameters().getDepartment_branch();
        String typeOfEvents = aiResult.getResult().getParameters().getTypeOfEvents();
        String date_time = aiResult.getResult().getParameters().getDate_time();
        String date = aiResult.getResult().getParameters().getDate();
        String Fees = aiResult.getResult().getParameters().getFees();
        String Discipline = aiResult.getResult().getParameters().getDiscipline();
        String Procedure = aiResult.getResult().getParameters().getProcedure();
        String Event_name = aiResult.getResult().getParameters().getEventsName();
        String prize = aiResult.getResult().getParameters().getPrizeMoney();
        searchEvents(dep+" "+typeOfEvents+" "+date_time+" "+date+" "+Fees+" "+Discipline+" "+Event_name+" "+prize);
    }

    public void casePlacement(AIResult aiResult){
        String department_branch = aiResult.getResult().getParameters().getDepartment_branch();
        String visitedPastComp = aiResult.getResult().getParameters().getVisitedPastComp();
        String date_period = aiResult.getResult().getParameters().getDate_period();
        String numbers = aiResult.getResult().getParameters().getNumbers();
        String date = aiResult.getResult().getParameters().getDate();
        String packagesOffered1 = aiResult.getResult().getParameters().getPackagesOffered1();
        String packagesOffered = aiResult.getResult().getParameters().getPackagesOffered();
        String procedure  = aiResult.getResult().getParameters().getProcedure();
        String policy = aiResult.getResult().getParameters().getPolicy();
        String companiesPlacement = aiResult.getResult().getParameters().getCompaniesPlacement();
        String upcoming1 = aiResult.getResult().getParameters().getUpcoming1();
        String upcoming = aiResult.getResult().getParameters().getUpcoming();
        searchPlacementDetail(department_branch+" "+visitedPastComp+" "+date_period+" "+numbers+" "+date+" "+packagesOffered1+" "+packagesOffered+
                " "+procedure+" "+policy+" "+companiesPlacement+" "+upcoming+" "+upcoming1);

    }

    public void caseAdmission(AIResult aiResult){
        String department_branch = aiResult.getResult().getParameters().getDepartment_branch();
        String scholarship = aiResult.getResult().getParameters().getScholarship();
        String LpuNest = aiResult.getResult().getParameters().getLpuNest();
        String Eligibility = aiResult.getResult().getParameters().getEligibility();
        String Benefits = aiResult.getResult().getParameters().getBenefits();
        String Fees = aiResult.getResult().getParameters().getFees();
        String discipline = aiResult.getResult().getParameters().getDiscipline();
        String procedure  = aiResult.getResult().getParameters().getProcedure();
        String policy = aiResult.getResult().getParameters().getPolicy();
        String Subjects= aiResult.getResult().getParameters().getSubjects();
        String currentQualification = aiResult.getResult().getParameters().getCurrentQualification();

    }

    public void caseAdministrator(AIResult aiResult){
        String department_branch = aiResult.getResult().getParameters().getDepartment_branch();
        String designation = aiResult.getResult().getParameters().getDesignation();
        searchCollegeInformation(department_branch+" "+designation);
    }

    public void caseNavigate(AIResult aiResult){
        String blockBuilding = aiResult.getResult().getParameters().getBlockBuilding();
        String department_branch = aiResult.getResult().getParameters().getDepartment_branch();

        tabhost.getTabAt(1).select();
    }

    public void caseLocation(AIResult aiResult){

    }

    public void caseDefault(AIResult aiResult){

    }

    //Functions Related to server 2

    public void searchEvents(String query){
        nQuery nquery = new nQuery();
        nquery.setQuery(query);
        Observable<List<EventsSchema>> events = minternetServices.searchEvents(nquery);
        Subscription subscription = events.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(result->{
            String message  = null;
            if(result.size() == 0 || result == null){
                message = "Sorry, There is no data on your query.";
            }
            else{
                message = result.get(0).getEvent_information();
            }

            if(adapter == null){
                results = new ArrayList<String>();
                results.add(0,message);
                adapter = new ResultAdapter(results);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }else{
                results.add(0,message);
                adapter.notifyDataSetChanged();
            }
            t1.speak(message, TextToSpeech.QUEUE_FLUSH, null);

        },throwable -> {
            Log.d("Error","Error");
            Log.e("Error",throwable.toString());
        });
    }



    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }

    public void searchProcess(String query){
        Observable<ProcessSchema> process = minternetServices.searchProcess(query);
        Subscription subscription = process.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(result ->{

            if(adapter == null){

            }else{

            }

        },throwable -> {

        });
    }

    public void searchCollegeInformation(String query) {
        Observable<CollegeInformationSchema> information = minternetServices.searchCollegeInformation(query);
        Subscription subscription =information.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(result->{

            if(adapter == null){

            }else{

            }

        },throwable ->{

        });
    }

    public void searchCollegeBuilding(String query) {
        Observable<CollegeBuildingSchema> buildings = minternetServices.searchCollegeBuildings(query);
        Subscription subscription = buildings.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(result->{

            if(adapter == null){

            }else{

            }

        },throwable -> {

        });
    }

    public void searchPlacementDetail(String query) {
        Observable<String> placement = minternetServices.searchPlacementDetail(query);
        Subscription subscription = placement.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(result->{

            if(adapter == null){

            }else{

            }

        },throwable -> {

        });
    }

}
class nQuery{
 private String query;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
