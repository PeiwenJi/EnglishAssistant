package admin;

import java.io.File;
import java.io.IOException;

public class Backup {
	
	public Backup(String root,String rootPass,String dbName,String backupsPath,String backupsSqlFileName) throws IOException, InterruptedException
	{
		StringBuffer sbs = new StringBuffer();
		String pathSql = backupsPath+"\\"+backupsSqlFileName;
		try {
			File fileSql = new File(pathSql);
			if(!fileSql.exists()){
				fileSql.createNewFile();
			}
		} catch (Exception e) {
			
		}
		sbs.append("mysqldump ");
		sbs.append("-u");
		sbs.append(root+" ");
		sbs.append("-p"+rootPass+" ");
		sbs.append(dbName);
		sbs.append(" --default-character-set=utf8 ");
		sbs.append("--result-file="+pathSql);
		System.out.println(sbs.toString());
	    try{
	    	Runtime runtime = Runtime.getRuntime();	    	
	        runtime.exec(sbs.toString());
	        System.out.println("Backup success!");
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
}