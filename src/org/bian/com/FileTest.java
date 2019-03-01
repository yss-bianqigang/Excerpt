package org.bian.com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileTest {
	
	public static void main(String[] args){
		try{
			File oldFile = new File("E:/OldFile.txt");
			FileInputStream fis = new FileInputStream(oldFile);
			byte byt[] = new byte[256];
			int ss = fis.read(byt);
			String s = new String(byt, 0, ss);
			s = new String(s.getBytes("GBK"),"GBK");
			System.out.println(s);
			fis.close();
			
			File newFile = new File("E:/newn.txt");
			FileOutputStream fos = new FileOutputStream(newFile);
			fos.write(s.getBytes("GBK"));
			fos.close();
		}catch(Exception q){
			
		}
		
		
		
		
		
//		BufferedReader bufr = null;
//		BufferedWriter bufw = null;
//		try{
//			File oldFile = new File("E:/OldFile.txt");
//			FileInputStream fis = new FileInputStream(oldFile);
//			InputStreamReader isr = new InputStreamReader(fis,"GBK");
//			bufr = new BufferedReader(isr);
//			File newFile = new File("E:/NewFile.txt");
//			FileOutputStream fos = new FileOutputStream(newFile); // 转换成文件输出流
//			OutputStreamWriter osr = new OutputStreamWriter(fos,"GBK"); //将字节流转换成字符流
//			bufw = new BufferedWriter(osr);//将字符流再转换成缓冲流
//			String s = null;
//			int i = 0;
//			while((s = bufr.readLine())!=null){
//				i++;
//				System.out.println("第"+i+"行"+s);
//				bufw.write(s);
//				bufw.newLine();
//			}
//			fis.close();
//			isr.close();
//			bufr.close();
//			bufw.close();
//			osr.close();
//			fos.close();
//		}catch(Exception q){
//			
//		}
	}
}
