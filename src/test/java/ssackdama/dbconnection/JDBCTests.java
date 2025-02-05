package ssackdama.dbconnection;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTests {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConnection() {

        try(Connection con =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/데이터베이스 이름?serverTimezone=Asia/Seoul",
                            "데이터베이스 사용자명",
                            "사용자 비밀번호")){
            System.out.println(con);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}
