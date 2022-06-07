package com.optilog.log.jdbc;

import com.optilog.log.LogEvent;
import com.optilog.log.Optilog;
import com.optilog.util.OnlyInInit;
import com.optilog.util.OnlyInLog;

import java.sql.*;

public class MySQL {
    public volatile Connection conn;

    public volatile boolean sendToJdbc = false;

    @OnlyInInit
    public static void initAppender(String url, String username, String password, Optilog instance) {
        try (Statement statement = instance.connection.conn.createStatement()) {
            statement.execute("CREATE TABLE logs (id BIGINT AUTO_INCREMENT NOT NULL, lvl VARCHAR(10) NOT NULL, class VARCHAR(100) NOT NULL, message VARCHAR(900) NOT NULL, AllMessage VARCHAR(90000) NOT NULL, PRIMARY KEY(id)) Engine=INNODB DEFAULT CHARSET=UTF8;");
            instance.connection.conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            instance.connection = null;
            e.printStackTrace();
        }
    }

    @OnlyInLog
    public static void logAppender(LogEvent logEvent, String clazz, String previousMessage, Optilog instance) {
        try (PreparedStatement ps = instance.connection.conn.prepareStatement("INSERT INTO students (lvl, class, message, AllMessage) VALUES (?,?,?,?)")) {
            ps.setObject(1, logEvent.level); // 注意：索引从1开始
            ps.setObject(2, clazz); // grade
            ps.setObject(3, previousMessage);
            ps.setObject(4, logEvent.message); // gender
            int n = ps.executeUpdate(); // 1
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
