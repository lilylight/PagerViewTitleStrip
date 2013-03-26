/*
 * Copyright (C) 2013 Takuya Naraoka
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.lilylight.pagerviewtitlestrip;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewTitlePagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import jp.lilylight.pagerviewtitlestrip.R;

public class MainActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ViewPager vp = (ViewPager) findViewById(R.id.view_pager);
        vp.setAdapter(new TextPagerAdapter(this));
    }

    private static class TextPagerAdapter extends ViewTitlePagerAdapter {

        int[] mImages = {
                R.drawable.emo_im_angel,
                R.drawable.emo_im_cool,
                R.drawable.emo_im_crying,
                R.drawable.emo_im_embarrassed,
                R.drawable.emo_im_foot_in_mouth,
                R.drawable.emo_im_happy,
                R.drawable.emo_im_kissing,
                R.drawable.emo_im_laughing,
                R.drawable.emo_im_lips_are_sealed,
                R.drawable.emo_im_money_mouth,
                R.drawable.emo_im_sad,
                R.drawable.emo_im_surprised,
                R.drawable.emo_im_tongue_sticking_out,
                R.drawable.emo_im_undecided,
                R.drawable.emo_im_winking,
                R.drawable.emo_im_wtf,
                R.drawable.emo_im_yelling,
        };

        Context mContext;

        public TextPagerAdapter(Context context) {
            mContext = context;
        }

        @Override
        public int getCount() {
            return mImages.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView tv = (TextView) View.inflate(mContext, R.layout.view_item, null);
            tv.setText(Integer.toString(position));
            ((ViewPager) container).addView(tv);
            return tv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((View) object);
        }

        @Override
        public View getPageTitleView(int position) {
            TextView tv = (TextView) View.inflate(mContext, R.layout.view_title, null);
            tv.setText("Page:" + position);
            tv.setCompoundDrawablesWithIntrinsicBounds(
                    null, mContext.getResources().getDrawable(mImages[position]), null, null);
            return tv;
        }
    }
}
