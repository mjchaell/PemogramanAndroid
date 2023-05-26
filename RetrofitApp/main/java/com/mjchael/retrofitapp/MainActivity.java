package com.mjchael.retrofitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView txtResult;
    private Button btnProd, btnUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnProd = findViewById(R.id.btnGetProduct);
        txtResult = findViewById(R.id.txtResult);
        btnUser =findViewById(R.id.btnGetUser);

        btnProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                APIList api = RetrofitClient.getRetrofitClient().create(APIList.class);
                Call<Products> call = api.getAllProducts();
                call.enqueue(new Callback<Products>() {
                    @Override
                    public void onResponse(Call<Products> call, Response<Products> response) {
                        if(response.isSuccessful()){
                            Products products = response.body();
                            ArrayList<Product> allProduct = products.getData();
                            String title = "";
                            for(Product i : allProduct){
                                title = title+"\n"+i.getId()+". "+i.getTitle();
                                title = title+"\n"+i.getDescription()+"\n";
                                txtResult.setText(title);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Products> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });
        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                APIList api = RetrofitClient.getRetrofitClient().create(APIList.class);
                Call<Users> call = api.getAllUsers();
                call.enqueue(new Callback<Users>() {
                    @Override
                    public void onResponse(Call<Users> call, Response<Users> response) {
                        if(response.isSuccessful()){
                            Users users = response.body();
                            ArrayList<User> allProduct = users.getData();
                            String title = "";
                            for(User i : allProduct){
                                title = title+"\n"+i.getId()+". "+i.getFirstName()+" "+i.getLastName();
                                title = title+"\n Email = "+i.getEmail();
                                title = title+"\n Username = "+i.getUsername();
                                title = title+"\n Password = "+i.getPassword()+"\n";
                                txtResult.setText(title);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Users> call, Throwable t) {

                    }
                });
            }
        });
    }
}