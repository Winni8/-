package com.Blog;

import java.io.File;

import org.openqa.selenium.io.FileHandler;

public class Copyfile {
	public static void main(String[] args) {
		try{
			//复制文件夹
			FileHandler.copy(new File("D:\\记录"), new File("D:\\记录1"));
			//将源目录下的所有文件夹和文件(后缀为.txt)复制到目的目录下
			FileHandler.copy(new File("D:\\记录"), new File("D:\\记录2"), ".txt");
			//复制某个文件
			FileHandler.copy(new File("D:\\记录3\\asd.txt"), new File("D:\\记录2\\1.txt"));
			
			
			/*//刪除文件
			FileHandler.delete(new File("D:\\记录2\\asd.txt"));
			//删除文件夹
			FileHandler.delete(new File("D:\\记录2\\hfh"));*/
			
			/*//创建目录
			FileHandler.createDir(new File("D:\\test 目录表"));
			*/
			
	        //判断文件是否为可执行文件
	        //如果是可执行文件，则打印“文件是可执行文件”
	        //否则，将文件变为可执行文件
	        if (FileHandler.canExecute(new File("D:\\记录"))) {
	            System.out.println("文件是可执行文件");
	        } else {
	            FileHandler.makeExecutable(new File("D:\\记录"));
	        }
	        //修改文件的权限使其变为可写文件
	        //FileHandler.makeWritable(new File("D:\\记录"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
