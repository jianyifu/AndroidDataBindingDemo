package com.fjy.androiddatabindingdemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.fjy.androiddatabindingdemo.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    Employee employee = new Employee("Jianyi","Fu");
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        binding.firstName.setText(employee.getFirstName());
//        binding.lastName.setText(employee.getLastName());
//        binding.setEmployee(employee);
        binding.setVariable(BR.employee,employee);
        binding.setPresenter(new Presenter());
    }
    public class Presenter{
        //严格按照EditText的onTextChanged的方法签名书写
        public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
            employee.setLastName(text.toString());
            binding.setEmployee(employee);
        }
        //自定义的onclick事件
        public void onClick(Employee employee){
            Toast.makeText(MainActivity.this,employee.getFirstName()+"被点击了",Toast.LENGTH_SHORT).show();
        }
    }
}
