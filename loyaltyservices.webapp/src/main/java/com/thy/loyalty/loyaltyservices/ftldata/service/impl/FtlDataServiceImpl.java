package com.thy.loyalty.loyaltyservices.ftldata.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleTypes;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.jforce.connectors.oracle.Connector;
import com.thy.loyalty.loyaltyservices.ftldata.dto.FtlDataDetail;
import com.thy.loyalty.loyaltyservices.ftldata.dto.FtlDataRecord;
import com.thy.loyalty.loyaltyservices.ftldata.dto.FtlDataResult;
import com.thy.loyalty.loyaltyservices.ftldata.service.IFtlDataService;
import com.thy.loyalty.ms.config.StringUtils;
import com.thy.loyalty.ms.config.TrophyDb;
import com.thy.loyalty.ms.utility.dto.Utils;
import com.thy.ws.header.request.RequestHeader;

@Service
public class FtlDataServiceImpl implements IFtlDataService {

	private static Log logger = LogFactory.getLog(FtlDataServiceImpl.class);
	private static final String ServiceName = "FtlDataService";

	@Override
	public FtlDataResult getFtlDataList(FtlDataDetail ftlDataDetail,
			RequestHeader requestHeader) throws Exception {
		FtlDataResult result = new FtlDataResult();
		String partnerCode = "";
		String partnerUserName = "";
		String channelCode = "";
		String airlineCode = "";
		String application = "";
		String agent = "";
		String language = "";

		logger.info("tropya_external.get_tkne_selling_class has been called..");
		Connector con = null;
		java.sql.CallableStatement cs = null;
		try {
			partnerCode = requestHeader.getClientCode();
			partnerUserName = requestHeader.getClientUsername();
			channelCode = (requestHeader.getChannel() == null) ? "" : Utils
					.validateChannelType(requestHeader.getChannel());
			airlineCode = requestHeader.getAirlineCode();
			application = requestHeader.getApplication();
			agent = requestHeader.getAgent();
			language = (requestHeader.getLanguageCode() == null) ? "EN" : Utils
					.validateRequestLanguage(requestHeader.getLanguageCode());

			con = TrophyDb.getConnection();
			String query = "begin\n"
					+ "  -- Call the procedure\n"
					+ "  tropya.tropya_external.get_tkne_selling_class(p_pnrno => :p_pnrno,\n"
					+ "                                                p_flightno => :p_flightno,\n"
					+ "                                                p_name => :p_name,\n"
					+ "                                                p_srname => :p_srname,\n"
					+ "                                                p_dep_date => :p_dep_date,\n"
					+ "                                                p_recordset => :p_recordset);\n"
					+ "end;";

			cs = con.prepareCall(query);
			cs.setString(1, ftlDataDetail.getPnrNo());
			cs.setInt(2, ftlDataDetail.getFlightNo());
			cs.setString(3, ftlDataDetail.getName());
			cs.setString(4, ftlDataDetail.getSurname());
			cs.setInt(5, ftlDataDetail.getDepDate());
			cs.registerOutParameter(6, OracleTypes.CURSOR);
			con.getData(cs);
			OracleResultSet rs = (OracleResultSet) cs.getObject(6);
			ArrayList<FtlDataRecord> getFtlDataList = new ArrayList<FtlDataRecord>();
			if (rs != null) {
				while (rs.next()) {
					FtlDataRecord ftlDataRecord = new FtlDataRecord();
					ftlDataRecord.setPnrNo(rs.getString("PNR_NO"));
					ftlDataRecord
							.setSellingClass(rs.getString("SELLING_CLASS"));
					ftlDataRecord
							.setTicketNumber(rs.getString("TICKET_NUMBER"));
					ftlDataRecord.setFqTv(rs.getString("FQTV"));
					getFtlDataList.add(ftlDataRecord);
				}
				result.setGetFtlDataList(getFtlDataList);
				result.setResultCode("00");
			} else {
				result.setResultCode("01");
			}

		} catch (Exception e) {
			logger.error("Error in tropya.tropya_external.get_tkne_selling_class "
					+ StringUtils.stack2string(e));
		} finally {
			try {
				cs.close();

			} catch (SQLException e) {
				logger.error("Error in " + ServiceName + " (SQLException) "
						+ StringUtils.stack2string(e));
			}

			con.disconnectDB();
		}
		return result;
	}

}
