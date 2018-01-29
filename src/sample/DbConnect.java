package sample;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnect {
//Глобальные структуры и переменные

    public List<String> JeuList = new ArrayList<>();
    public List<Slim> AddrList = new ArrayList<Slim>();
    public List<String> SysList = new ArrayList<>();

//
    Connection c = null;
    Statement stmt = null;
    
/////////////////////////////
//Рабочие методы
    void GetJeuList(String str){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:kip.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            JeuList.clear();
            try (ResultSet rs = stmt.executeQuery( "SELECT " + str  + " FROM objects" )) {

                while (rs.next()) {
                    String jeu   = new String(String.valueOf(rs.getString("Num_Jeu")));//.getBytes("ISO-8859-1"), "cp1251");
                    JeuList.add(jeu);
                }
                Set<String> hs = new HashSet<>();
                hs.addAll(JeuList);
                JeuList.clear();
                JeuList.addAll(hs);
                JeuList.sort(null);
            }
            stmt.close();
            c.close();
        } catch ( ClassNotFoundException | SQLException e ) {  //UnsupportedEncodingException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    void GetSysList(String str){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:kip.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            //SysList.clear();
            try (ResultSet rs = stmt.executeQuery( "SELECT " + str  + " FROM objects" )) {

                while (rs.next()) {
                    String sis   = new String(String.valueOf(rs.getString("Sistema")));//.getBytes("ISO-8859-1"), "cp1251");
                    SysList.add(sis);
                }
                Set<String> hs = new HashSet<>();
                hs.addAll(SysList);
                SysList.clear();
                SysList.addAll(hs);
                SysList.sort(null);
            }
            stmt.close();
            c.close();
        } catch ( ClassNotFoundException | SQLException e ) {  //UnsupportedEncodingException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    void GetAddrList(String str, String str2){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:kip.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();

            Slim slim = new Slim();
            try (ResultSet rs = stmt.executeQuery( "SELECT * FROM objects WHERE Num_Jeu ='" + str + "' AND Sistema = '" + str2 + "' ")) {

                while (rs.next()) {
                    String addr   = new String(String.valueOf(rs.getString("Adres_Doma")));
                    String ndom   = new String(String.valueOf(rs.getString("Num_Doma")));
                    String idom   = new String(String.valueOf(rs.getString("Num_korp")));
                    slim.setAddr(addr);
                    slim.setNdom(ndom);
                    slim.setIdom(idom);
                    AddrList.add(slim);
                }
                Set<Slim> hs = new HashSet<>();
                hs.addAll(AddrList);
                AddrList.clear();
                AddrList.addAll(hs);
                AddrList.sort(null);
            }
            stmt.close();
            c.close();
        } catch ( ClassNotFoundException | SQLException e ) {  //UnsupportedEncodingException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

    }











    /*   void GetAddrList(String str, String str2){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:kip.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            AddrList.clear();
            try (ResultSet rs = stmt.executeQuery( "SELECT * FROM objects WHERE Num_Jeu ='" + str + "' AND Sistema = '" + str2 + "' ")) {

                while (rs.next()) {
                    String addr   = new String(String.valueOf(rs.getString("Adres_Doma")));//.getBytes("ISO-8859-1"), "cp1251");
                    String ndom   = new String(String.valueOf(rs.getString("Num_Doma")));//.getBytes("ISO-8859-1"), "cp1251");
                    String idom   = new String(String.valueOf(rs.getString("Num_korp")));//.getBytes("ISO-8859-1"), "cp1251");
                    AddrList.add(addr + " " + ndom + " " + idom);
                }
                Set<String> hs = new HashSet<>();
                hs.addAll(AddrList);
                AddrList.clear();
                AddrList.addAll(hs);
                AddrList.sort(null);
            }
            stmt.close();
            c.close();
        } catch ( ClassNotFoundException | SQLException e ) {  //UnsupportedEncodingException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

    }
    */
}
