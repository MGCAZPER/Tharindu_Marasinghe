package Modle;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author WW
 */
public class Login_logic {

    public boolean validateUser(String username, String password) {
        try {
            java.sql.Connection con = DBConnection.getInstance().GetConnection();
            java.sql.PreparedStatement pst = con
                    .prepareStatement("SELECT * FROM login  WHERE UserName = ? AND Password = ?");
            pst.setString(1, username);
            pst.setString(2, password);
            java.sql.ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
