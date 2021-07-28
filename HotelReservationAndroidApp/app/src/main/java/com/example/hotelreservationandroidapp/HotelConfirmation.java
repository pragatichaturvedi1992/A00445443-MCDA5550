package com.example.hotelreservationandroidapp;

import androidx.fragment.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class HotelConfirmation extends Fragment  {

    View view;
    TextView headingTextView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.hotel_confirmation, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //heading text view
        headingTextView = view.findViewById(R.id.hotel_confirmation);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("myPref", Context.MODE_PRIVATE);
        String otp = sharedPreferences.getString("OTP", "ABC");
        headingTextView.setBackgroundColor(Color.parseColor("#FFFFFF"));

        //Set up the header
        headingTextView.setText("Thank you for your reservation, your \n" +
                "reservation number is "+otp);



    }




}
