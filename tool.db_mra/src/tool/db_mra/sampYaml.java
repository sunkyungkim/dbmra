package tool.db_mra;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import org.yaml.snakeyaml.Yaml;

public class sampYaml {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Map<String, Object> propMap = new Yaml().load(new FileReader("config/dbmra.yml"));
			System.out.println(propMap);						
			System.out.println(propMap.getClass());						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}