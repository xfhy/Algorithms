package util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author : xfhy
 * Create time : 2020/8/15 9:41 上午
 * Description : 忽略该文件,,,,拿来文件命名的
 */
public class FileUtil {

    public static void main(String[] args) {

        File file = new File("/Users/xfhy/use/Github/Algorithms/notAdd");
        File[] dirs = file.listFiles();
        for (File dir : dirs) {
            if (!dir.isDirectory()) {
                continue;
            }
            File[] files = dir.listFiles();
            List<File> list = Arrays.asList(files);
            Collections.sort(list);
            for (File file1 : list) {
                /*String file1Name = file1.getName().replaceAll("\\.", "")
                        .replaceAll("md","\\.md")
                        .replaceAll("剑指\\sOffer","剑指Offer")
                        .replaceAll("offer","Offer")
                        .replaceAll(" ", "_");*/
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("- ").append("[")
                        .append(file1.getName().replaceAll("\\.md", "").replaceAll("_", " "))
                        .append("]")
                        .append("(")
                        .append(File.separator)
                        .append("doc")
                        .append(File.separator)
                        .append(dir.getName())
                        .append(File.separator)
                        .append(file1.getName())
                        .append(")");

                StringBuilder url = new StringBuilder();
                url.append(File.separator)
                        .append("doc")
                        .append(File.separator)
                        .append(dir.getName())
                        .append(File.separator)
                        .append(file1.getName());

                String result = "";
                try {
                    result = URLEncoder.encode(url.toString(), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                result = result.replaceAll("%3A", ":").replaceAll("%2F", "/").replaceAll("\\+", "%20");//+实际上是 空格 url encode而来

                System.out.println(stringBuilder.toString());
                //System.out.println(result);


                //boolean renameTo = file1.renameTo(new File(dir.getAbsolutePath(), file1Name));
            }
            System.out.println();
        }
    }

}
