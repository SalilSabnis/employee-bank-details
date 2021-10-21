package com.salil.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BankUserService {

	@Autowired
	@Qualifier("snowflakeJdbctemplate")
	protected NamedParameterJdbcTemplate namedJdbcTemplateSnowflake;

	public List getAllBankDetails() {

		String query = "select * from bank_details";
		MapSqlParameterSource params = null;

		List<Map<String, Object>> results = namedJdbcTemplateSnowflake.queryForList(query, params);

		return results;
	}

	public List getBankDetails(String bankId) {

		String query = "select * from bank_details where bank_id = "+bankId;
		MapSqlParameterSource params = null;

		List<Map<String, Object>> results = namedJdbcTemplateSnowflake.queryForList(query, params);

		return results;
	}

	public List getAllUserBankDetails() {

		String query = "select user_first_name,user_last_name,user_pan_no"
				+ ",bank_name,bank_branch,bank_ifsc_code from user_bank_details ubd join bank_details bd on"
				+ " ubd.bank_id=bd.bank_id; ";
		MapSqlParameterSource params = null;

		List<Map<String, Object>> results = namedJdbcTemplateSnowflake.queryForList(query, params);

		return results;
	}

	public List getUserBankDetails(String userId) {

		String query = "select user_first_name,user_last_name,user_pan_no"
				+ ",bank_name,bank_branch,bank_ifsc_code from user_bank_details ubd join bank_details bd on"
				+ " ubd.bank_id=bd.bank_id "
				+ " where user_pan_no = '"+userId+"'";
		MapSqlParameterSource params = null;

		List<Map<String, Object>> results = namedJdbcTemplateSnowflake.queryForList(query, params);

		return results;
	}

}
