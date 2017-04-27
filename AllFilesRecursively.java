
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class AllFilesRecursively 
{
	public static void listFiles(FileSystem fs) throws IOException
	{
		Path path = new Path("/user/acadgild");  
		FileStatus[] status = fs.listStatus(path);
		System.out.println("These are the files and directory and file within directory in this location :/user/acadgild/");
		for(FileStatus st : status)
		{
			System.out.println("  "+st.getPath().toString());
			
			FileStatus[] status2 = fs.listStatus(st.getPath());
			if(!fs.isFile(st.getPath()))
			{
				for(FileStatus st2 : status2)
				System.out.println("  "+st2.getPath().toString());
			}
	    }

}	

public static void main(String args[]) throws IOException
{
	Configuration conf = new Configuration();
	conf.addResource(new Path("/usr/local/hadoop-2.6.0/etc/hadoop/core-site.xml"));
	conf.addResource(new Path("/usr/local/hadoop-2.6.0/etc/hadoop/hdfs-site.xml"));
	
	FileSystem fs = FileSystem.get(conf);
	listFiles(fs);
	
	fs.close();
}

}
