import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroDAO
{
    private String Sqlusername="root";
    private String Sqluserpassword="admin";
    private PreparedStatement pstmt;
    private Connection con = null;
    String drivername = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://127.0.0.1:3306/test?useSLL=false/useUnicode=true&characterEncoding=utf8";
    public HeroDAO() throws ClassNotFoundException, SQLException
    {
        Class.forName(drivername);
        con= DriverManager.getConnection(url,Sqlusername,Sqluserpassword);
    }

    public Hero get(int id) throws SQLException
    {
        Hero hero=null;
        String sql="select * from hero where id =?";
        pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,id);
        pstmt.executeQuery();
        ResultSet rs=pstmt.getResultSet();
        if(rs.next())
        {
            hero=new Hero(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4));
        }
        return hero;
    }

    public void add(Hero hero) throws SQLException
    {
        String sql="insert into hero values(?,?,?,?)";
        pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,hero.id);
        pstmt.setString(2,hero.name);
        pstmt.setFloat(3,hero.hp);
        pstmt.setInt(4,hero.damage);
        pstmt.execute();
    }

    public void delete(int id) throws SQLException
    {
        String sql="delete from hero where id=?";
        pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,id);
        pstmt.execute();
    }

    public void update(Hero hero) throws SQLException
    {
        String sql="update hero set name=?,hp=?,damage=? where id=?";
        pstmt=con.prepareStatement(sql);
        pstmt.setString(1,hero.name);
        pstmt.setFloat(2, hero.hp);
        pstmt.setInt(3,hero.damage);
        pstmt.setInt(4, hero.id);
        pstmt.execute();
    }

    public List<Hero> list() throws SQLException
    {
        List<Hero> heroList=new ArrayList<>();
        String sql="select * from hero";
        pstmt=con.prepareStatement(sql);
        pstmt.executeQuery();
        ResultSet rs=pstmt.getResultSet();
        while(rs.next())
        {
            Hero hero=new Hero(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4));
            heroList.add(hero);
        }
        return heroList;
    }

    public int getTotal() throws SQLException
    {
        int total=0;
        String sql = "select count(*) from hero";
        ResultSet rs = pstmt.executeQuery(sql);
        while (rs.next()) {
            total = rs.getInt(1);
        }
        System.out.println("total:" + total);
        return total;
    }

}
