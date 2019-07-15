package just.in.hands;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Updates_Activity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<String> id = new ArrayList<>();
    ArrayList<String> title = new ArrayList<>();
    ArrayList<String> description = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        HideSyS_UI.hideui(getWindow().getDecorView());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updates);
        id.clear();
        title.clear();
        description.clear();

        id.add("1");
        title.add("CodeCry");
        description.add("CodeCry is a Code Repository comprised of codes from C, C++, Java, Python, Javascript and many others.");

        id.add("2");
        title.add("TechRead");
        description.add("Read, Enjoy And Discover technology news & information");

        id.add("3");
        title.add("Techlines");
        description.add("Techlines brings you Tech News in one line. Its grabs news from various news websites around the world.");

        id.add("4");
        title.add("Hackers Dictionary");
        description.add("Dictionary for Hackers. Anyone can contribute. It’s for Hackers, by Hackers!");

        id.add("5");
        title.add("CyberChoco");
        description.add("Cyberchoco is an upcoming release, Which is an Online Virtual Lab for Security Professionals.");

        id.add("6");
        title.add("Tutorials Now");
        description.add("An Aroliant Training Initiative, android development, web design video tutorials in Tamil & English");

        id.add("7");
        title.add("Tutorials Now");
        description.add("An Aroliant Training Initiative, android development, web design video tutorials in Tamil & English");

        id.add("8");
        title.add("Tutorials Now");
        description.add("An Aroliant Training Initiative, android development, web design video tutorials in Tamil & English");

        id.add("9");
        title.add("Tutorials Now");
        description.add("An Aroliant Training Initiative, android development, web design video tutorials in Tamil & English");

        id.add("10");
        title.add("Tutorials Now");
        description.add("An Aroliant Training Initiative, android development, web design video tutorials in Tamil & English");

        id.add("11");
        title.add("Tutorials Now");
        description.add("An Aroliant Training Initiative, android development, web design video tutorials in Tamil & English");

        id.add("12");
        title.add("Tutorials Now");
        description.add("An Aroliant Training Initiative, android development, web design video tutorials in Tamil & English");

        id.add("13");
        title.add("Tutorials Now");
        description.add("An Aroliant Training Initiative, android development, web design video tutorials in Tamil & English");

        id.add("14");
        title.add("Tutorials Now");
        description.add("An Aroliant Training Initiative, android development, web design video tutorials in Tamil & English");

        recyclerView = findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerAdapter(getApplicationContext(), id, title, description);
        recyclerView.setAdapter(mAdapter);
    }
}