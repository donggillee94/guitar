package cse.ssu.guitar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class SheetFragment extends Fragment {
    View view;
    TextView name_view, date_view;
    String name, date;
    RelativeLayout rl;
    public static SheetFragment newInstance() {
        return new SheetFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sheet, container, false);
        name_view = (TextView)view.findViewById(R.id.name);
        date_view = (TextView)view.findViewById(R.id.date);

        name = getArguments().getString("name");
        date = getArguments().getString("date");
        rl= (RelativeLayout)view.findViewById(R.id.noteLayout);
        ImageView iv = new ImageView(getActivity());
        iv.setImageResource(R.drawable.quarter_note);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(70,70);

        lp.alignWithParent=true;
        lp.leftMargin=100;
        lp.topMargin=50;

        iv.setLayoutParams(lp);

        rl.addView(iv);
        name_view.setText(name);
        date_view.setText(date);


        return view;
    }
}
