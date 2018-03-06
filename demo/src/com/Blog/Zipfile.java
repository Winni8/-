package com.Blog;

import java.io.File;

import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.io.Zip;

public class Zipfile {
	public static void main(String[] args) {
		Zip zip =new Zip();
		try{
			//将制定文件压缩成一个zip压缩包；
			zip.zip(new File("D:\\记录"),new File("E:\\记录.zip"));
			//判断一个文件是否是压缩文件；
			System.out.println(FileHandler.isZipped("E:\\记录.zip"));
			//讲一个文件解压
			//zip.unzip(new File("E:\\记录.zip"),new File("E:\\gg"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
