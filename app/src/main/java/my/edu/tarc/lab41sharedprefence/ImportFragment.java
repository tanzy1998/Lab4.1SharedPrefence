package my.edu.tarc.lab41sharedprefence;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImportFragment extends Fragment {

    private TextView textViewMsg;


    public ImportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_import, container, false);
        // Inflate the layout for this fragment
        textViewMsg = view.findViewById(R.id.textViewMessage);
        final Button button = view.findViewById(R.id.buttonShowMessage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewMsg.setText("Hello Import Fragment Button");
            }
        });
        return view;
    }

}
