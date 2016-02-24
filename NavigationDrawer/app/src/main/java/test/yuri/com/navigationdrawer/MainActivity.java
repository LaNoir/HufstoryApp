package test.yuri.com.navigationdrawer;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private View mView;
    private ActionBarDrawerToggle mDrawerToggle;

    private ExpandableListAdapter mExpListAdapter;
    private ExpandableListView mExpListView;
    private List<String> mExpListGroup;
    private HashMap<String, List<String>> mExpListChild;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mView=(View) findViewById(R.id.left_drawer);

        mDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close){
            public void onDrawerClosed(View view){
                super.onDrawerClosed(view);
                //getActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView){
                super.onDrawerOpened(drawerView);
               // getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        mExpListView = (ExpandableListView) findViewById(R.id.expandListview);
        prepareData();
        mExpListAdapter = new ExpandableListAdapter(this,mExpListGroup,mExpListChild);
        mExpListView.setAdapter(mExpListAdapter);
    }

    private void prepareData(){
        mExpListGroup = new ArrayList<String>();
        mExpListChild = new HashMap<String, List<String>>();

        // Adding child data
        mExpListGroup.add("게시판");
        mExpListGroup.add("기자단");
        mExpListGroup.add("생활정보");
        mExpListGroup.add("학교생활");
        mExpListGroup.add("제휴운영");
        mExpListGroup.add("Hot Link");

        // Adding child data
        List<String> board = new ArrayList<String>();
        board.add("공지사항");
        board.add("자유게시판");
        board.add("외대 갤러리");
        board.add("동아리 게시판");
        board.add("분실물 게시판");
        board.add("공모전 밒 대외활동");

        List<String> reporter = new ArrayList<String>();
        reporter.add("동아리 정보");
        reporter.add("맛집기행기");


        List<String> life_info = new ArrayList<String>();
        life_info.add("중고시장");
        life_info.add("주거정보");
        life_info.add("자유홍보");

        List<String> school = new ArrayList<String>();
        school.add("총학 게시판");
        school.add("Hufs Dorm (기숙사)");
        school.add("경력개발센터");
        school.add("취업 정보 게시판");

        List<String> alliance = new ArrayList<String>();
        alliance.add("훕스토리 제휴 운영");
        alliance.add("밝은성모안과");

        List<String> hotLink = new ArrayList<String>();
        hotLink.add("Hufs");
        hotLink.add("E-Class");
        hotLink.add("종합정보시스템");
        hotLink.add("수강신청 장바구니");
        hotLink.add("성적열람");
        hotLink.add("외대 도서관");
        hotLink.add("Office 365(hufs)");


        mExpListChild.put(mExpListGroup.get(0), board); // Header, Child data
        mExpListChild.put( mExpListGroup.get(1), reporter);
        mExpListChild.put( mExpListGroup.get(2), life_info);
        mExpListChild.put( mExpListGroup.get(3), school);
        mExpListChild.put( mExpListGroup.get(4), alliance);
        mExpListChild.put( mExpListGroup.get(5), hotLink);

    }
}
