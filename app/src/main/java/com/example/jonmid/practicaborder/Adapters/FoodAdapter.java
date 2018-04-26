package com.example.jonmid.practicaborder.Adapters;

import android.content.Context;

import com.example.jonmid.practicaborder.Models.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter {

    List<Food> foodList = new ArrayList<>();
    Context context;

    public FoodAdapter(List<Food> foodList, Context context){
        this.foodList = foodList;
        this.context = context;
    }
}
