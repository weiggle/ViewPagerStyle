package github.weiggle.com.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import github.weiggle.com.viewpagerstyle.R;

/**
 * Created by Administrator on 2016/5/19.
 */
public class ItemFragment extends Fragment {

    private View mView;
    private ImageView mImageView;
    private TextView mTextView;
    private int position;
    private int[] imageId = {R.drawable.img1,R.drawable.img2,R.drawable.img3,
            R.drawable.img4,R.drawable.img5,R.drawable.img6};

    public static ItemFragment newInstance(int position){
        ItemFragment fragment = new ItemFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position",position);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("position");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.item_fragment,null);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mImageView = (ImageView) mView.findViewById(R.id.img);
        mTextView = (TextView) mView.findViewById(R.id.position);

        mImageView.setImageResource(imageId[position]);
        mTextView.setText("this position =" +position );

    }
}
