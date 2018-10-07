package repository;

import java.sql.*;

public class MySQLDBConnect {

        private String host = null;
        private String port = null;
        private String databaseName = null;
        private boolean useSSL = false;
        private String username = null;
        private String password = null;
        private Connection connection = null;

        public void newMethod(){}

        private MySQLDBConnect(){}

        public MySQLDBConnect(String host, String port, String databaseName, String username, String password) throws SQLException {
            this.host = host;
            this.port = port;
            this.databaseName = databaseName;
            this.username = username;
            this.password = password;
            this.connection = createConnection(this.host,this.port,this.databaseName, this.username, this.password);
        }

        public Connection getConnection() throws SQLException {
            return this.connection ;
        }



        private Connection createConnection(String host, String port, String databaseName, String username, String password) throws SQLException {
            this.host = host;
            this.port = port;
            this.databaseName = databaseName;
            this.username = username;
            this.password = password;
            //jdbc:mysql://localhost:3306/?user=root
            String url = String.format("jdbc:mysql://%s:%s/%s",this.host,this.port,this.databaseName);
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                this.connection = DriverManager.getConnection(url,this.username, this.password);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return this.connection;
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


