import java.sql.*;

public class Sql {


    static String driverName = "org.postgresql.Driver";
    static String url = "jdbc:postgresql://localhost:5432/postgres";
    static Connection con;


    public void select() {
        String query = "SELECT LOC FROM DEPT WHERE DNAME = 'LAW' ";
        Statement st;
        ResultSet rs;
        ResultSetMetaData metaData;
        int columnCount;
        String printedColumn = "";

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            metaData = rs.getMetaData();
            columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                printedColumn += columnName + " ";
            }
            System.out.println(printedColumn);

            while (rs.next()) {
                String row = "";
                for (int i = 1; i <= columnCount; i++) {
                    row += rs.getString(i) + " ";
                }
                System.out.println(row);
            }
        } catch (SQLException exc){
            System.out.println("Nieudane połączenie z " + url);
        }
    }

    public void insert() {
        String query = "INSERT INTO DEPT VALUES(50, 'MARKETING', 'WARSAW')";
        Statement st;
        try {
            st = con.createStatement();
           System.out.println(st.executeUpdate(query));
        } catch (SQLException ex){
            System.out.println("Błąd");
        }
    }

    public void delete(){
        String query = "DELETE FROM DEPT WHERE  DEPTNO = 50";
        Statement st;
        try {
            st = con.createStatement();
            System.out.println(st.executeUpdate(query));
        } catch (SQLException ex){
            System.out.println("Błąd");
        }
    }

    public void update(){
        String query = "UPDATE DEPT SET DNAME = 'LAW' WHERE DNAME = 'MARKETING'";
        Statement st;
        try {
            st = con.createStatement();
            System.out.println(st.executeUpdate(query));
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {

        try {
            Sql sql = new Sql();
            Class.forName(driverName);
            con = DriverManager.getConnection(url);

            sql.select();


        } catch (ClassNotFoundException ex){
        System.out.println("Brak klasy sterownika");
        } catch (SQLException ex){
            System.out.println("Nieudane połączenie z " + url);
            }



    }
}
