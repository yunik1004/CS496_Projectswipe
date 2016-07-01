package inkyu.project_swipe;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;


public class HelloGridPhoto2 extends FragmentActivity {
    private int position;
    ImageView imgview;
    PhotoViewAttacher mAttacher;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallerymain2);

       Intent it = getIntent();
        String pos = it.getExtras().get("filename").toString();
        position = Integer.parseInt(pos);

        imgview = (ImageView)findViewById(R.id.myImageView);
        imgview.setImageResource(mThumbIds[position]);
        mAttacher = new PhotoViewAttacher(imgview);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }

    public void onClick_PREV(View v){
        if(position > 0){
            position -= 1;
        }
        imgview.setImageResource(mThumbIds[position]);
        mAttacher = new PhotoViewAttacher(imgview);
    }

    public void onClick_NEXT(View v){
        if(position < mThumbIds.length - 1){
            position += 1;
        }
        imgview.setImageResource(mThumbIds[position]);
        mAttacher = new PhotoViewAttacher(imgview);
    }

    int[] mThumbIds = {
            R.drawable.photo01,
            R.drawable.photo02,
            R.drawable.photo03,
            R.drawable.photo04,
            R.drawable.photo05,
            R.drawable.photo06,
            R.drawable.photo07,
            R.drawable.photo08,
            R.drawable.photo09,
            R.drawable.photo10,
            R.drawable.photo11,
            R.drawable.photo12,
            R.drawable.photo13,
            R.drawable.photo14,
            R.drawable.photo15,
            R.drawable.photo16,
            R.drawable.photo17,
            R.drawable.photo18,
            R.drawable.photo19,
            R.drawable.photo20,
    };
}