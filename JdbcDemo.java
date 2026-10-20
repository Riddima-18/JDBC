import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "Nine11$"; // use your MySQL root password

        try (Connection con = DriverManager.getConnection(url, user, password)) {

            // INSERT using PreparedStatement
            String insertSql = "INSERT INTO student VALUES (?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(insertSql)) {

                ps.setInt(1, 101);
                ps.setString(2, "Rahul");
                ps.setString(3, "CSE");
                ps.executeUpdate();

                ps.setInt(1, 102);
                ps.setString(2, "Amit");
                ps.setString(3, "IT");
                ps.executeUpdate();

                ps.setInt(1, 103);
                ps.setString(2, "Neha");
                ps.setString(3, "ECE");
                ps.executeUpdate();

                System.out.println("Record Inserted");
            }

            // SELECT using Statement and ResultSet
            try (Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("SELECT * FROM student")) {

                while (rs.next()) {
                    System.out.println(
                        rs.getInt("id") + " " +
                        rs.getString("name") + " " +
                        rs.getString("branch")
                    );
                }
            }
        }
    }
}