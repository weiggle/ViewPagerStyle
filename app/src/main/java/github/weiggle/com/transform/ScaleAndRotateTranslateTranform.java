package github.weiggle.com.transform;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Administrator on 2016/5/19.
 */
public class ScaleAndRotateTranslateTranform implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {
        if(position < 0){
            page.setAlpha(position+1);
            page.setPivotX(page.getWidth()/2);
            page.setPivotY(page.getHeight()/2);
            page.setRotationY(-position*45f);
            page.setScaleY(position+1);
            page.setScaleX(position+1);
        }else if(position < 1){
            page.setAlpha(1-position);
            page.setPivotX(page.getWidth()/2);
            page.setPivotY(page.getHeight()/2);
            page.setRotationY(-position*45f);
            page.setScaleY(1-position);
            page.setScaleX(1-position);
        }else{
            page.setAlpha(0.0f);
        }
    }
}
