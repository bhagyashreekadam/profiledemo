package layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.synerzip.profiledemo1.R;

public class TopFragment1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private int mParam2;
   public static TextView text1;
    View rootView;
    Button prev;




    public TopFragment1() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TopFragment1 newInstance(String param1) {
        TopFragment1 fragment = new TopFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView= inflater.inflate(R.layout.fragment_top_fragment1, container, false);
        text1=(TextView)rootView.findViewById(R.id.activity1Text);

        text1.setText("MF1");
       rootView.invalidate();

        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2);

                text1.invalidate();
                text1.setText(mParam1);

        }
    }

}
