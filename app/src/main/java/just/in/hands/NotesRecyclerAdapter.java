package just.in.hands;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        public ViewHolder(View itemView) {
            super(itemView);
            course_text = itemView.findViewById(R.id.course_name);
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
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        holder.course_text.setText(course_name.get(position));
    }

    @Override
    public int getItemCount() {
        return course_id.size();
    }
}