package com.example.demo.DataBase;
import com.example.demo.Registration.*;
import java.sql.*;

public class DB{
    static final String DB_URL = "jdbc:postgresql://db.vxmcbqcizclgrmucashg.supabase.co:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "Salma/saeed/1911/z";

    public String addUser(User newuser){
        boolean valid = validateID(newuser.getId());
        if (valid) {
            final String QUERY = "insert into userprofile values(" + newuser.getId() + ",\"" +
                    newuser.getPassword() + "\",\"" + newuser.getName() + "\"," + newuser.getAge()
                    + "," + newuser.getWeight() + ",\"" + newuser.getBloodtype() + "\",\"" +
                    newuser.getAddress() + "\",\"" + newuser.getCity() + "\",\"" + newuser.getRegion() + "\");";
            System.out.println(QUERY);
            try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
            ) {
                String sql = "USE systemdb";
                stmt.executeUpdate(sql);
                stmt.executeUpdate(QUERY);
                System.out.println("User profile created successfully...");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return "valid";
        }
        else {
            System.out.println("please enter correct info");
            return "invalid";
        }
    }

    public boolean validateID(long id) {
        final String QUERY = "SELECT EXISTS(SELECT * from civilregistry WHERE id=" + id + ");";
        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            String sql = "USE systemdb";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);
            int valid = -1;
            while (rs.next()) {
                //Display values
                valid = rs.getInt("EXISTS(SELECT * from civilregistry WHERE id=" + id + ")");
            }
            if (valid == 1) {
                System.out.println("valid id");
                return true;
            } else if (valid == 0) {
                System.out.println("invalid id");
                return false;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    return false;
    }

    public boolean validateTAX(String tax) {
        final String QUERY = "SELECT EXISTS(SELECT * from authoritytax WHERE tax=" + tax + ");";
        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            String sql = "USE systemdb";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);

            int valid = -1;
            while (rs.next()) {
                //Display values
                valid = rs.getInt("EXISTS(SELECT * from authoritytax WHERE tax=" + tax + ")");
            }
            if (valid == 1) {
                System.out.println("valid tax");
                return true;
            } else if (valid == 0) {
                System.out.println("invalid tax");
                return false;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return false;
    }

    public String addAuthority(Authority newAuth){
        boolean valid = validateTAX(newAuth.getTax());
        if (valid){
            final String QUERY = "insert into authority values(\""+newAuth.getTax()
                    +"\",\""+newAuth.getPassword() +"\",\""+newAuth.getName()+"\",\""+newAuth.getEmail()
                    +"\",\""+newAuth.getPhone()+"\",\""+newAuth.getAddress()
                    +"\",\""+newAuth.getCity()+"\",\""+newAuth.getRegion()
                    +"\",\""+newAuth.getStartWork() +"\",\""+newAuth.getEndWork()
                    +"\",\""+newAuth.getDonationtimeFrom() +"\",\""+newAuth.getDonationtimeTo()+"\");\n";
            System.out.println(QUERY);
        final String QUERY2 = "insert into bagsNumber values(\""+newAuth.getTax()
                +"\",\""+newAuth.getE_Aplus()+"\",\""+newAuth.getE_Aminus()
                +"\",\""+newAuth.getE_Bplus()+"\",\""+newAuth.getE_Bminus()
                +"\",\""+newAuth.getE_ABplus()+"\",\""+newAuth.getE_ABminus()
                +"\",\""+newAuth.getE_Oplus()+"\",\""+newAuth.getE_Ominus()+"\");\n";
            try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
            ) {
                String sql = "USE systemdb";
                stmt.executeUpdate(sql);
                stmt.executeUpdate(QUERY);
                stmt.executeUpdate(QUERY2);
                System.out.println("authority profile created successfully...");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return "valid";
        }
        else {
            System.out.println("please enter correct info");
            return "invalid";
        }

    }

    ///signing in
    public boolean validateUser(long id, String pass){
        String QUERY = "SELECT EXISTS(SELECT * from userprofile WHERE id=" + id + ");";
        String QUERY2 = "SELECT userpassword from userprofile WHERE id=" + id + ";";
        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();

        ) {
            String sql = "USE systemdb";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);

            int valid = -1;
            while (rs.next()) {
                //Display values
                valid = rs.getInt("EXISTS(SELECT * from userprofile WHERE id=" + id + ")");
            }
            if (valid == 1) {
                rs = stmt.executeQuery(QUERY2);
                while (rs.next()) {
                    //Display values
                    String x = rs.getString("userpassword");
                    if(x.equals(pass)){
                        valid = 1;
                    }else {
                        valid = 0;
                    }
                }
                if (valid == 1){
                    return true;
                }else {
                    System.out.println("incorrect password");
                return false;
                }
            } else if (valid == 0) {
                System.out.println("invalid id");
                return false;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return false;

    }

    public boolean checkForNoduplicateUsers(long id){
        int num=0;
        DB start = new DB();
        final String QUERY = "select count(*) from userprofile where id="+id+";";
        System.out.println(QUERY);
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "USE systemdb";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                num = rs.getInt("count(*)");
                System.out.println("rs=="+num);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(num!=0){
            return true;
        }
        return false;
    }

