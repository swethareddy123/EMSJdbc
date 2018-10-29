package com.cg.ems.dao;

public interface QueryMapper
{
	public static final String SELECTQRY1="SELECT * FROM EMP160750";
	public static final String SELECTQRY2="SELECT * FROM EMP160750 WHERE EMP_ID=?";
	public static final String INSERTQRY1="INSERT INTO EMP160750 (160750,'SOUMYA',50000,'19-SEP-2018')";
	public static final String INSERTQRY2="INSERT INTO EMP160750 (EMP_ID,EMP_NAME,EMP_SAL,EMP_DOJ)"+
																"VALUES(161735,'HYNDHU',55000,'19-SEP-2018')";
	public static final String INSERTQRY3=" INSERT INTO EMP160750 (EMP_ID, EMP_NAME, EMP_SAL,EMP_DOJ)      VALUES(?,?,?,?)";
	public static final String DELETEQRY1="DELETE FROM EMP160750 WHERE EMP_ID=?";
	public static final String UPDATEQRY1="UPDATE EMP160750 SET EMP_NAME=?, EMP_SAL=? WHERE EMP_ID=?";
}
