package collegeproject.askme_bot;

/**
 * Created by shubham on 26/3/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ViewHolder> {
    private List<String> AIResults;
    private  final  int TEXT = 0;
    private final int  IMAGE = 1;
    private  final int VIDEO = 2;
    private final int  AUDIO = 3;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private Context viewContext;
        private TextView result;
        public View view;
        public ViewHolder(View v) {
            super(v);
            view = v;
            result = (TextView) view.findViewById(R.id.info_text);
            viewContext = v.getContext();

        }
    }


    public ResultAdapter(List<String> AIResults) {
        this.AIResults = AIResults;
    }


    @Override
    public ResultAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        ResultAdapter.ViewHolder viewHolder;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        switch (viewType){
            case TEXT:
                View v1 = layoutInflater.inflate(R.layout.results_card1, parent, false);
                viewHolder = new ViewHolder(v1);
                break;
            case IMAGE:
                View v2 = layoutInflater.inflate(R.layout.results_card1, parent, false);
                viewHolder = new ViewHolder(v2);
                break;
            case VIDEO:
                View v3 = layoutInflater.inflate(R.layout.results_card1, parent, false);
                viewHolder = new ViewHolder(v3);
                break;
            case AUDIO:
                View v4 = layoutInflater.inflate(R.layout.results_card1, parent, false);
                viewHolder = new ViewHolder(v4);
                break;
            default:
                View v = layoutInflater.inflate(R.layout.results_card1, parent, false);
                viewHolder = new ViewHolder(v);
                break;
        }
        return viewHolder;
    }
    @Override
    public int getItemViewType(int position){
//        String article_content = AIResults.get(position).getResult().getParameters().getTypeOfEvent();
//        if(article_content.equals("texts")){
//            return TEXT;
//        }else if(article_content.equals("image")){
//            return IMAGE;
//        }else if(article_content.equals("videos")){
//            return  VIDEO;
//        }else if(article_content.equals("audios")){
//            return AUDIO;
//        }
//        return  -1;
        return  TEXT;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        switch (holder.getItemViewType()) {
            case TEXT:
                holder.result.setText(AIResults.get(position));
                break;
            case IMAGE:

                break;
            case AUDIO:
                break;
            case VIDEO:
                break;
            default:
                Toast.makeText(holder.viewContext,"Case not satisfied in on bind",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public long getItemId(int position) {
        return  getItemId(position);
    }

    @Override
    public int getItemCount() {
        return  AIResults.size();

    }
}

