package common.designPattern.template.templateJDBC;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class JdbcTemplate {
    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql,RowMapper<?> rowMapper,Object[] values){
        try{

            Connection conn = this.getConnection();

            PreparedStatement pstm = this.createPrepareStatement(conn,sql);

            ResultSet rs = this.executeQuery(pstm,values);

            List<?> result = this.paresResultSet(rs,rowMapper);

            this.closeResultSet(rs);

            this.closeStatement(pstm);

            this.closeConnection(conn);

            return result;

        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }

    protected void closeConnection(Connection conn) throws Exception{
        conn.close();
    }

    protected void closeStatement(PreparedStatement pstm) throws Exception{
        pstm.close();
    }

    protected  void closeResultSet(ResultSet rs) throws Exception{
        rs.close();
    }

    protected List<?> paresResultSet(ResultSet rs,RowMapper<?> rowMapper) throws Exception{
        List<Object> result = new ArrayList<>();
        int rowNum =1;
        while(rs.next()){
            result.add(rowMapper.mapRow(rs,rowNum ++));
        }
        return result;
    }

    protected ResultSet executeQuery(PreparedStatement pstm,Object[] values) throws  Exception{
        for(int i=0;i<values.length;i++){
            pstm.setObject(i,values[i]);
        }
        return pstm.executeQuery();
    }

    protected PreparedStatement createPrepareStatement(Connection conn,String sql) throws  Exception{
        return conn.prepareStatement(sql);
    }

    public Connection getConnection() throws Exception{
        return this.dataSource.getConnection();
    }
}
