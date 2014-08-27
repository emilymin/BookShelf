package com.thoughtworks.utils;

import com.thoughtworks.exception.DataAccessException;
import com.thoughtworks.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtil{

    private static String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static String DB_URL = "jdbc:mysql://localhost:3306/BOOKSHELF?autoReconnect=true";
    private static String DB_NAME = "root";
    private static String DB_PWd = "";

    static {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_NAME, DB_PWd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static Statement getStatement(Connection conn) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }

    public static PreparedStatement getPreparedStatement(Connection conn, String sql) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstmt;
    }

    public static ResultSet getRs(Statement stmt, String sql) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static int update(String sql, List<String> parameterList) throws SQLException {
        System.out.println("enter update");
        String mySql = generateSQL(sql, parameterList);
        System.out.println(mySql);
        Statement statement = getPreparedStatement(getConnection(),mySql);
        return statement.executeUpdate(mySql);
    }

    public static <T> List<T> query(String sql, List<String> list, RowMapper<T> rowMapper) throws DataAccessException, SQLException {
        PreparedStatement statement = getPreparedStatement(getConnection(), sql);
        String mySql = generateSQL(sql, list);
        ResultSet result = statement.executeQuery(mySql);
        int rowNum = 0;
        List<T> bookList = new ArrayList<T>();
        if (result != null) {
            while (result.next()) {
                bookList.add(rowMapper.mapRow(result, ++rowNum));
            }
        }
        return bookList;
    }

    public static String generateSQL(String sql, List<String> parameterList){
        System.out.println("enter generateSQL");
        for (String s : parameterList){
            sql = sql.replaceFirst("\\?", s);
        }
        return sql;
    }
}