    public User getUserData(long id, String pass){
//        user urData = new user();
        boolean ok = validateUser(id,pass);
        String QUERY = "SELECT * FROM systemdb.userprofile where id = "+id+";";
        if (ok){
            try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();

            ) {
                String sql = "USE systemdb";
                stmt.executeUpdate(sql);
                ResultSet rs = stmt.executeQuery(QUERY);

                while(rs.next()){
                    //Display values
                    Registration.userData.setId(rs.getLong("id"));
                    Registration.userData.setName(rs.getString("userName"));
                    Registration.userData.setAge(rs.getInt("age"));
                    Registration.userData.setWeight(rs.getInt("weight"));
                    Registration.userData.setBloodtype(rs.getString("bloodtype"));
                    Registration.userData.setAddress(rs.getString("address")); Registration.userData.setRegion(rs.getString("region"));
                    System.out.print("ID: " + rs.getLong("id"));
                    System.out.print(", Name: " + rs.getString("userName"));
                    System.out.print(", age: " + rs.getInt("age"));
                    System.out.println(", weight: " + rs.getInt("weight"));
                    System.out.println(", blood type: " + rs.getString("bloodtype"));
                    System.out.println(", address: " + rs.getString("address"));
                    System.out.println(", region: " + rs.getString("region"));
                }
                return Registration.userData;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Invalid data");
            return null;
        }
        return null;

    }

    public String getCity(String region){
        String city = "" ;
        String QUERY = "SELECT city FROM systemdb.regions where region = " + "\"" + region + "\"" + ";";
//        System.out.println(QUERY);
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();

        ) {
            String sql = "USE systemdb";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);
            while(rs.next()){
                city = rs.getString("city");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }




    ///authority
    public boolean validateAuthority(String tax, String pass){
        String QUERY = "SELECT EXISTS(SELECT * from authority WHERE tax='" +tax + "');";
        String QUERY2 = "SELECT authpassword from authority WHERE tax='" + tax + "';";
        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();

        ) {
            String sql = "USE systemdb";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);

            int valid = -1;
            while (rs.next()) {
                //Display values
                valid = rs.getInt("EXISTS(SELECT * from authority WHERE tax='" + tax + "')");
            }
            if (valid == 1) {
                rs = stmt.executeQuery(QUERY2);
                while (rs.next()) {
                    //Display values
                    String x = rs.getString("authpassword");
                    if(x.equals(pass)){
                        valid = 1;
                    }else {
                        valid = 0;
                    }
                }
                if (valid == 1){
                    return true;
                }else {
                    System.out.println("incorrect password");
                    return false;
                }
            } else if (valid == 0) {
                System.out.println("incorrect tax");
                return false;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return false;

    }

    public boolean checkForNoduplicateAuthorities(String tax){
        int num=0;
        DB start = new DB();
        final String QUERY = "select count(*) from authority where tax=" + "\"" + tax+ "\"" +";";
        System.out.println(QUERY);
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "USE systemdb";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                num = rs.getInt("count(*)");
                System.out.println("rs=="+num);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(num!=0){
            return true;
        }
        return false;
    }

    public Authority getAuthData(String tax, String pass){
//        authority urData = registration.authData;       //from registration class
        boolean ok = validateAuthority(tax, pass);
        String QUERY = "SELECT * FROM systemdb.authority where tax = '"+tax+"';";
        String QUERY1 = "SELECT * FROM systemdb.bagsnumber where tax = '"+tax+"';";
        if (ok){
            try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                Statement stmt1 = conn.createStatement();

            ) {
                String sql = "USE systemdb";
                stmt.executeUpdate(sql);
                stmt1.executeUpdate(sql);
                ResultSet rs = stmt.executeQuery(QUERY);
                ResultSet rs1 = stmt1.executeQuery(QUERY1);

                while(rs.next()){
                    //Display values
                    Registration.authData.setEmail(rs.getString("email"));
                    Registration.authData.setPhone(rs.getString("phone"));
                    Registration.authData.setName(rs.getString("authName"));
                    Registration.authData.setAddress(rs.getString("address"));
                    Registration.authData.setCity(rs.getString("city"));
                    Registration.authData.setRegion(rs.getString("region"));
                    Registration.authData.setTax(rs.getString("tax"));
                    Registration.authData.setStartWork(rs.getString("workinghours_start"));
                    Registration.authData.setEndWork(rs.getString("workinghours_close"));
                    Registration.authData.setDonationtimeFrom(rs.getString("donationtimeFrom"));
                    Registration.authData.setDonationtimeTo(rs.getString("donationtimeTo"));
                    System.out.print("email: " + rs.getString("email"));
                    System.out.print(", name: " + rs.getString("authName"));
                    System.out.print(", address: " + rs.getString("address"));
                    System.out.print(", city: " + rs.getString("city"));
                    System.out.print(", region: " + rs.getString("region"));
                    System.out.println(", start working at: " + rs.getString("workinghours_start"));
                    System.out.println(", close at: " + rs.getString("workinghours_close"));
                    System.out.println(", donation time from: " + rs.getString("donationtimeFrom"));
                    System.out.println(", donation time to: " + rs.getString("donationtimeTo"));

                }
                while(rs1.next()){
                    Registration.authData.setE_Aplus(rs1.getInt("Aplus_exist"));
                    Registration.authData.setE_Aminus(rs1.getInt("Aminus_exist"));
                    Registration.authData.setE_Bplus(rs1.getInt("Bplus_exist"));
                    Registration.authData.setE_Bminus(rs1.getInt("Bminus_exist"));
                    Registration.authData.setE_ABplus(rs1.getInt("ABplus_exist"));
                    Registration.authData.setE_ABminus(rs1.getInt("ABminus_exist"));
                    Registration.authData.setE_Oplus(rs1.getInt("Oplus_exist"));
                    Registration.authData.setE_Ominus(rs1.getInt("Ominus_exist"));
                }
                return Registration.authData;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
