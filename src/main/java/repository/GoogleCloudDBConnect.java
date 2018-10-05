package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GoogleCloudDBConnect {

    private String databaseName;
    private String instanceConnectionName;
    private String username;
    private String password;

    public GoogleCloudDBConnect(String databaseName, String instanceConnectionName, String username, String password) {
        this.databaseName = databaseName;
        this.instanceConnectionName = instanceConnectionName;
        this.username = username;
        this.password = password;
    }

    public GoogleCloudDBConnect() {

    }

    /**
     * Google cloud connect logic found https://cloud.google.com/sql/docs/mysql/connect-external-app#java
     * */
    private Connection getConnection() throws SQLException {
        String jdbcUrl = String.format(
                "jdbc:mysql://google/%s?cloudSqlInstance=%s"
                        + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false",
                this.databaseName,
                this.instanceConnectionName);

        Connection connection = DriverManager.getConnection(jdbcUrl, this.username, this.password);
        return connection;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getInstanceConnectionName() {
        return instanceConnectionName;
    }

    public void setInstanceConnectionName(String instanceConnectionName) {
        this.instanceConnectionName = instanceConnectionName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
