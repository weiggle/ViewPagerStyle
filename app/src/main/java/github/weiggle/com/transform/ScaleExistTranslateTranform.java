package github.weiggle.com.transform;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import github.weiggle.com.viewpagerstyle.R;

/**
 * Created by Administrator on 2016/5/19.
 */
public class ScaleExistTranslateTranform implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {
        ImageView imageView = (ImageView) page.findViewById(R.id.img);

        Log.e("TranslatePageTranform","pageId==>"+page.toString()+"  postion==>"+position);
        if(position < -1){
            imageView.setAlpha(0.0f);
        }else if(position <1){
            imageView.setAlpha(1.0f);
            page.setScaleX(1-Math.abs(position));
            page.setScaleY(1-Math.abs(position));
        }else{
            imageView.setAlpha(0.0f);
        }
    }
}
