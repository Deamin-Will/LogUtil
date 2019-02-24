package com.megabit.utils.log;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Log {

	static public boolean OPTION_TIMEON = false;
	static SimpleDateFormat ft = new SimpleDateFormat ("[yyyy.MM.dd hh:mm:ss] : ");
		
	static public void write(String msg, String filepath){
		
		File file = new File(filepath);
		FileWriter writer = null;
		
		try{
			// Using continuously writing
			writer = new FileWriter(file, true);
			
			// Adding Time format
			if(OPTION_TIMEON){	
				Date dNow = new Date( ); 
				writer.write(ft.format(dNow));
			}
			writer.write(msg);
			writer.write("\r\n");
			writer.flush();
			
			// Abb.println("Done");
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try {
				if(writer != null) writer.close();
			} catch(IOException e){
				e.printStackTrace();
			}			
		}
		
	}
	
	static public void write(String msg, String... filepathes){
		for(String filepath : filepathes){
			write(msg, filepath);
		}
	}
	
}
