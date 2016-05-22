# 打造绚丽的ViewPager

标签： Android

---

  对于ViewPager,我们都很熟悉，这个空间Google已为我们封装好，我们只需要简单的使用就可以，但是默认情况下就是一个水平移动的效果，过于单调，今天来学习下如何打造绚丽的ViewPager,实现动画效果。

---

## just do it!
其实Google已经为我们提供了这样一个动画接口，我们只需要实现这个接口，然后编写我们需要的动画就可以了.

```
/**
     * A PageTransformer is invoked whenever a visible/attached page is scrolled.
     * This offers an opportunity for the application to apply a custom transformation
     * to the page views using animation properties.
     *
     * <p>As property animation is only supported as of Android 3.0 and forward,
     * setting a PageTransformer on a ViewPager on earlier platform versions will
     * be ignored.</p>
     */
    public interface PageTransformer {
        /**
         * Apply a property transformation to the given page.
         *
         * @param page Apply the transformation to this page
         * @param position Position of page relative to the current front-and-center
         *                 position of the pager. 0 is front and center. 1 is one full
         *                 page position to the right, and -1 is one page position to the left.
         */
        public void transformPage(View page, float position);
    }
```

这个接口是在ViewPager内部的私有接口，这个是Google官方的源码，对于开发的我们来说，小小的注释肯定是难不倒我们的，我们都懂得哈！

在此附上一篇很详细的讲解transformPage()方法的两个参数的文章，也省的我在绘图了。  [蹦跶的小码哥][1]，这篇文章通俗易懂，so easy！！

然后就是为ViewPager实现这个接口了，真的是很简单，一行代码就搞定，
ViewPager.setPageTransformer()方法就欧拉！！


```
 mViewPager = (ViewPager) findViewById(R.id.vp);
        mViewPager.setPageTransformer(true,mTransformer);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
```

源码在此！！

[一个实现了几个简单动画效果的ViewPager的源码][2]


  [1]: http://blog.csdn.net/hua631150873/article/details/51434286
  [2]: https://github.com/weiggle/ViewPagerStyle
