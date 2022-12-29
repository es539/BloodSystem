package com.example.demo.Registration;

public class Authority {
    String email;
    String password;
    String name;
    String address;
    String phone;
    String city;
    String region;
    String tax;
    String startWork;
    String endWork;
    String donationtimeFrom;
    String donationtimeTo;

    int E_Aplus; int E_Aminus;
    int E_Bplus; int E_Bminus;
    int E_ABplus; int E_ABminus;
    int E_Oplus; int E_Ominus;

    public int getE_Aplus() {
        return E_Aplus;
    }

    public void setE_Aplus(int e_Aplus) {
        E_Aplus = e_Aplus;
    }

    public int getE_Aminus() {
        return E_Aminus;
    }

    public void setE_Aminus(int e_Aminus) {
        E_Aminus = e_Aminus;
    }

    public int getE_Bplus() {
        return E_Bplus;
    }

    public void setE_Bplus(int e_Bplus) {
        E_Bplus = e_Bplus;
    }

    public int getE_Bminus() {
        return E_Bminus;
    }

    public void setE_Bminus(int e_Bminus) {
        E_Bminus = e_Bminus;
    }

    public int getE_ABplus() {
        return E_ABplus;
    }

    public void setE_ABplus(int e_ABplus) {
        E_ABplus = e_ABplus;
    }

    public int getE_ABminus() {
        return E_ABminus;
    }

    public void setE_ABminus(int e_ABminus) {
        E_ABminus = e_ABminus;
    }

    public int getE_Oplus() {
        return E_Oplus;
    }

    public void setE_Oplus(int e_Oplus) {
        E_Oplus = e_Oplus;
    }

    public int getE_Ominus() {
        return E_Ominus;
    }

    public void setE_Ominus(int e_Ominus) {
        E_Ominus = e_Ominus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartWork() {
        return startWork;
    }

    public void setStartWork(String startWork) {
        this.startWork = startWork;
    }

    public String getEndWork() {
        return endWork;
    }

    public void setEndWork(String endWork) {
        this.endWork = endWork;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getDonationtimeFrom() {
        return donationtimeFrom;
    }

    public void setDonationtimeFrom(String donationtimeFrom) {
        this.donationtimeFrom = donationtimeFrom;
    }

    public String getDonationtimeTo() {
        return donationtimeTo;
    }

    public void setDonationtimeTo(String donationtimeTo) {
        this.donationtimeTo = donationtimeTo;
    }
}
