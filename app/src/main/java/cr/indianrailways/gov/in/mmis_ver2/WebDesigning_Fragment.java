package cr.indianrailways.gov.in.mmis_ver2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static cr.indianrailways.gov.in.mmis_ver2.R.id.fuel;
import static cr.indianrailways.gov.in.mmis_ver2.R.id.text;
import static cr.indianrailways.gov.in.mmis_ver2.R.id.text1;
import static cr.indianrailways.gov.in.mmis_ver2.R.id.web;


public class WebDesigning_Fragment extends Fragment {


    public WebDesigning_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_web_designing_,
                container, false);
        TextView textView= (TextView) view.findViewById(web);
        textView.setText(text);
        // return view;
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_web_designing_, container, false);
    }

}
