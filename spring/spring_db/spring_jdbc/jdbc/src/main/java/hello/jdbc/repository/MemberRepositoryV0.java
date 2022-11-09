package hello.jdbc.repository;


import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.NoSuchElementException;

import static hello.jdbc.connection.DBConnectionUtil.*;

/**
 * JDBC - DriverManager 사용
 */
@Slf4j
public class MemberRepositoryV0 {
    public void delete(String memberId) throws SQLException {
        String sql = "delete from member where member_id=?";
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memberId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null);
        }
    }
    public void update(String memberId, int money) throws SQLException {
        String sql = "update member set money=? where member_id=?";

        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();//DBConnectionUtil 를 통해서 데이터베이스 커넥션을 획득한다.
            pstmt = con.prepareStatement(sql);//데이터베이스에 전달할 SQL과 파라미터로 전달할 데이터들을 준비
            pstmt.setInt(1, money);
            pstmt.setString(2, memberId);

            //executeUpdate() 는 쿼리를 실행하고 영향받은 row수를 반환한다.
            // 여기서는 하나의 데이터만 변경하기 때문에 결과로 1이 반환된다.
            // 만약 회원이 100명이고, 모든 회원의 데이터를 한번에 수정하는 update sql 을 실행하면 결과는 100이 된다.
            int resultSize = pstmt.executeUpdate();
            log.info("resultSize={}",resultSize);
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con,pstmt,null);
        }
    }


    public Member save(Member member) throws SQLException {
        String sql = "insert into member(member_id, money) values (?,?)";//데이터베이스에 전달할 SQL을 정의

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();//DBConnectionUtil 를 통해서 데이터베이스 커넥션을 획득한다.
            pstmt = con.prepareStatement(sql);//데이터베이스에 전달할 SQL과 파라미터로 전달할 데이터들을 준비
            pstmt.setString(1, member.getMemberId());//SQL의 첫번째 ? 에 값을 지정한다. 문자이므로 setString 을 사용한다.
            pstmt.setInt(2, member.getMoney());//SQL의 두번째 ? 에 값을 지정한다. Int 형 숫자이므로setInt 를 지정한다.
            pstmt.executeUpdate();//Statement 를 통해 준비된 SQL을 커넥션을 통해 실제 데이터베이스에 전달한다
            return member;
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con,pstmt,null);
        }
    }

    public Member findById(String memberId) throws SQLException {
        String sql = "select * from member where member_id = ?";//데이터 조회를 위한 select SQL

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,memberId);

            //데이터를 변경할 때는 executeUpdate() 를 사용하지만, 데이터를 조회할 때는 executeQuery() 를 사용한다.
            //executeQuery() 는 결과를 ResultSet 에 담아서 반환한다.
            //ResultSetd 내부에는 커서가 있다.
            rs = pstmt.executeQuery();
            if (rs.next()){//rs.next() : 이것을 호출하면 커서가 다음으로 이동한다.
                Member member = new Member();
                member.setMemberId(rs.getString("member_id"));//현재 커서가 가리키고 있는 위치의 member_id 데이터를 String 타입으로 반환한다.
                member.setMoney(rs.getInt("money"));//현재 커서가 가리키고 있는 위치의 money 데이터를 int 타입으로 반환한다.

                return member;
            }else {//커서에서 데이터가 없을때?
                throw new NoSuchElementException("member not found memberId =" + memberId);
            }
        } catch (SQLException e) {
            log.error("db error",e);
            throw e;
        }finally {
            close(con,pstmt,rs);
        }
    }



    /**
     *쿼리를 실행하고 나면 리소스를 정리해야 한다. 여기서는 Connection , PreparedStatement 를 사용했다.
     *리소스를 정리할 때는 항상 역순으로 해야한다.
     *Connection 을 먼저 획득하고 Connection 을 통해 PreparedStatement 를 만들었기 때문에
     *리소스를 반환할 때는 PreparedStatement 를 먼저 종료하고, 그 다음에 Connection 을 종료하면 된다.
     *참고로 여기서 사용하지 않은 ResultSet 은 결과를 조회할 때 사용한다.
     *
     * <주의>
     * 리소스 정리는 꼭! 해주어야 한다. 따라서 예외가 발생하든, 하지 않든 항상 수행되어야 하므로 finally 구문에 주의해서 작성해야한다.
     * 만약 이 부분을 놓치게 되면 커넥션이 끊어지지 않고 계속 유지되는 문제가 발생할 수 있다.
     * 이런 것을 리소스 누수라고 하는데, 결과적으로 커넥션 부족으로 장애가 발생할 수 있다.
     */
    private void close(Connection con, Statement stmt, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }

        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                log.info("error", e);
            }
        }
        if (con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                log.info("error",e);
            }

        }
    }
}
