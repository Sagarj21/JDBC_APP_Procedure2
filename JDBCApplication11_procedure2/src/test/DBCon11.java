package test;
import java.sql.*;
import java.util.*;
public class DBCon11 {

	public static void main(String[] args) {
		try {
			Scanner s=new Scanner(System.in);
			System.out.println("enter accou t number");
			long accno=Long.parseLong(s.nextLine());
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","sagar");
			//loading driver automativaly and creating connection
			CallableStatement cs=con.prepareCall
					("{call RetrieveDetails41(?,?,?,?,?,?,?)}");
			cs.setLong(1,accno);
			cs.registerOutParameter(2,Types.VARCHAR);
			cs.registerOutParameter(3,Types.FLOAT);
			cs.registerOutParameter(4,Types.VARCHAR);
			cs.registerOutParameter(5,Types.VARCHAR);
			cs.registerOutParameter(6,Types.VARCHAR);
			cs.registerOutParameter(7,Types.BIGINT);
			cs.execute();
			System.out.println("customer name      "+cs.getString(2));
			System.out.println("balance       "+cs.getFloat(3));
			System.out.println("account type      "+cs.getString(4));
			System.out.println("address			"+cs.getString(5));
			System.out.println("mail id			"+cs.getString(6));
			System.out.println("phone number		"+cs.getLong(7));
			
			
			
			
			
			
			con.close();
			s.close();
			
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}

}
