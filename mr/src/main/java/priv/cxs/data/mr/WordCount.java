package priv.cxs.data.mr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/23 上午11:33
 **/
public class WordCount extends Configured implements Tool {

    private static final String DEFAULT_INPUT = "/user/xiaoshuang.cui/mapred/wordcount/input";

    private static final String DEFAULT_OUTPUT = "/user/xiaoshuang.cui/mapred/wordcount/output";

    public static void main(String[] args) throws Exception {

        int ret = ToolRunner.run(new Configuration(), new WordCount(), args);
        System.exit(ret);
    }

    public int run(String[] strings) throws Exception {
        Configuration conf = new Configuration();

        Path input = new Path(DEFAULT_INPUT);
        Path output = new Path(DEFAULT_OUTPUT);

        Job job = Job.getInstance(conf, "word_count");

        job.setJarByClass(WordCount.class);
        job.setMapperClass(TokenizerMapper.class);
        job.setCombinerClass(IntSumReducer.class);
        job.setReducerClass(IntSumReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, input);

        //remove output
        FileSystem fileSystem = output.getFileSystem(conf);
        if (fileSystem.exists(output)) {
            fileSystem.delete(output, true);
        }

        FileOutputFormat.setOutputPath(job, output);

        System.exit(job.waitForCompletion(true) ? 0 : 1);
        return 0;
    }

    private static class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable> {
        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();

        @Override
        protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {

            for (String split : value.toString().split("\t")) {
                word.set(split);
               context.write(word, one);
            }
        }

    }

    private static class IntSumReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

        @Override
        protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
            int sum = 0;
            for (IntWritable value : values) {
                Integer count = value.get();
                sum += count;
            }
            context.write(key, new IntWritable(sum));
        }
    }
}
