package layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.synerzip.profiledemo1.R;


public class TabFragment3 extends Fragment {
    public static TextView TF3;
    private static final String ARG_PARAM1="bhagu";
    private static final String ARG_PARAM2="bhagukadam";
    private String mParam1;
    private String mParam2;
    View rootView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      rootView= inflater.inflate(R.layout.fragment_tab_fragment3, container, false);
        TF3=(TextView)rootView.findViewById(R.id.tabF);
        TF3.setText("frag 3 MF 1");
        rootView.invalidate();
        return rootView;

    }

    public static TabFragment3 newInstance(String param1) {
        TabFragment3 fragment = new TabFragment3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);

        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            TF3.invalidate();
           TF3.setText(mParam1);

        }
    }
}
