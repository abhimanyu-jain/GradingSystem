package model;
import java.sql.*;
import com.mchange.v2.c3p0.*;

public class DbUtil {
	
	/* global values */
	public static String mySQLurl = "jdbc:mysql://localhost:3306/gradingsystem?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	/* Course table column ids */
	public static int COURSE_ID = 1;
	public static int COURSE_NAME = 2;
	public static int COURSE_SEMESTER = 3;
	public static int COURSE_ACTIVE = 4;
	
	/* StudentType table column ids */
	public static int STUDENTTYPE_ID = 1;
	public static int STUDENTTYPE_NAME = 2;
	
	/* Student table column ids */
	public static int STUDENT_ID = 1;
	public static int STUDENT_FNAME = 2;
	public static int STUDENT_MNAME = 3;
	public static int STUDENT_LNAME = 4;
	public static int STUDENT_EMAIL = 5;
	public static int STUDENT_TYPE = 6;
	
	/* Enrolled table column ids */
	public static int ENROLLED_CORID = 1;
	public static int ENROLLED_SID = 2;
	public static int ENROLLED_NOTES = 3;
	
	/* Category table column ids */
	public static int CATEGORY_ID = 1;
	public static int CATEGORY_NAME = 2;
	public static int CATEGORY_CORID = 3;
	public static int CATEGORY_WEIGHT = 4;
	
	/* ScoringMethod table column ids */
	public static int SCORINGMETHOD_ID = 1;
	public static int SCORINGMETHOD_NAME = 2;
	
	/* GradedItem table column ids */
	public static int GRADEDITEM_ID = 1;
	public static int GRADEDITEM_NAME = 2;
	public static int GRADEDITEM_CATID = 3;
	public static int GRADEDITEM_MAXPOINTS = 4;
	public static int GRADEDITEM_SCORINGMETHOD = 5;
	public static int GRADEDITEM_WEIGHT = 6;
	public static int GRADEDITEM_INCLUDE = 7;
	
	/* StudentGrade table column ids */
	public static int STUDENTGRADE_SID = 1;
	public static int STUDENTGRADE_GID = 2;
	public static int STUDENTGRADE_SCORE = 3;
	public static int STUDENTGRADE_NOTES = 4;
	
	public static ComboPooledDataSource init() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setJdbcUrl(DbUtil.mySQLurl);
		dataSource.setUser("root");
		dataSource.setPassword(null); 
		return dataSource;
	}
	
	/* connection pool means we don't have to connect completely freshly
	   every time */
	public static ResultSet execute(Connection conn, String sql)
		throws SQLException {
		Statement stmt = conn.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
		return stmt.executeQuery(sql);
	}

}
