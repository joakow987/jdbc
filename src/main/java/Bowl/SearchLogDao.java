package Bowl;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SearchLogDao {

    private static String driverName = "org.postgresql.Driver";
    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    private Connection con;

    public SearchLogDao(){
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url);
        } catch(ClassNotFoundException exc){
            System.err.println(exc);
        } catch (SQLException exc) {
            System.err.println(exc);
        }
    }


    public void insert(String searchPhrase, boolean isClicked, int selectedOption, LocalDateTime time) {
        String query = "INSERT INTO SEARCHLOG(SEARCH_PHRASE, IS_CLICKED, SELECTED_OPTION, SEARCH_TIME) VALUES(?, ?, ?, ?)";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, searchPhrase);
            ps.setBoolean(2, isClicked);
            ps.setInt(3, selectedOption);
            ps.setObject(4, time);
            ps.executeUpdate();
        } catch (SQLException exc) {
            System.err.println(exc);
        }
    }


    public ArrayList<SearchLog> select() {
        String query = "SELECT * FROM SEARCHLOG";
        Statement s;
        ResultSet rs;
        ArrayList<SearchLog> searchLogs = new ArrayList<>();

        try {
            s = con.createStatement();
            rs = s.executeQuery(query);
            while (rs.next()) {
                SearchLog searchLog = new SearchLog();
                searchLog.setId(rs.getLong("ID"));
                searchLog.setClicked(rs.getBoolean("IS_CLICKED"));
                searchLog.setSelectedOption(rs.getInt("SELECTED_OPTION"));
                searchLog.setTime(rs.getObject("SEARCH_TIME", LocalDateTime.class));
                searchLogs.add(searchLog);
            }
        } catch (SQLException exc) {
            System.err.println(exc);
        }
        return searchLogs;
    }

    public void deleteAll() {
        Statement s;
        String query = "DELETE FROM SEARCHLOG";


        try {
            s = con.createStatement();
            s.executeUpdate(query);
        } catch (SQLException exc) {
            System.err.println(exc);
        }
    }
}


