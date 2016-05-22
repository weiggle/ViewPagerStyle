package github.weiggle.com.viewpagerstyle;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import github.weiggle.com.fragment.ItemFragment;
import github.weiggle.com.transform.BookTranslateTranform;
import github.weiggle.com.transform.RotateTranslateTranform;
import github.weiggle.com.transform.ScaleExistTranslateTranform;
import github.weiggle.com.transform.ScaleAndRotateTranslateTranform;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private static final int VIEW_PAGER_SIZES = 6;
    private ViewPager.PageTransformer mTransformer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        mViewPager = (ViewPager) findViewById(R.id.vp);
        mViewPager.setPageTransformer(true,mTransformer);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mian_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuId = item.getItemId();
        switch (menuId){
            case R.id.default_menu:
                mTransformer = null;
                break;
            case R.id.scale_exists:
                mTransformer = new ScaleExistTranslateTranform();

                break;
            case R.id.rotate_exists:
                mTransformer = new RotateTranslateTranform();
                break;
            case R.id.translateX_exists:
                mTransformer = new ScaleAndRotateTranslateTranform();
                break;
            case R.id.book_exists:
                mTransformer = new BookTranslateTranform();
                break;
            default:
                break;
        }

        mViewPager.setPageTransformer(true,mTransformer);
        return true;
    }

    private static class ViewPagerAdapter extends FragmentStatePagerAdapter{

        public ViewPagerAdapter(FragmentManager manager){
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return ItemFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 6;
        }

    }
}
