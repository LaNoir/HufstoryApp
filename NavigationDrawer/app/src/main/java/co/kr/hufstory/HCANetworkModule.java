package co.kr.hufstory;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import co.kr.hufstory.menu_communication.MenuInfo;
import co.kr.hufstory.menu_communication.Menus;
import co.kr.hufstory.menu_communication.MenusAPI;
import co.kr.hufstory.menu_communication.MenusNetwork;
import co.kr.hufstory.menu_communication.User;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Hyeong Wook on 2016-02-18.
 */
public class HCANetworkModule{


    /* 2016.02.26, Aev Oh, 테스트 용으로 수정함. */
    //private List<MenuInfo> mDataList;
    private List<User> mDataList;

    public HCANetworkModule(){
        mDataList = new ArrayList<>();
        mDataList = MenusNetwork.getMenu();
    }

    /*private List<MenuInfo> getDataSet(String cafeteria, int day){
        List<MenuInfo> dataSet = new ArrayList<>();

        for(MenuInfo menuInfo : mDataList){
            if(menuInfo.getCaf() == cafeteria && menuInfo.getDay() == day)
                dataSet.add(menuInfo);
        }

        return dataSet;
    }*/

    public void getData(MenuFragment.PlaceholderFragment fragment, int selectedCafeteria, int sectionNumber){ // 테스트용 임시 코드
        /*switch (selectedCafeteria){
            case 0:
                for(MenuInfo menuInfo : getDataSet("foo", sectionNumber))
                    fragment.addCard(menuInfo.getTitle(), menuInfo.getTime(), menuInfo.getBody());
                break;
            case 1:
                for(MenuInfo menuInfo : getDataSet("uh", sectionNumber))
                    fragment.addCard(menuInfo.getTitle(), menuInfo.getTime(), menuInfo.getBody());
                break;
            case 2:
                for(MenuInfo menuInfo : getDataSet("dorm", sectionNumber))
                    fragment.addCard(menuInfo.getTitle(), menuInfo.getTime(), menuInfo.getBody());
        }*/

        switch (selectedCafeteria) {
            case 0:
                switch (sectionNumber) {
                    case 0:
                        System.out.println("case = 0");
                        if(mDataList != null && !mDataList.isEmpty()){
                            System.out.println("mDataList is not Empty");
                            for(User user: mDataList){
                                System.out.println("Retrogit" + user.getUserId() + user.getEmail());
                                fragment.addCard("Retrogit", user.getUserId(), user.getEmail());
                            }
                        }

                    /*
                    fragment.addCard("한식", "오전 10:00 ~ 오후 18:00", "콩밥\n콩나물김치찌개\n콩나물무침\n콩자반");
                    fragment.addCard("한식", "오전 10:00 ~ 오후 18:00", "콩밥\n콩나물김치찌개\n콩나물무침\n콩자반");
                    fragment.addCard("한식", "오전 10:00 ~ 오후 18:00", "콩밥\n콩나물김치찌개\n콩나물무침\n콩자반");
                    fragment.addCard("한식", "오전 10:00 ~ 오후 18:00", "콩밥\n콩나물김치찌개\n콩나물무침\n콩자반");
                    fragment.addCard("한식", "오전 10:00 ~ 오후 18:00", "콩밥\n콩나물김치찌개\n콩나물무침\n콩자반");
                    */

                        break;
                    case 1:
                        fragment.addCard("양식", "오전 08:00 ~ 오후 18:30", "미트소스스파게티\n파인애플\n함-바그스테이크\n콩자반");
                        fragment.addCard("양식", "오전 08:00 ~ 오후 18:30", "미트소스스파게티\n파인애플\n함-바그스테이크\n콩자반");
                        fragment.addCard("양식", "오전 08:00 ~ 오후 18:30", "미트소스스파게티\n파인애플\n함-바그스테이크\n콩자반");
                        fragment.addCard("양식", "오전 08:00 ~ 오후 18:30", "미트소스스파게티\n파인애플\n함-바그스테이크\n콩자반");
                        fragment.addCard("양식", "오전 08:00 ~ 오후 18:30", "미트소스스파게티\n파인애플\n함-바그스테이크\n콩자반");
                        break;
                    case 2:
                        fragment.addCard("특식", "오전 10:00 ~ 오후 15:00", "치즈돈까스\n고구마돈까스\n치즈고구마돈까스\n빅돈까스");
                        fragment.addCard("특식", "오전 10:00 ~ 오후 15:00", "치즈돈까스\n고구마돈까스\n치즈고구마돈까스\n빅돈까스");
                        fragment.addCard("특식", "오전 10:00 ~ 오후 15:00", "치즈돈까스\n고구마돈까스\n치즈고구마돈까스\n빅돈까스");
                        fragment.addCard("특식", "오전 10:00 ~ 오후 15:00", "치즈돈까스\n고구마돈까스\n치즈고구마돈까스\n빅돈까스");
                        fragment.addCard("특식", "오전 10:00 ~ 오후 15:00", "치즈돈까스\n고구마돈까스\n치즈고구마돈까스\n빅돈까스");
                        break;
                    case 3:
                        fragment.addCard("라면", "오전 11:00 ~ 오후 16:00", "신라면\n진라면\n떡라면\n치즈라면\n치즈떡라면");
                        fragment.addCard("라면", "오전 11:00 ~ 오후 16:00", "신라면\n진라면\n떡라면\n치즈라면\n치즈떡라면");
                        fragment.addCard("라면", "오전 11:00 ~ 오후 16:00", "신라면\n진라면\n떡라면\n치즈라면\n치즈떡라면");
                        fragment.addCard("라면", "오전 11:00 ~ 오후 16:00", "신라면\n진라면\n떡라면\n치즈라면\n치즈떡라면");
                        fragment.addCard("라면", "오전 11:00 ~ 오후 16:00", "신라면\n진라면\n떡라면\n치즈라면\n치즈떡라면");
                        break;
                    case 4:
                        fragment.addCard("일식", "오전 11:00 ~ 오후 12:00", "연어초밥\n우동\n새우튀김\n감자튀김");
                        fragment.addCard("일식", "오전 11:00 ~ 오후 12:00", "연어초밥\n우동\n새우튀김\n감자튀김");
                        fragment.addCard("일식", "오전 11:00 ~ 오후 12:00", "연어초밥\n우동\n새우튀김\n감자튀김");
                        fragment.addCard("일식", "오전 11:00 ~ 오후 12:00", "연어초밥\n우동\n새우튀김\n감자튀김");
                        fragment.addCard("일식", "오전 11:00 ~ 오후 12:00", "연어초밥\n우동\n새우튀김\n감자튀김");
                        fragment.addCard("일식", "오전 11:00 ~ 오후 12:00", "연어초밥\n우동\n새우튀김\n감자튀김");
                        break;
                }
                break;

            case 1:
                switch (sectionNumber) {
                    case 0:
                        fragment.addCard("정식2", "오전 10:00 ~ 오후 18:00", "콩밥\n콩나물김치찌개\n콩나물무침\n콩자반");
                        fragment.addCard("정식2", "오전 10:00 ~ 오후 18:00", "콩밥\n콩나물김치찌개\n콩나물무침\n콩자반");
                        fragment.addCard("정식2", "오전 10:00 ~ 오후 18:00", "콩밥\n콩나물김치찌개\n콩나물무침\n콩자반");
                        fragment.addCard("정식2", "오전 10:00 ~ 오후 18:00", "콩밥\n콩나물김치찌개\n콩나물무침\n콩자반");
                        fragment.addCard("정식2", "오전 10:00 ~ 오후 18:00", "콩밥\n콩나물김치찌개\n콩나물무침\n콩자반");
                        break;
                    case 1:
                        fragment.addCard("중식2", "오전 08:00 ~ 오후 18:30", "짜장면\n파인애플\n함-바그스테이크\n콩자반");
                        fragment.addCard("중식2", "오전 08:00 ~ 오후 18:30", "짜장면\n파인애플\n함-바그스테이크\n콩자반");
                        fragment.addCard("중식2", "오전 08:00 ~ 오후 18:30", "짜장면\n파인애플\n함-바그스테이크\n콩자반");
                        fragment.addCard("중식2", "오전 08:00 ~ 오후 18:30", "짜장면\n파인애플\n함-바그스테이크\n콩자반");
                        fragment.addCard("중식2", "오전 08:0 ~ 오후 18:30", "짜장면\n파인애플\n함-바그스테이크\n콩자반");
                        break;
                    case 2:
                        fragment.addCard("별식2", "오전 10:00 ~ 오후 15:00", "냠냠\n고구마돈까스\n치즈고구마돈까스\n빅돈까스");
                        fragment.addCard("별식2", "오전 10:00 ~ 오후 15:00", "냠냠\n고구마돈까스\n치즈고구마돈까스\n빅돈까스");
                        fragment.addCard("별식2", "오전 10:00 ~ 오후 15:00", "냠냠\n고구마돈까스\n치즈고구마돈까스\n빅돈까스");
                        fragment.addCard("별식2", "오전 10:00 ~ 오후 15:00", "냠냠\n고구마돈까스\n치즈고구마돈까스\n빅돈까스");
                        fragment.addCard("별식2", "오전 10:00 ~ 오후 15:00", "냠냠\n고구마돈까스\n치즈고구마돈까스\n빅돈까스");
                        break;
                    case 3:
                        fragment.addCard("우동2", "오전 11:00 ~ 오후 16:00", "신라면\n진라면\n떡라면\n치즈라면\n치즈떡라면");
                        fragment.addCard("우동2", "오전 11:00 ~ 오후 16:00", "신라면\n진라면\n떡라면\n치즈라면\n치즈떡라면");
                        fragment.addCard("우동2", "오전 11:00 ~ 오후 16:00", "신라면\n진라면\n떡라면\n치즈라면\n치즈떡라면");
                        fragment.addCard("우동2", "오전 11:00 ~ 오후 16:00", "신라면\n진라면\n떡라면\n치즈라면\n치즈떡라면");
                        fragment.addCard("우동2", "오전 11:00 ~ 오후 16:00", "신라면\n진라면\n떡라면\n치즈라면\n치즈떡라면");
                        break;
                    case 4:
                        fragment.addCard("믬믬2", "오전 11:00 ~ 오후 12:00", "연어초밥\n우동\n새우튀김\n감자튀김");
                        fragment.addCard("믬믬2", "오전 11:00 ~ 오후 12:00", "연어초밥\n우동\n새우튀김\n감자튀김");
                        fragment.addCard("믬믬2", "오전 11:00 ~ 오후 12:00", "연어초밥\n우동\n새우튀김\n감자튀김");
                        fragment.addCard("믬믬2", "오전 11:00 ~ 오후 12:00", "연어초밥\n우동\n새우튀김\n감자튀김");
                        fragment.addCard("믬믬2", "오전 11:00 ~ 오후 12:00", "연어초밥\n우동\n새우튀김\n감자튀김");
                        fragment.addCard("믬믬2", "오전 11:00 ~ 오후 12:00", "연어초밥\n우동\n새우튀김\n감자튀김");
                        break;
                }
                break;

            case 2:
                switch (sectionNumber) {
                    case 0:
                        fragment.addCard("뇽뇽3", "오전 10:00 ~ 오후 18:00", "콩밥\n콩나물김치찌개\n콩나물무침\n콩자반");
                        fragment.addCard("뇽뇽3", "오전 10:00 ~ 오후 18:00", "콩밥\n콩나물김치찌개\n콩나물무침\n콩자반");
                        fragment.addCard("뇽뇽3", "오전 10:00 ~ 오후 18:00", "콩밥\n콩나물김치찌개\n콩나물무침\n콩자반");
                        fragment.addCard("뇽뇽3", "오전 10:00 ~ 오후 18:00", "콩밥\n콩나물김치찌개\n콩나물무침\n콩자반");
                        fragment.addCard("뇽뇽3", "오전 10:00 ~ 오후 18:00", "콩밥\n콩나물김치찌개\n콩나물무침\n콩자반");
                        break;
                    case 1:
                        fragment.addCard("카페테리아3", "오전 08:00 ~ 오후 18:30", "짜장면\n파인애플\n함-바그스테이크\n콩자반");
                        fragment.addCard("카페테리아3", "오전 08:00 ~ 오후 18:30", "짜장면\n파인애플\n함-바그스테이크\n콩자반");
                        fragment.addCard("카페테리아3", "오전 08:00 ~ 오후 18:30", "짜장면\n파인애플\n함-바그스테이크\n콩자반");
                        fragment.addCard("카페테리아3", "오전 08:00 ~ 오후 18:30", "짜장면\n파인애플\n함-바그스테이크\n콩자반");
                        fragment.addCard("카페테리아3", "오전 08:0 ~ 오후 18:30", "짜장면\n파인애플\n함-바그스테이크\n콩자반");
                        break;
                    case 2:
                        fragment.addCard("맘스터치3", "오전 10:00 ~ 오후 15:00", "냠냠\n고구마돈까스\n치즈고구마돈까스\n빅돈까스");
                        fragment.addCard("맘스터치3", "오전 10:00 ~ 오후 15:00", "냠냠\n고구마돈까스\n치즈고구마돈까스\n빅돈까스");
                        fragment.addCard("맘스터치3", "오전 10:00 ~ 오후 15:00", "냠냠\n고구마돈까스\n치즈고구마돈까스\n빅돈까스");
                        fragment.addCard("맘스터치3", "오전 10:00 ~ 오후 15:00", "냠냠\n고구마돈까스\n치즈고구마돈까스\n빅돈까스");
                        fragment.addCard("맘스터치3", "오전 10:00 ~ 오후 15:00", "냠냠\n고구마돈까스\n치즈고구마돈까스\n빅돈까스");
                        break;
                    case 3:
                        fragment.addCard("샤샤3", "오전 11:00 ~ 오후 16:00", "신라면\n진라면\n떡라면\n치즈라면\n치즈떡라면");
                        fragment.addCard("샤샤3", "오전 11:00 ~ 오후 16:00", "신라면\n진라면\n떡라면\n치즈라면\n치즈떡라면");
                        fragment.addCard("샤샤3", "오전 11:00 ~ 오후 16:00", "신라면\n진라면\n떡라면\n치즈라면\n치즈떡라면");
                        fragment.addCard("샤샤3", "오전 11:00 ~ 오후 16:00", "신라면\n진라면\n떡라면\n치즈라면\n치즈떡라면");
                        fragment.addCard("샤샤3", "오전 11:00 ~ 오후 16:00", "신라면\n진라면\n떡라면\n치즈라면\n치즈떡라면");
                        break;
                    case 4:
                        fragment.addCard("낭창3", "오전 11:00 ~ 오후 12:00", "연어초밥\n우동\n새우튀김\n감자튀김");
                        fragment.addCard("낭창3", "오전 11:00 ~ 오후 12:00", "연어초밥\n우동\n새우튀김\n감자튀김");
                        fragment.addCard("낭창3", "오전 11:00 ~ 오후 12:00", "연어초밥\n우동\n새우튀김\n감자튀김");
                        fragment.addCard("낭창3", "오전 11:00 ~ 오후 12:00", "연어초밥\n우동\n새우튀김\n감자튀김");
                        fragment.addCard("낭창3", "오전 11:00 ~ 오후 12:00", "연어초밥\n우동\n새우튀김\n감자튀김");
                        fragment.addCard("낭창3", "오전 11:00 ~ 오후 12:00", "연어초밥\n우동\n새우튀김\n감자튀김");
                        break;
                }
        }
    }
}