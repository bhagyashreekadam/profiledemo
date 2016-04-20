package layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.synerzip.profiledemo1.R;

public class TabFragment2 extends Fragment {
    public static TextView TF2;
    private static final String ARG_PARAM1="bhagu";
    private static final String ARG_PARAM2="bhagukadam";
    private String mParam1;
    private String mParam2;

    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView= inflater.inflate(R.layout.fragment_tab_fragment2, container, false);
        TF2=(TextView)rootView.findViewById(R.id.tabF);
        TF2.setText("frag 2 MF 1");
        rootView.invalidate();
        return rootView;
    }

    public static TabFragment2 newInstance(String param1) {
        TabFragment2 fragment = new TabFragment2();
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
            TF2.setText(mParam1);

        }
    }
}