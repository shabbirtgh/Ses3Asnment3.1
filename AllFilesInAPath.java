import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class AllFilesInAPath 
{
	public static void listFiles(FileSystem fs) throws IOException
	{
		Path path = new Path("/user/acadgild" );    
		FileStatus[] status = fs.listStatus(path);
		System.out.println("These are the files and directory present within : /user/acadgild/");
		for(FileStatus st : status)
		{
			System.out.println("  "+st.getPath().toString());
			
			//System.out.println("Owner  : "+st.getOwner().toString());
			//System.out.println("Is File  : "+st.isFile());
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
