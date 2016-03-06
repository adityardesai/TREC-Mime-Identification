import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.tika.Tika;

public class NewTika {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("C:\\Users\\Aditya\\Desktop\\AOS\\AOS_NASA");
		//Path path = Paths.get("E:\\rawDataSet\\dataSet_Clean_100950");
		//Path path = Paths.get("E:\\TikaWorkspace\\FinalNewTika\\input");
		File dir = new File(path.toString());
		File[] files = dir.listFiles();
		Tika tika = new Tika();
		int countType = 0;
		Map<String, Integer> map = new HashMap<>();
		for(File f: files)
		{
			String detectFileType = tika.detect(f);
			
			//System.out.println(detectFileType);
		
				
				if(map.containsKey(detectFileType))
				{
					map.computeIfPresent(detectFileType, (k, v) -> v + 1);
				}
				else
				{
					map.put(detectFileType, 1);
				}
			}
		
		System.out.println("Results ");
		for(Entry<String, Integer> entry:map.entrySet())
		{
		
			System.out.println(entry.getKey() + " " + entry.getValue() );
		}
		
	}

}

