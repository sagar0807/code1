package gov.naco.soch.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gov.naco.soch.constructordto.GlobalReportsDto;

@Repository
public class GlobalReportsRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<GlobalReportsDto> getReportsDetails(int roleId) {

		String sql = "select * from soch.global_reports gr where gr.role_id  = ?";

		return jdbcTemplate.query(sql, new Object[] { roleId }, new GlobalReportsMapper());

	}

}

class GlobalReportsMapper implements RowMapper<GlobalReportsDto> {

	@Override
	public GlobalReportsDto mapRow(ResultSet rs, int rowNum) throws SQLException {

		GlobalReportsDto globalReportsDto = new GlobalReportsDto();
		globalReportsDto.setReportid(rs.getInt("report_id"));
		globalReportsDto.setModuleOrder(rs.getInt("module_order"));
		globalReportsDto.setModuleName(rs.getString("module_name"));
		globalReportsDto.setSubModuleOrder(rs.getInt("sub_module_order"));
		globalReportsDto.setSubModuleName(rs.getString("sub_module_name"));
		globalReportsDto.setReportOrder(rs.getInt("report_order"));
		globalReportsDto.setReportName(rs.getString("report_name"));
		String url = rs.getString("url");
		if (url != null && !url.isEmpty()) {
			url = url.trim();
		}
		globalReportsDto.setUrl(url);
		globalReportsDto.setUrl(rs.getString("url"));
		globalReportsDto.setRoleId(rs.getInt("role_id"));

		return globalReportsDto;

	}
}
