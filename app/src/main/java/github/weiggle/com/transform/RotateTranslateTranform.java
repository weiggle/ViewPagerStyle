package github.weiggle.com.transform;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import github.weiggle.com.viewpagerstyle.R;

/**
 * Created by Administrator on 2016/5/19.
 * Rotation 90
 */
public class RotateTranslateTranform implements ViewPager.PageTransformer {


    @Override
    public void transformPage(View page, float position) {
        ImageView view = (ImageView) page.findViewById(R.id.img);

        if(position < -1){
            view.setAlpha(0.0f);
        }else if(position <1){
            view.setAlpha(1.0f);
            view.setPivotX(position < 0f ?view.getWidth():0);
            view.setPivotY(view.getHeight()*0.5f);
            view.setRotationY(position*90f);
        }else{
            view.setAlpha(0.0f);
        }
    }
}
