package cr.indianrailways.gov.in.mmis_ver2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.R.attr.text;
import static cr.indianrailways.gov.in.mmis_ver2.R.id.aboutUs;



public class AboutUsFragment extends Fragment
{
    static boolean net;


    public AboutUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_about_us,
                container, false);
        TextView textView= (TextView) view.findViewById(aboutUs);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(R.id.text);
        // return view;
        return inflater.inflate(R.layout.fragment_about_us, container, false);
    }

}
