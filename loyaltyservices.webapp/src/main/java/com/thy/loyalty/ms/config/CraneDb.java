package com.thy.loyalty.ms.config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jforce.connectors.DBResultSet;
import com.jforce.connectors.oracle.Connector;

public class CraneDb {
	
	private static Log logger = LogFactory.getLog(CraneDb.class);

	public CraneDb() {
		super();
	
	}


	public static int executeQuery(String query) throws java.sql.SQLException,
			NamingException {
		Connector con = getConnection();
		int i = -1;
		try {
			i = con.setData(query);
			con.commit();
		} finally {
			con.disconnectDB();
		}
		return i;
	}

	public static DBResultSet getResultSet(String query)
			throws NamingException, SQLException {
		Connector con = getConnection();
		DBResultSet rs = null;
		try {
			rs = con.getData(query);
		} finally {
			con.disconnectDB();
		}
		return rs;
	}

	public static String testDb() {

		try {
			Connector con = getConnection();
			DBResultSet rs = null;
			try {
				rs = con.getData("Select 'Database is running... Control time : '|| systimestamp ||' as ' ||SYS_context('USERENV','CURRENT_SCHEMA') from dual");
			} finally {
				con.disconnectDB();
			}
			return rs.getRow(0)[0];
		} catch (NamingException e) {
			//e.printStackTrace();
			logger.error(StringUtils.stack2string( e ) );
			return "NamingException";
		} catch (SQLException e) {
			//e.printStackTrace();
			logger.error(StringUtils.stack2string( e ) );
			return "SQLException";
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error(StringUtils.stack2string( e ) );
			return "Exception";
		}
	}

	public static Connector getPoolConnection() throws NamingException,
			SQLException {

		Connector con = null;
		con = new Connector();

		try {

			Properties props = new Properties();
			props.put(InitialContext.INITIAL_CONTEXT_FACTORY,
					"weblogic.jndi.WLInitialContextFactory");
			props.put(InitialContext.PROVIDER_URL,
					"t3://" + Config.getInstance().LOYALTYSERVICES_DATASOURCE_IP);

			InitialContext ctx = new InitialContext(props);

			DataSource ds = (DataSource) ctx
					.lookup(Config.getInstance().LOYALTYSERVICES_DATASOURCE_NAME);

			con.conn = ds.getConnection();
			con.conn.setAutoCommit(false);
			con.setData("ALTER SESSION SET NLS_SORT = TURKISH");
			return con;

		} catch (SQLException e) {
			con.disconnectDB();
			//e.printStackTrace();
			logger.error(StringUtils.stack2string( e ) );
			throw e;
		} catch (NamingException e) {
			//e.printStackTrace();
			logger.error(StringUtils.stack2string( e ) );
			throw e;
		}
	}

	public static Connector getMSPoolConnection() throws NamingException,
	SQLException {

		Connector con = null;
		con = new Connector();

		try {

			Properties props = new Properties();
			props.put(InitialContext.INITIAL_CONTEXT_FACTORY,
					"weblogic.jndi.WLInitialContextFactory");
			props.put(InitialContext.PROVIDER_URL,
					"t3://" + Config.getInstance().MSSERVICES_DATASOURCE_IP);

			InitialContext ctx = new InitialContext(props);

			DataSource ds = (DataSource) ctx
					.lookup(Config.getInstance().MSSERVICES_DATASOURCE_NAME);

			con.conn = ds.getConnection();
			con.conn.setAutoCommit(false);
			con.setData("ALTER SESSION SET NLS_SORT = TURKISH");
			return con;

		} catch (SQLException e) {
			con.disconnectDB();
			//e.printStackTrace();
			logger.error(StringUtils.stack2string( e ) );
			throw e;
		} catch (NamingException e) {
			//e.printStackTrace();
			logger.error(StringUtils.stack2string( e ) );
			throw e;
		}
	}
	
	public static Connector getConnection() throws NamingException,
			SQLException {

		if (Config.getInstance().CONNECTION_TYPE.equals("POOL")) {
			return getPoolConnection();
		} else if (Config.getInstance().CONNECTION_TYPE.equals("DIRECT")) {
			return getDirectConnection();
		}

		return getPoolConnection();

	}

	public static Connector getDirectConnection() throws NamingException,
			SQLException {
		
		//TODO exedata db'ye uyumlu degil.. kullanilacaksa guncellenmeli

		Connector con = new Connector();
		con.connectDB("10.11.96.21", 1521, "TEST01", "anadolujet", "rdn456w34"); // 
		
		con.conn.setAutoCommit(false);
		con.setData("ALTER SESSION SET NLS_SORT = TURKISH");
		return con;

	}

	public static int getSequence(String sequenceName){
		
		int seq=0;
		
		Connector con = null;
    	String sql = "SELECT "+sequenceName+".nextval FROM dual";
    	
    	try {
    		con = CraneDb.getConnection();
    		Statement stmt = con.conn.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);
    		
    		if(rs.next()) {
    			seq = rs.getInt(1);
    		}
    		
    		con.disconnectDB();
    		
    	} catch (ArrayIndexOutOfBoundsException aioobe) {
    		seq = -1;
    	} catch (SQLException e) {
    		seq = -2;
    	} catch (NamingException e) {
    		seq = -3;
		} finally {
    		con.disconnectDB();
    	}
		
		return seq;
	}

}