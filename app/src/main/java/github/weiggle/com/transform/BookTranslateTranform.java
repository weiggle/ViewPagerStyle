package github.weiggle.com.transform;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Administrator on 2016/5/22.
 */
public class BookTranslateTranform implements ViewPager.PageTransformer{

    @Override
    public void transformPage(View page, float position) {
        if(position < 0){
            page.setAlpha(1+position);
            page.setPivotX(page.getWidth()/2);
            page.setPivotY(page.getHeight()/2);
            page.setRotationY(position*90f);

        }else if(position < 1){
            page.setAlpha(1-position);
            page.setPivotX(page.getWidth()/2);
            page.setPivotY(page.getHeight()/2);
            page.setRotationY(position*90f);
        }else{
            page.setAlpha(0.0f);
        }
    }
}
