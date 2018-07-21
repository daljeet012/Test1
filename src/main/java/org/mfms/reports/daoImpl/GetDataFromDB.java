package org.mfms.reports.daoImpl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mfms.reports.dao.GetDataFromDBItr;
import org.mfms.reports.dto.DailyTxnDataDTO;
import org.mfms.reports.dto.FilterDTO;
import org.mfms.reports.main.Main;
import org.springframework.jdbc.core.RowMapper;


public class GetDataFromDB implements GetDataFromDBItr {
	
	private static GetConnection getConnection;
	
	public static List<DailyTxnDataDTO> getRetailerDataForDateRange(FilterDTO filterDTO) {
	
		GetConnection getConnection = Main.context.getBean("getConnection",GetConnection.class);

		String query = "select * from XX_DAILY_TXN_DATA_TAB where RETAILER_id = ? AND DATE_OF_TXN BETWEEN ? AND ? ORDER BY DATE_OF_TXN";
		
		List<DailyTxnDataDTO> list = getConnection.getJdbcTemplate().query(query, 
				new Object[] {filterDTO.getRetailerId(), 
				filterDTO.getFromDate(), filterDTO.getToDate()}, 
				new DailyTxnDataDTOMapper());

		for(DailyTxnDataDTO dto : list){
			dto.setDistrictName(filterDTO.getDistrictName());
			dto.setBlockName(filterDTO.getBlockName());
			dto.setRetailerId(filterDTO.getRetailerId());
		}
		
		return list;

			}

	
	public static List<DailyTxnDataDTO> getBlockDataForDateRange(FilterDTO filterDTO) {

		GetConnection getConnection = Main.context.getBean("getConnection",GetConnection.class);
			
		String query = "select DISTRICT, BLOCK_NAME, DATE_OF_TXN, SUM(NO_OF_BILLS) AS NO_OF_BILLS, SUM(NO_OF_TXN) AS NO_OF_TXN, SUM(QTY_SOLD) AS QTY_SOLD"
					+ " from XX_DAILY_TXN_DATA_TAB where DISTRICT = ? and BLOCK_NAME = ? and DATE_OF_TXN BETWEEN ? and ? "
					+ "GROUP BY (DISTRICT, BLOCK_NAME, DATE_OF_TXN) ORDER BY DISTRICT, BLOCK_NAME, DATE_OF_TXN";
			
		List<DailyTxnDataDTO> list = getConnection.getJdbcTemplate().query(query, 
										new Object[] {filterDTO.getDistrictName(), filterDTO.getBlockName(), 
										filterDTO.getFromDate(), filterDTO.getToDate()}, 
										new DailyTxnDataDTOMapper());
		
		for(DailyTxnDataDTO dto : list){
			dto.setDistrictName(filterDTO.getDistrictName());
			dto.setBlockName(filterDTO.getBlockName());
			dto.setRetailerId(filterDTO.getRetailerId());
		}

		return list;
			
	}
	
	private static final class DailyTxnDataDTOMapper implements RowMapper<DailyTxnDataDTO>{
		@Override
		public DailyTxnDataDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			DailyTxnDataDTO dTxnDTO = Main.context.getBean("dailyTxnDTO",DailyTxnDataDTO.class);

		      dTxnDTO.setDateOfTxn((resultSet.getString( "DATE_OF_TXN" )).substring(0, 10));
		      dTxnDTO.setNoOfBills(resultSet.getInt("NO_OF_BILLS" ));
		      dTxnDTO.setNoOfTxn(resultSet.getInt("NO_OF_TXN" ));
		      dTxnDTO.setQuantitySold(resultSet.getDouble("QTY_SOLD" ));		
			  
		      return dTxnDTO;
		}
	}
	
}
