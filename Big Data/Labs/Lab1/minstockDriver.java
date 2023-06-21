
// Adel Abdelfatah  ID: 20398047

package minstock;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
//import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class minstockDriver { 
 
public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
	Configuration conf = new Configuration();
	Job job = new Job(conf);
	job.setJarByClass(minstockDriver.class);
	job.setMapperClass(minstockMapper.class);
	job.setNumReduceTasks(1);
	job.setReducerClass(minstockReducer.class);
	
	//common
	job.setOutputKeyClass(Text.class);
	job.setOutputValueClass(FloatWritable.class); 
	
	FileInputFormat.addInputPath(job, new Path(args[0]));
	FileOutputFormat.setOutputPath(job, new Path(args[1]));
	//FileSystem fs = FileSystem.get(conf);
	//fs.delete(new Path(args[1]));
	job.waitForCompletion(true);
	
}
}
