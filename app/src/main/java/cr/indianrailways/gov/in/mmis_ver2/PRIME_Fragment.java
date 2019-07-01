package cr.indianrailways.gov.in.mmis_ver2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static cr.indianrailways.gov.in.mmis_ver2.R.id.prime;
import static cr.indianrailways.gov.in.mmis_ver2.R.id.text;


/**
 * A simple {@link Fragment} subclass.
 */
public class PRIME_Fragment extends Fragment {


    public PRIME_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_prime_,
                container, false);
        TextView textView= (TextView) view.findViewById(prime);
        textView.setText(text);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_prime_, container, false);
    }

}
