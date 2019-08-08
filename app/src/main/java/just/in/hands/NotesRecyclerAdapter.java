package just.in.hands;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NotesRecyclerAdapter extends RecyclerView.Adapter<NotesRecyclerAdapter.ViewHolder> {

    ArrayList<String> course_id = new ArrayList<>();
    ArrayList<String> course_name = new ArrayList<>();
    Context context;

    public NotesRecyclerAdapter(Context applicationContext, ArrayList<String> course_id, ArrayList<String> course_name)
    {

        this.context = applicationContext;
        this.course_id = course_id;
        this.course_name=course_name;

    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView course_text;
        public CardView course_card;
        public ViewHolder(View itemView)
        {
            super(itemView);
            course_text = itemView.findViewById(R.id.course_names);
            course_card = itemView.findViewById(R.id.note_cards);
        }
    }

    @Override
    public NotesRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_list, parent, false);
        NotesRecyclerAdapter.ViewHolder viewHolder = new NotesRecyclerAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position)
    {
        holder.course_text.setText(course_name.get(position));
        holder.course_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,course_name.get(position),Toast.LENGTH_SHORT).show();
                Intent note =new Intent(context, NotesViewerActivity.class);
                note.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(note);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return course_id.size();
    }
}