import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class reduce_log extends Reducer<Text, IntWritable, Text, IntWritable> {
	  Text maxWord = new Text();
	   int maxCount = 0;
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException,
    InterruptedException {
        int sum = 0;
     
        for (IntWritable val : values) {
            sum += val.get();
           
            
        }
        if (sum > maxCount) {
            maxCount = sum;
            maxWord.set(key);
        }
        
         
    }
    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        context.write(maxWord, new IntWritable(maxCount));
    }
    }
