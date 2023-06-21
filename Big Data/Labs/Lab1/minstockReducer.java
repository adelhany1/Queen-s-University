
// Adel Abdelfatah  ID: 20398047

package minstock;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class minstockReducer extends Reducer<Text, FloatWritable, Text, FloatWritable>{

	@Override
	protected void reduce(Text key, Iterable<FloatWritable> values,
			Reducer<Text, FloatWritable, Text, FloatWritable>.Context context) throws IOException, InterruptedException {
		float minp = Float.MAX_VALUE;
		for(FloatWritable value : values) {
			minp = Math.min(minp, value.get());
			
		}
		context.write(key, new FloatWritable(minp));
	
	
		
	}	
}
