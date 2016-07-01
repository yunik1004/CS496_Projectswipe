package inkyu.project_swipe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class HelloGridPhotoActivity extends FragmentActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallerymain);

        final GridView gridview = (GridView)findViewById(R.id.myGridView);

        ImageAdapter imgAdapter = new ImageAdapter(this);
        gridview.setAdapter(imgAdapter);

        gridview.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent it = new Intent(HelloGridPhotoActivity.this, HelloGridPhoto2.class);
                it.putExtra("filename", position+"");
                startActivity(it);
            }
        });
    }
}