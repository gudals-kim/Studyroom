package hello.jdbc.repository;


import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

import static hello.jdbc.connection.DBConnectionUtil.*;

/**
 * JDBC - DriverManager 사용
 */
@Slf4j
public class MemberRepositoryV0 {

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
