package inkyu.project_swipe;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

@SuppressLint("ValidFragment")
public class HelloGridPhotoFragment extends Fragment {
    Context mContext;

    public HelloGridPhotoFragment(Context context) {
        mContext = context;
    }

    /** Called when the activity is first created. */
    public void onStart(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_gallerymain, null);
        final GridView gridview = (GridView) view.findViewById(R.id.myGridView);

        ImageAdapter imgAdapter = new ImageAdapter(getActivity());
        gridview.setAdapter(imgAdapter);

        gridview.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent it = new Intent(getActivity(), HelloGridPhoto2.class);
                it.putExtra("filename", position+"");
                startActivity(it);
            }
        });
        return view;
    }
}