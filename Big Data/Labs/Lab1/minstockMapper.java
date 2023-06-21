
// Adel Abdelfatah  ID: 20398047

package minstock;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class minstockMapper extends Mapper<LongWritable, Text, Text, FloatWritable>{

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, FloatWritable>.Context context)
			throws IOException, InterruptedException {
		

		String inputLine = value.toString();
		String[] Array = inputLine.split(",");
		
	try {
		context.write(new Text(Array[0]), new FloatWritable(Float.parseFloat(Array[5])));
	}
	catch (NumberFormatException e) {}
	}
}
