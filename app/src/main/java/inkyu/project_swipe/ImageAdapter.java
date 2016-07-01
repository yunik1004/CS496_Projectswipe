package inkyu.project_swipe;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private Integer[] mThumbIds = {
            R.mipmap.photo01,
            R.mipmap.photo02,
            R.mipmap.photo03,
            R.mipmap.photo04,
            R.mipmap.photo05,
            R.mipmap.photo06,
            R.mipmap.photo07,
            R.mipmap.photo08,
            R.mipmap.photo09,
            R.mipmap.photo10,
            R.mipmap.photo11,
            R.mipmap.photo12,
            R.mipmap.photo13,
            R.mipmap.photo14,
            R.mipmap.photo15,
            R.mipmap.photo16,
            R.mipmap.photo17,
            R.mipmap.photo18,
            R.mipmap.photo19,
            R.mipmap.photo20,
    };

    public ImageAdapter(Context c){
        mContext = c;
    }

    public int getCount(){
        return mThumbIds.length;
    }

    public long getItemId(int position){
        return position;
    }

    public Object getItem(int position){
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {  // adapter가 가지고 있는 data를 어떻게 보여줄 것인가
        ImageView imageView;
        if(convertView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(10, 10, 10, 10);
        } else {
            imageView = (ImageView)convertView;
        }
        imageView.setImageResource(mThumbIds[position]);

        return imageView;
    }
}