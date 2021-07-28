package com.example.hotelreservationandroidapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.hotelreservationandroidapp.Guest;
import com.example.hotelreservationandroidapp.HotelGuestData;
import com.example.hotelreservationandroidapp.R;
import com.example.hotelreservationandroidapp.Guest;
import com.example.hotelreservationandroidapp.HotelGuestData;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;
import java.util.List;

public class HotelGuestDetailsFragment extends Fragment  {

    Button confirmSearchButton;
    View view;
    SharedPreferences sharedPreferences;
    public static final String myPreference = "myPref";
    List<Guest> guest= new ArrayList<Guest>();
    Guest guestObj=null;
    HotelGuestData guestData=null;
    private String hotelName,hotelPrice,hotelAvailability,guestCount,checkIn,checkOut;
    int j=10;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.hotel_guest_details_fragment, container, false);

        //try start

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        confirmSearchButton = (Button) view.findViewById(R.id.submit);
        confirmSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guestData = new HotelGuestData();
                guestData.setCheckin(checkIn);
                guestData.setCheckout(checkOut);
                guestData.setHotel_name(hotelName);

                for(int i=0;i<Integer.parseInt(guestCount);i++){
                    guestObj= new Guest();

                    EditText editText=(EditText) view.findViewById(j);
                    guestObj.setGuest_name(editText.getText().toString());
                    //guestObj.setGuest_name("AB");
                    int rg_id=i+200;
                    RadioGroup rg = (RadioGroup) view.findViewById(rg_id);
                    RadioButton rb= (RadioButton) view.findViewById(rg.getCheckedRadioButtonId());

                    guestObj.setGender(rb.getText().toString());
                    guest.add(guestObj);
                }
                guestData.setGuest_list(guest);
                postData(guestData);
            }
        });
        //try end
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        TextView hotelRecapTextView = view.findViewById(R.id.hotel_recap_text_view);
        hotelName = getArguments().getString("hotel name");
        hotelPrice = getArguments().getString("hotel price");
        hotelAvailability = getArguments().getString("hotel availability");
        checkIn = getArguments().getString("check in date");
        checkOut = getArguments().getString("check out date");

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("myPref", Context.MODE_PRIVATE);
        guestCount = sharedPreferences.getString("number of guests", "ABC");

        //try start
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.edit_text_elements);

        sharedPreferences = getActivity().getSharedPreferences(myPreference, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.commit();
        try{
            for(int i=0;i<Integer.parseInt(guestCount);i++){
                j=j+1;
                TextView tv = new TextView(getActivity());

                tv.setText("Name:");
                EditText editText = new EditText(getActivity());

                editText.setId(j); //Set id to remove in the future.
                //editText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
                editText.setText("");

                TextView gen = new TextView(getActivity());
                gen.setId(Integer.parseInt("23"));

                gen.setText("Gender :");

                RadioGroup rg= new RadioGroup(getActivity());
                rg.setId((i+200));

                RadioButton radioButton_m = new RadioButton(getActivity());
                radioButton_m.setText(" Male");
                radioButton_m.setId((j+29));

                RadioButton radioButton_f = new RadioButton(getActivity());
                radioButton_f.setText(" Female");
                radioButton_m.setId((j+69));
                rg.addView(radioButton_m);
                rg.addView(radioButton_f);
                TableRow row = new TableRow(getActivity());
                row.addView(rg);
                Log.d("View","Start");
                linearLayout.addView(tv);
                linearLayout.addView(editText);
                linearLayout.addView(gen);
                linearLayout.addView(row);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        hotelRecapTextView.setText("You have selected " +hotelName+ ". The cost will be $ "+hotelPrice+ " and availability is " +hotelAvailability+" and "+guestCount);
    }


    public  void getOTP(){
        try{
            JsonParser parser = new JsonParser();
            parser.parse(new Gson().toJson(guestData));
            int otp = (int)(Math.random()*(9999-1000+1)+1000);
            String otp_code=guestData.getHotel_name()+"_"+otp;
            Log.e("OTP: ", otp_code);
            sharedPreferences = getActivity().getSharedPreferences(myPreference, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString("OTP",otp_code);
            editor.commit();

            HotelConfirmation hotelConfirmationFragment = new HotelConfirmation();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_layout, hotelConfirmationFragment);
            fragmentTransaction.remove(HotelGuestDetailsFragment.this);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }
        catch(JsonSyntaxException jse){
            System.out.println("Not a valid Json String:"+jse.getMessage());
        }
    }

    private void postData(HotelGuestData guestData) {

        Log.e("Data check",guestData.getCheckin()+" "+guestData.getCheckout()+" "+guestData.getHotel_name());
        List<Guest> guest=guestData.getGuest_list();
        for (Guest gu:guest
        ) {
            Log.e("Name", gu.getGuest_name());
            Log.e("Gender", gu.getGender());
        }

        Log.e("JSON",new Gson().toJson(guestData));
        Api.getClient().postGuestDetails(guestData, new Callback<Object>() {
            @Override
            public void success(Object o, Response response) {
                Log.e("SUCESS postGuestDetails",response.getBody().toString());
                getOTP();
            }
            @Override
            public void failure(RetrofitError error) {
                Log.e("Error postGuestDetails",error.toString());
                getOTP();
            }
        });
    }
}
