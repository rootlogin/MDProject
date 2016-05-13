package com.gohon.material.mduisdk.weight.bottomBar.sample;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.gohon.material.mduisdk.R;
import com.gohon.material.mduisdk.weight.bottomBar.BottomBar;
import com.gohon.material.mduisdk.weight.bottomBar.BottomBarTab;
import com.gohon.material.mduisdk.weight.bottomBar.OnMenuTabClickListener;
import com.gohon.material.mduisdk.weight.bottomBar.OnTabClickListener;

/**
 * Created by liuyonglong on 16/5/13.
 */
public class BottomNavigationBarSample extends Fragment{
    private TextView mMessageView;
    private BottomBar mBottomBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBottomBar = BottomBar.attach(getActivity(), savedInstanceState);

        /**
         * 配合CoordinatorLayout,滑动隐藏
         */
//        mBottomBar = BottomBar.attachShy((CoordinatorLayout) findViewById(R.id.coordinatorLayout),
//                findViewById(R.id.nestedScorellView), savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sample_bottombar,container,false);
        mMessageView = (TextView) rootView.findViewById(R.id.messageView);
        useMenuControl();
        return rootView;

    }

    /**
     * 使用Menu配置,当Menu个数大于3的时候mapColorForTab生效
     */
    private void useMenuControl(){

        mBottomBar.setItemsFromMenu(R.menu.menu_bottombar, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                mMessageView.setText(getMessage(menuItemId, false));
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
//                Toast.makeText(getApplicationContext(), getMessage(menuItemId, true), Toast.LENGTH_SHORT).show();
            }
        });

        // Setting colors for different tabs when there's more than three of them.
        // You can set colors for tabs in three different ways as shown below.
        mBottomBar.mapColorForTab(0, "#2196F3");
        mBottomBar.mapColorForTab(1, 0xFF5D4037);
        mBottomBar.mapColorForTab(2, "#7B1FA2");
        mBottomBar.mapColorForTab(3, "#FF5252");
        mBottomBar.mapColorForTab(4, "#FF9800");
    }

    private void useJAVAControl(){
        String message = "Content for ";
        mBottomBar.setItems(
                new BottomBarTab(R.drawable.sample_ic_recents, "Recents"),
                new BottomBarTab(R.drawable.sample_ic_favorites, "Favorites"),
                new BottomBarTab(R.drawable.sample_ic_nearby, "Nearby")
        );
        mBottomBar.setOnTabClickListener(new OnTabClickListener() {
            @Override
            public void onTabSelected(int position) {
                switch (position){
                    case 0:
                        mMessageView.setText("Recents");
                        break;
                    case 1:
                        mMessageView.setText("Favorites");
                        break;
                    case 2:
                        mMessageView.setText("Nearby");
                        break;
                }
            }

            @Override
            public void onTabReSelected(int position) {

            }
        });
    }


    private String getMessage(int menuItemId, boolean isReselection) {
        String message = "Content for ";

        if (menuItemId == R.id.bb_menu_recents) {
            message += "recents";

        } else if (menuItemId == R.id.bb_menu_favorites) {
            message += "favorites";

        } else if (menuItemId == R.id.bb_menu_nearby) {
            message += "nearby";

        } else if (menuItemId == R.id.bb_menu_friends) {
            message += "friends";

        } else if (menuItemId == R.id.bb_menu_food) {
            message += "food";

        }

        if (isReselection) {
            message += " WAS RESELECTED! YAY!";
        }

        return message;
    }

}
