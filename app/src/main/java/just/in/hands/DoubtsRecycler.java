package just.in.hands;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DoubtsRecycler extends RecyclerView.Adapter<DoubtsRecycler.ViewHolder> {

    ArrayList<String> q_id = new ArrayList<>();
    ArrayList<String> q_txt = new ArrayList<>();
    ArrayList<String> q_stat = new ArrayList<>();
    ArrayList<String> q_ans = new ArrayList<>();
    Context context;

    public DoubtsRecycler(Context applicationContext, ArrayList<String> q_id, ArrayList<String> q_txt, ArrayList<String> q_stat, ArrayList<String> q_ans)
    {

        this.context = applicationContext;
        this.q_id = q_id;
        this.q_txt=q_txt;
        this.q_stat=q_stat;
        this.q_ans=q_ans;

    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView q_text,q_answer;
        public String q_identity;
        public ImageView q_status;
        public CardView doubt_card;
        public ViewHolder(View itemView)
        {
            super(itemView);
            q_text = itemView.findViewById(R.id.doubt_title);
            q_status = itemView.findViewById(R.id.ans_stat);
        }
    }

    @Override
    public DoubtsRecycler.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doubt_list, parent, false);
        DoubtsRecycler.ViewHolder viewHolder = new DoubtsRecycler.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position)
    {
        holder.q_text.setText(q_txt.get(position));
        if(q_stat.get(position).equals("1"))
        {
            holder.q_status.setImageResource(R.drawable.answer);
        }
    }

    @Override
    public int getItemCount()
    {
        return q_id.size();
    }
}