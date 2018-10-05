package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDBConnect {


        private String host = null;
        private String port = null;
        private String databaseName = null;
        private boolean useSSL = false;
        private String username = null;
        private String password = null;

        public void newMethod(){};

        public MySQLDBConnect(String host, String port, String databaseName, String username, String password) throws SQLException {
            this.host = host;
            this.port = port;
            this.databaseName = databaseName;
            this.username = username;
            this.password = password;
        }

        public Connection getConnetion() throws SQLException {
            String url = String.format("jdbc:mysql://%s:%s/%s?useSSL=%s",this.host,this.port,this.databaseName,this.useSSL+"");
            Connection newConnection = DriverManager.getConnection(url,this.username, this.password);
            return newConnection;
        }

        public Connection createConnection(String host, String port, String databaseName, String username, String password) throws SQLException {
            this.host = host;
            this.port = port;
            this.databaseName = databaseName;
            this.username = username;
            this.password = password;
            String url = String.format("jdbc:mysql://%s:%s/%s?useSSL=%s",this.host,this.port,this.databaseName,this.useSSL+"");
            Connection newConnection = DriverManager.getConnection(url,this.username, this.password);
            return newConnection;
        }

        public Connection createConnection(String host, String port, String databaseName, String username, String password, boolean useSSL) throws SQLException {
            this.host = host;
            this.port = port;
            this.databaseName = databaseName;
            this.username = username;
            this.password = password;
            this.useSSL = useSSL;
            String url = String.format("jdbc:mysql://%s:%s/%s?useSSL=%s",this.host,this.port,this.databaseName,this.useSSL+"");
            Connection newConnection = DriverManager.getConnection(url,this.username, this.password);
            return newConnection;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getPort() {
            return port;
        }

        public void setPort(String port) {
            this.port = port;
        }

        public String getDatabaseName() {
            return databaseName;
        }

        public void setDatabaseName(String databaseName) {
            this.databaseName = databaseName;
        }

        public boolean isUseSSL() {
            return useSSL;
        }

        public void setUseSSL(boolean useSSL) {
            this.useSSL = useSSL;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    }


