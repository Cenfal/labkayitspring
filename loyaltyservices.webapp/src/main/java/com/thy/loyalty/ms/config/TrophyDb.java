package com.thy.loyalty.ms.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jforce.connectors.oracle.Connector;

public class TrophyDb {

	private static Log logger = LogFactory.getLog(TrophyDb.class);

	public TrophyDb() {
		super();

	}

	public static Connector getPoolConnection() throws NamingException,
			SQLException {

		Connector con = null;
		con = new Connector();

		try {

			Properties props = new Properties();
			props.put(InitialContext.INITIAL_CONTEXT_FACTORY,
					"weblogic.jndi.WLInitialContextFactory");
			props.put(
					InitialContext.PROVIDER_URL,
					"t3://"
							+ Config.getInstance().TROPHYSERVICES_DATASOURCE_IP);

			InitialContext ctx = new InitialContext(props);

			DataSource ds = (DataSource) ctx
					.lookup(Config.getInstance().TROPHYSERVICES_DATASOURCE_NAME);

			con.conn = ds.getConnection();
			con.conn.setAutoCommit(false);
			con.setData("ALTER SESSION SET NLS_SORT = TURKISH");
			return con;

		} catch (SQLException e) {
			con.disconnectDB();
			// e.printStackTrace();
			logger.error(StringUtils.stack2string(e));
			throw e;
		} catch (NamingException e) {
			// e.printStackTrace();
			logger.error(StringUtils.stack2string(e));
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

		return null;
	}
}
