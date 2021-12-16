package com.example.all4sportapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

    public class Bdd {

            public boolean vrai;
            private static final String dbURL = "jdbc:mysql://localhost:3308/all4sport?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            private static final String username = "root";
            private static final String password = "";
            private String recupemail;
            private String recupmdp;


            public Connection connexion() {

                Connection conn = null;
                try {
                    conn = DriverManager.getConnection(dbURL, username, password);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                return conn;
            }

            public boolean authentifie(String nom, String mdp) {
                Connection conn = connexion();

                try {

                    if (conn != null) {
                        System.out.println("Connected");
                        String sql = "SELECT email, mdp FROM utilisateur where email like ? and mdp like ?;";

                        PreparedStatement statement = conn.prepareStatement(sql);
                        ((PreparedStatement) statement).setString(1, nom);
                        statement.setString(2, mdp);
                        statement.execute();
                        ResultSet result = statement.getResultSet();

                        while (result.next()) {
                            recupemail=result.getString("email" );
                            recupmdp=result.getString("mdp");
                            vrai = true;
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();

                }
                return vrai;

            }
    }



