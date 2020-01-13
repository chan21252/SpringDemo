package com.chan.spring.jdbc.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.chan.spring.jdbc.beans.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestJDBCTemplate {
    private static ApplicationContext ctx;
    private static JdbcTemplate jdbcTemplate;
    private static NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    static {
        ctx = new ClassPathXmlApplicationContext("com/chan/spring/jdbc/conf/applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");
    }

    @Test
    public void testDataSource() throws SQLException {
        DruidDataSource ds = (DruidDataSource) ctx.getBean("dataSource");
        System.out.println(ds);
    }


    /**
     * 测试更新
     */
    @Test
    public void testUpdate() {
        String sql = "UPDATE employee SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, "Kate", 1);
    }

    /**
     * 测试批量更新
     */
    @Test
    public void testBatchUpdate() {
        String sql = "INSERT INTO employee (name, email, department_id) VALUES (?, ?, ?)";
        List<Object[]> batchArgs = new ArrayList<Object[]>();
        batchArgs.add(new Object[]{"Tom", "tom@spring.com", 1});
        batchArgs.add(new Object[]{"Jerry", "jerry@spring.com", 2});
        batchArgs.add(new Object[]{"Bob", "bob@spring.com", 1});
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    /**
     * 测试从表中查询一条记录封装到实体对象
     */
    @Test
    public void testQueryForObject() {
        String sql = "SELECT id, name, email, department_id FROM employee WHERE id = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 3);
        System.out.println(employee);
    }

    /**
     * 查询多条记录
     */
    @Test
    public void testQueryForList() {
        //查询员工
        String sql = "SELECT id, name, email, department_id FROM employee WHERE id > ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
        List<Employee> employeeList = jdbcTemplate.query(sql, rowMapper, 3);
        System.out.println(employeeList);

        //查询员工姓名
        String sql2 = "SELECT name FROM employee WHERE id > ?";
        List<String> employeeNameList = jdbcTemplate.queryForList(sql2, String.class, 3);
        System.out.println(employeeNameList);
    }

    /**
     * 聚合查询
     */
    @Test
    public void testQueryForCount() {
        //查询员工
        String sql = "SELECT count(id) FROM employee";
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);
    }

    /**
     * 具名参数查询
     */
    @Test
    public void testUpdate2() throws Exception {
        String sql = "INSERT INTO employee (name, email, department_id) VALUES (:name, :email, :departmentId)";

        Employee employee = new Employee();
        employee.setName("Tim");
        employee.setEmail("tim@spring.com");
        employee.setDepartmentId(3);

        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(employee);

        int result = namedParameterJdbcTemplate.update(sql, parameterSource);
        System.out.println(result);

        assert (result == 1);
    }
}
