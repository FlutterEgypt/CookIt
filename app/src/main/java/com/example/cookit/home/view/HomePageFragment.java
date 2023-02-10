package com.example.cookit.home.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.cookit.R;
import com.example.cookit.home.presenter.HomePagePresenter;
import com.example.cookit.home.presenter.HomePresenter;
import com.example.cookit.model.MealModel;
import com.example.cookit.model.retrofit.Category;
import com.example.cookit.model.retrofit.Country;
import com.example.cookit.model.retrofit.Repository;
import com.example.cookit.network.APIResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePageFragment extends Fragment implements HomeViewInterface,OnHomeClickLisenterInterface {

    RecyclerView mealRecyclerView;
    RecyclerView category;
    RecyclerView country;

    HomePresenter homePagePresenter;
    LinearLayoutManager mealLayoutManager, CategorieLayoutManager,countryLayoutManager;
    RecycleCountryAdepter recycleCountryAdepter;
    RecycleCategoryAdepter recycleCategoryAdepter;
    ViewPagerAdepter viewPagerAdepter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        mealLayoutManager = new LinearLayoutManager(view.getContext());
        CategorieLayoutManager = new LinearLayoutManager(view.getContext());
        countryLayoutManager = new LinearLayoutManager(view.getContext());

        recycleCountryAdepter = new RecycleCountryAdepter(view.getContext(),new ArrayList<>());
        recycleCategoryAdepter = new RecycleCategoryAdepter(view.getContext(),new ArrayList<>());
         viewPagerAdepter = new ViewPagerAdepter(view.getContext(),new ArrayList<>());

        homePagePresenter=new HomePagePresenter(this, Repository.getInstance(APIResponse.getInstance(),view.getContext()));

        mealRecyclerView.setLayoutManager(mealLayoutManager);
        mealRecyclerView.setAdapter(viewPagerAdepter);

        category.setLayoutManager(CategorieLayoutManager);
        category.setAdapter(recycleCategoryAdepter);

        country.setLayoutManager(countryLayoutManager);
        country.setAdapter(recycleCountryAdepter);

        mealRecyclerView.setHasFixedSize(true);
        category.setHasFixedSize(true);
        country.setHasFixedSize(true);

        mealLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        CategorieLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        countryLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

        homePagePresenter.getRandomMeal();
        homePagePresenter.getCategoriesList();
        homePagePresenter.getCountriesList();

    }
     private void initUI(View view){
         mealRecyclerView = view.findViewById(R.id.viewPager);
         category = view.findViewById(R.id.categoryRecycler);
         country = view.findViewById(R.id.countryRecycler);

    }
    @Override
    public void ViewRandomMeal(List<MealModel> models) {
        viewPagerAdepter.setViewPagerAdepterList(models);
        viewPagerAdepter.notifyDataSetChanged();
    }

    @Override
    public void ViewCountriesList(List<Country> models) {
        System.out.println("All Categories :"+models.get(0).getStrArea());
        recycleCountryAdepter.setRecycleCountryAdepterList(models);
        recycleCountryAdepter.notifyDataSetChanged();
    }

    @Override
    public void ViewCategoriesList(List<Category> models) {

        recycleCategoryAdepter.setCategoryModelList(models);
        recycleCategoryAdepter.notifyDataSetChanged();
    }

    @Override
    public void addMealToFav(MealModel Meal) {

    }


    @Override
    public void addMealToFavClick(MealModel model) {

    }

    @Override
    public void nevToItemPage(MealModel model) {

    }
}