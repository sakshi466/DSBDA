import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class map_log extends Mapper<Object, Text, Text, IntWritable> {
	   Text word = new Text(); 
    public void map(Object offset, Text key, Context con) throws IOException, InterruptedException {
        StringTokenizer token = new StringTokenizer(key.toString(), " ");
        word.set(token.nextToken());
        con.write(word, new IntWritable(1));
        
        }
      
       
    }
