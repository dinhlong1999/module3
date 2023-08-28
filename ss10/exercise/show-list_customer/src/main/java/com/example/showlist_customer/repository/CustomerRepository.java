package com.example.showlist_customer.repository;

import com.example.showlist_customer.model.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CustomerRepository implements ICustomerRepository {
    public static  List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer(1,"Mai Van Hoang", LocalDate.parse("1983-08-20"),"Ha Noi","https://tse3.mm.bing.net/th?id=OIP.u5H5lR_IgTYLCNE0rp4FcAHaFj&pid=Api&P=0&h=180"));
        customerList.add(new Customer(2,"Nguyen Van Nam", LocalDate.parse("1983-08-20"),"Da Nang","https://tse3.mm.bing.net/th?id=OIP.u5H5lR_IgTYLCNE0rp4FcAHaFj&pid=Api&P=0&h=180"));
        customerList.add(new Customer(3, "Nguyen Thai Hoa", LocalDate.parse("1983-08-20"),"Ha Noi","https://tse3.mm.bing.net/th?id=OIP.u5H5lR_IgTYLCNE0rp4FcAHaFj&pid=Api&P=0&h=180"));
        customerList.add(new Customer(4, "Tran Dang Khoa", LocalDate.parse("1983-08-20"),"Ha Noi","https://tse3.mm.bing.net/th?id=OIP.u5H5lR_IgTYLCNE0rp4FcAHaFj&pid=Api&P=0&h=180"));
    }

    @Override
    public List<Customer> showAll() {
        return customerList;
    }
}
